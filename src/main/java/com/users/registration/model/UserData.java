package com.users.registration.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.users.registration.dto.UserDTO;

import lombok.Data;

@Entity
@Table
public @Data class UserData {
	
	public UserData(UserDTO userDTO) {
		this.updateUserData(userDTO);
	}

	@Id
	private int userID;
	
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private long mobile;
	private LocalTime registationTime;
	
	public void updateUserData(UserDTO userDTO) {
		this.firstName =userDTO.firstName;
		this.lastName =userDTO.lastName;
		this.dateOfBirth = userDTO.dateOfBirth;
		this.mobile = userDTO.mobile;
		this.registationTime = LocalTime.now();
	}
}
