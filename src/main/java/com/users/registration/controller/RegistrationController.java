package com.users.registration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.users.registration.dto.ResponseDTO;
import com.users.registration.dto.UserDTO;
import com.users.registration.model.UserData;
import com.users.registration.service.IRegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private IRegistrationService registrationService;
	
	@RequestMapping(value = {"" , "/" , "/users"})
	public ResponseEntity<ResponseDTO> getAllUsers(){
		List<UserData> userDatas = registrationService.getAllUsers();
		ResponseDTO responseDTO = new ResponseDTO("Get all call Successful" , userDatas );
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> registerUsers(@RequestBody UserDTO userDTO ){
		UserData userData = registrationService.registerUser(userDTO);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Successful" , userData);
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
	}
	
	@PutMapping("/update/{userID}")
	public ResponseEntity<ResponseDTO> updateUsers(@PathVariable("userID") int userID ,@RequestBody UserDTO userDTO){
    	UserData userData = null;
    	userData = registrationService.updateEmployeePayRollData(userID, userDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Updated User Data Successfully" , userData);
        return new ResponseEntity<ResponseDTO>( responseDTO , HttpStatus.OK);
    }
	
	@DeleteMapping("/delete{userID")
	public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable("userID") int userID){
		registrationService.deleteEmployeePayRollData(userID);
    	ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+userID);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }
}
