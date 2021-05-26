package com.users.registration.service;

import java.util.List;

import javax.validation.Valid;

import com.users.registration.dto.UserDTO;
import com.users.registration.model.UserData;

public interface IRegistrationService {

	List<UserData> getAllUsers();

	UserData registerUser(UserDTO userDTO);

	UserData updateEmployeePayRollData(int userID, @Valid UserDTO userDTO);

	void deleteEmployeePayRollData(int userID);


}
