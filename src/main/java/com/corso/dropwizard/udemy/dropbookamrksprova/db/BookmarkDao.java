package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import org.hibernate.SessionFactory;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.BookMark;
import io.dropwizard.hibernate.AbstractDAO;

public class BookmarkDao extends AbstractDAO<BookMark>{

	public BookmarkDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
