package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import java.util.List;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.Bookmark;
import com.google.common.base.Optional;

public interface BookmarkDaoService {
	
	Bookmark save(Bookmark bookmark);
	Optional<Bookmark> findById(Long id);
	List<Bookmark> findAll();
	Bookmark update(Bookmark bookmark, Long id);
	void delete(Long id);
}
