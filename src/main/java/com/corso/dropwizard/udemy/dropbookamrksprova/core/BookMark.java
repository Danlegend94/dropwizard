package com.corso.dropwizard.udemy.dropbookamrksprova.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookMarks")
public class BookMark {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
