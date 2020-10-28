package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.Bookmark;
import io.dropwizard.hibernate.AbstractDAO;

public class BookMarkDao extends AbstractDAO<Bookmark>{

	public BookMarkDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<Bookmark> findByUserId(Long id) {
        return list(namedQuery("Bookmark.findByUserId")
                .setParameter("id", id));
    }

    public Optional<Bookmark> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    
    public Optional<Bookmark> findByIdAndUserId(Long id, Long userId) {
        return Optional.ofNullable(uniqueResult(namedQuery("Bookmark.findByIdAndUserId")
                        .setParameter("id", id)
                        .setParameter("userId", userId)));
        }
   
    public Bookmark save(Bookmark bookmark) {
        return persist(bookmark);
    }

    public void delete(Integer id) {
        namedQuery("Bookmark.remove")
                .setParameter("id", id)
                .executeUpdate();
    }

}
