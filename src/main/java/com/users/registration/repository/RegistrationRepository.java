package com.users.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.registration.model.UserData;

public interface RegistrationRepository extends JpaRepository<UserData, Integer>{}
