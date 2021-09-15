package com.abir.medhelp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.medhelp.entity.UserEntity;
import com.abir.medhelp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserEntity findByUserMail(String userMail) {
		UserEntity user = repository.findByUserMail(userMail);
		return user;
	}

	public UserEntity addUser(UserEntity userEntity) {
		UserEntity entity = this.findByUserMail(userEntity.getUserMail());
		if(entity != null) {
			System.out.println("Duplicate email");
			return null;
		}
		return repository.save(userEntity);
	}
}
