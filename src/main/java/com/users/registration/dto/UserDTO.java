package com.users.registration.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class UserDTO {

	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" , message = "First name not according to the pattern")
	public String firstName;
	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" , message = "First name not according to the pattern")

	public String lastName;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull (message = "Date cannot be left empty")
	@PastOrPresent(message = "Date cannot be newer than today's Date")
	public LocalDate dateOfBirth;
	
	public long mobile;

}
