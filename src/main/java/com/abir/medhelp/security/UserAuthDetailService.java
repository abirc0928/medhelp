package com.abir.medhelp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abir.medhelp.entity.UserEntity;
import com.abir.medhelp.user.UserService;
import com.abir.medhelp.utility.Constants;

@Service
public class UserAuthDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {

		UserDetails userDetails = null;

		UserEntity user = userService.findByUserMail(userMail);

		try {
			UserBuilder builder = null;

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			if (user.getRoleId() == Constants.ADMIN) {
				authorities.add(new GrantedAuthorityImp("ROLE_ADMIN"));
			} else if (user.getRoleId() == Constants.USER) {
				authorities.add(new GrantedAuthorityImp("ROLE_USER"));
			}

			builder = org.springframework.security.core.userdetails.User.withUsername(userMail);
			builder.password(passwordEncoder.encode(user.getPassword()));
			builder.authorities(authorities);

			userDetails = builder.build();

		} catch (Exception e) {
			throw new UsernameNotFoundException("Bad credential");
		}

		return userDetails;
	}

}
