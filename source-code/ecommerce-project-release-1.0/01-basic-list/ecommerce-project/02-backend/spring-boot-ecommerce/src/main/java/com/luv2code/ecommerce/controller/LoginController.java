package com.luv2code.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luv2code.ecommerce.exceptions.MissingParameterException;
import com.luv2code.ecommerce.security.dao.AuthenticationResponse;
import com.luv2code.ecommerce.security.dao.LoginDetail;
import com.luv2code.ecommerce.security.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
//@CrossOrigin("*")
public class LoginController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to home";
	}
	
	private LoginService loginService;

    @Autowired
    public LoginController(
    		@Qualifier("loginServiceImpl") 
    		LoginService loginService) {
        this.loginService = loginService;
    }

	
	@PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginRequest(@RequestBody LoginDetail loginDetail) throws MissingParameterException 
    		 {
        return ResponseEntity.ok(loginService.loginRequest(loginDetail));
    }
	
	@PostMapping("/logout")
	  public ResponseEntity<AuthenticationResponse> logout(@RequestBody LoginDetail loginDetail) {

	    return ResponseEntity.ok().build();
	  }

}
