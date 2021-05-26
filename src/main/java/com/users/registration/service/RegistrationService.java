package com.users.registration.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.registration.dto.UserDTO;
import com.users.registration.exception.RegistrationException;
import com.users.registration.model.UserData;
import com.users.registration.repository.RegistrationRepository;

@Service
public class RegistrationService implements IRegistrationService{
	
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public List<UserData> getAllUsers() {
		return registrationRepository.findAll();
	}

	@Override
	public UserData registerUser( UserDTO userDTO) {
		UserData userData = null;
		userData = new UserData(userDTO);
		return registrationRepository.save(userData);
				
	}
	
	private UserData getUserbyId(int userID) {
		
		return registrationRepository.findById(userID)
				.orElseThrow(() -> new RegistrationException("User not found"));
		
	}

	@Override
	public UserData updateEmployeePayRollData(int userID, UserDTO userDTO) {
		UserData  userData = this.getUserbyId(userID);
		userData.updateUserData(userDTO);
		
		return registrationRepository.save(userData);
		
	}

	@Override
	public void deleteEmployeePayRollData(int userID) {
		UserData userData = this.getUserbyId(userID);
		registrationRepository.delete(userData);
		
	}
	

}
