package com.eductionalloan.demo.Controller;
import java.util.List;

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
import com.eductionalloan.demo.Service.AdminService;
@RestController
@RequestMapping("/admin")
@CrossOrigin 
public class AdminController{
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/saveallloans")
	public LoanApplicationModel saveDetails(@RequestBody LoanApplicationModel l ) {
		return adminservice.saveDetails(l);
	}
	@GetMapping("/getallloans")
	public List<LoanApplicationModel>getAllLoans()
	{
		List<LoanApplicationModel>LoanApplicationModelList=adminservice.getAllLoans();
		return LoanApplicationModelList;
	}
	@PutMapping("/updateloans/{loanid}")
	public  LoanApplicationModel updateLoans(@RequestBody LoanApplicationModel i,@PathVariable("loanid") int loanid)
	{	
		return adminservice.updateLoans(i,loanid);
	}
	@DeleteMapping("deletealoans/{id}")
	public void deleteLoans(@PathVariable("id") int id) 
	{
		adminservice.deleteLoans(id);
	}
}
