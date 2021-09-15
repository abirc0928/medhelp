package com.abir.medhelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abir.medhelp.entity.UserEntity;
import com.abir.medhelp.form.SignupForm;
import com.abir.medhelp.service.UserService;
import com.abir.medhelp.utility.Constants;
import com.abir.medhelp.utility.Utility;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute SignupForm form, Model model) {

		if (!isValidForm(form)) {
			System.out.println("User data missing");
			return "redirect:/signup";
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(form.getUserName());
		userEntity.setUserMail(form.getUserEmail());
		userEntity.setPassword(form.getPassword());
		userEntity.setPhone(form.getPhoneNumber());
		userEntity.setDateOfBirth(form.getDateOfBirth());
		userEntity.setAddress(form.getAddress());
		userEntity.setRoleId(Constants.USER);

		userEntity = userService.addUser(userEntity);
		if (userEntity != null) {
			System.out.println("sign up successfull");
		} else {
			System.out.println("sign up failed");
			return "redirect:/signup";
		}

		return "redirect:/login";
	}

	public boolean isValidForm(SignupForm model) {

		if (model.getUserName() == null || model.getUserName().length() == 0) {
			System.out.println("user name is empty");
			return false;
		}

		if (model.getPassword() == null || model.getPassword().length() < 6) {
			System.out.println("Password minimum 6 digit");
			return false;
		}

		if (model.getUserEmail() == null || model.getUserEmail().length() == 0
				|| !Utility.isValidEmailAddress(model.getUserEmail())) {
			System.out.println("user email is invalid");
			return false;
		}

		if (model.getAddress() == null || model.getAddress().length() == 0) {
			System.out.println("Address is empty");
			return false;
		}

		if (model.getPhoneNumber() == null
				|| !(model.getPhoneNumber().length() >= 11 && model.getPhoneNumber().length() <= 14)) {
			System.out.println("Phone number is empty");
			return false;
		}

		if (model.getDateOfBirth() == null || model.getDateOfBirth().length() == 0) {
			System.out.println("Date of birth is empty");
			return false;
		}

		return true;
	}
}
