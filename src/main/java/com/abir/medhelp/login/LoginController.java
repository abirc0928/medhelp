package com.abir.medhelp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/hello")
    public String getTreeById() {
        return "Hello world" ;
    }
}
