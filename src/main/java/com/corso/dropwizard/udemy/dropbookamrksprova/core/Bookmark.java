package com.corso.dropwizard.udemy.dropbookamrksprova.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "Bookmarks")
@Data

@NamedQueries({
    @NamedQuery(name = "Bookmark.findAll",
            query = "SELECT b FROM Bookmark b"),
    @NamedQuery(name = "Bookmark.findById",
            query = "SELECT b FROM Bookmark b WHERE b.id = :id"),
    @NamedQuery(name = "Bookmark.findByUserId",
            query = "SELECT b FROM Bookmark b WHERE b.user.id = :id"),
    @NamedQuery(name = "Bookmark.remove", query = "DELETE FROM Bookmark b "
            + "where b.id = :id"),
    @NamedQuery(name = "Bookmark.findByIdAndUserId",
            query = "SELECT b FROM Bookmark b WHERE b.id = :id AND "
            + "b.user.id = :userId")})
public class Bookmark {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	private String url;
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
