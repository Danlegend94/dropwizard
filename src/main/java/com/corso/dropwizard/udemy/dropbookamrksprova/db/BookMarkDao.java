package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.Bookmark;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.jersey.params.LongParam;

public class BookMarkDao extends AbstractDAO<Bookmark>{

	public BookMarkDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Bookmark save(Bookmark bookmark) {
        return persist(bookmark);
    }
	
	public Optional<Bookmark> findById(LongParam id) {
		Optional<Bookmark> bookmark = Optional.fromNullable(uniqueResult(namedQuery("Bookmark.findById")
				.setParameter("id", id.get())));
		if(bookmark == null) {
			Optional.absent();
		}
		return bookmark;
	}
	
	
	
	public List<Bookmark> findAll(){
		return list(namedQuery("Bookmark.findAll"));
	}
	
	public Bookmark update(Bookmark bookmark, LongParam id) {
        Optional<Bookmark> exists = findById(id);
		
		try {
			BeanUtils.copyProperties(bookmark, exists.get());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return persist(bookmark);
    }
	
	public void delete(LongParam id) {
		namedQuery("Bookmark.remove")
        .setParameter("id", id)
        .executeUpdate();
	}

	
}
