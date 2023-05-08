package com.eductionalloan.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eductionalloan.demo.Model.LoanApplicationModel;
import com.eductionalloan.demo.Model.LoginModel;
import com.eductionalloan.demo.Model.UserModel;
import com.eductionalloan.demo.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/login")
	public String validateUser(@RequestBody LoginModel l)
	{
		return userservice.validateUser(l.getEmail(),l.getPassword());
	}
	@PostMapping("/signup")
	public UserModel saveDetails(@RequestBody UserModel u ) {
		return userservice.saveDetails(u);
	}
	@GetMapping("/updateprofile/{id}")
	public LoanApplicationModel getLoan(@PathVariable int loanid)
	{
		return userservice.getLoan(loanid);
	}
	@GetMapping("/getprofile/{id}")
	public UserModel getProfile(@PathVariable int id)
	{
		return userservice.getProfile(id);
	}
	@PutMapping("/updateprofile/{id}")
	public  UserModel updateProfile(@RequestBody UserModel i,@PathVariable("id") int id)
	{	
		return userservice.updateProfile(i,id);
	}
	@DeleteMapping("deleteprofile/{id}")
	public void deleteProfile(@PathVariable("id") int id) 
	{
		userservice.deleteProfile(id);
	}
}
