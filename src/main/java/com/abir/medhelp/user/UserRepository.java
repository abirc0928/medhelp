package com.abir.medhelp.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abir.medhelp.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	public UserEntity findByUserMail(String userMail);
}
