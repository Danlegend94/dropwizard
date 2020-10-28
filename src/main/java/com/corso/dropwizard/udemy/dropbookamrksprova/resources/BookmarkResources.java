package com.corso.dropwizard.udemy.dropbookamrksprova.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.Bookmark;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.BookMarkDao;
import com.google.common.base.Optional;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("bookmark")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookmarkResources {

	private BookMarkDao bookmarkDAO;

	public BookmarkResources(BookMarkDao bookmarkDAO) {
		this.bookmarkDAO = bookmarkDAO;
	}

	// ok
	@Path("all")
	@GET
	@UnitOfWork
	public List<Bookmark> findAll() {
		return bookmarkDAO.findAll();
	}

	// ok
	@POST
	@UnitOfWork
	public Bookmark save(Bookmark bookmark, @Auth User user) {
		bookmark.setUser(user);
		return bookmarkDAO.save(bookmark);
	}

	@Path("{id}")
	@GET
	@UnitOfWork
	public Optional<Bookmark> findById(@PathParam("id") LongParam id) {
		return bookmarkDAO.findById(id);
	}

	@Path("/{id}")
	@PUT
	@UnitOfWork
	public Bookmark update(Bookmark bookmark, @PathParam("id") LongParam id) {
		return bookmarkDAO.update(bookmark, id);
	}

	@Path("{id}")
	@DELETE
	@UnitOfWork
	public void delete(@PathParam("id") LongParam id) {
		bookmarkDAO.delete(id);
	}
}
