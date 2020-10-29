package com.corso.dropwizard.udemy.dropbookamrksprova.db.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.Bookmark;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.BookmarkDaoService;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;

public class BookMarkDaoServiceImpl extends AbstractDAO<Bookmark> implements BookmarkDaoService{

	public BookMarkDaoServiceImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@Override
	public Bookmark save(Bookmark bookmark) {
        return persist(bookmark);
    }
	
	@Override
	public Optional<Bookmark> findById(Long id) {
		Optional<Bookmark> bookmark = Optional.fromNullable(uniqueResult(namedQuery("Bookmark.findById")
				.setParameter("id", id)));
		if(bookmark == null) {
			return Optional.absent();
		}
		return bookmark;
	}
	
	@Override
	public List<Bookmark> findAll(){
		return list(namedQuery("Bookmark.findAll"));
	}
	
	@Override
	public Bookmark update(Bookmark bookmark, Long id) {
        Optional<Bookmark> exists = findById(id);
		exists.get().setDescription(bookmark.getDescription());
		exists.get().setUrl(bookmark.getUrl());
		return persist(exists.get());
    }
	
	
	public void delete(Long id) {
		namedQuery("Bookmark.remove")
        .setParameter("id", id)
        .executeUpdate();
	}

	
}
