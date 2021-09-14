package com.abir.medhelp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.medhelp.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserEntity findByUserMail(String userMail) {
		UserEntity user = repository.findByUserMail(userMail);
		System.out.println(user.getUserName());
		return user;
	}
}
