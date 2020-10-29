package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import java.util.List;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.google.common.base.Optional;

public interface UserDaoService {
	
	User save(User user);
	Optional<User> findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	User update(User user, User update);
	void delete(Long id);

}
