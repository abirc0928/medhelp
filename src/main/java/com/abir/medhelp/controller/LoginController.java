package com.abir.medhelp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abir.medhelp.dto.LoginDTO;
import com.abir.medhelp.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginGet(HttpServletRequest request) {
		LoginDTO loginDTO = (LoginDTO) request.getSession(true).getAttribute("loginDTO");
		if (loginDTO != null) {
			return "redirect:/home";
		}
		return "login";
	}

	@GetMapping("/")
	public String home(HttpServletRequest request) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserMail(user.getUsername());
		loginDTO.setPassword(user.getPassword());

		userService.findByUserMail(loginDTO.getUserMail());

		request.getSession(true).setAttribute("loginDTO", loginDTO);

		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
