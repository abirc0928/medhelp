package com.abir.medhelp.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abir.medhelp.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM USER WHERE user_mail = ?1", nativeQuery = true)
	public UserEntity findByUserMail(String userMail);
}
