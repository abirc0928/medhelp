package com.abir.medhelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abir.medhelp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM USER WHERE user_mail = ?1", nativeQuery = true)
	public UserEntity findByUserMail(String userMail);
}
