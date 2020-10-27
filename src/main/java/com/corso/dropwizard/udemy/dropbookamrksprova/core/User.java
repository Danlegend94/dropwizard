package com.corso.dropwizard.udemy.dropbookamrksprova.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
   
    @NotNull
    @Size(min = 1, max = 255)
    private String url;
    
    @Size(max = 2048)
    private String description;
    
    @JsonIgnore
    @ManyToOne
    private User user;
}
