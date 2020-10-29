package com.corso.dropwizard.udemy.dropbookamrksprova.dto;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDto {
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank
	@Column(unique = true)
    private String username;
	@NotBlank
    private String password;
}
