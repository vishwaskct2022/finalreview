package com.eductionalloan.demo.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eductionalloan.demo.Model.LoanApplicationModel;
import com.eductionalloan.demo.Model.UserModel;
import com.eductionalloan.demo.Repository.LoanApplicationRepository;
import com.eductionalloan.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	LoanApplicationRepository loanapplicationrepository;

	
	
	public String validateUser(String email, String password) 
	{
	      String result="";
	      UserModel u=userrepository.findByEmail(email);
	      if(u==null)
	      {
	    	  result="Invalid User";
	      }
	      else
	      {
	    	  if(u.getPassword().equals(password))
	    	  {
	    		  result="Login Success";
	    	  }
	      
	      else
	      {
	    	  result="Login failed";
	      }
	      }
	      return result;
	}
	public UserModel saveDetails(UserModel u)
	{
		return userrepository.save(u);
	}
	public List<LoanApplicationModel> getAllLoans()
	{
		List<LoanApplicationModel>LoanApplicationModelList=loanapplicationrepository.findAll();
		return LoanApplicationModelList;
	}
    public LoanApplicationModel getLoan(int loanid)
    {
    	LoanApplicationModel loan=loanapplicationrepository.findById(loanid).get();
    	return loan;
    }
	public UserModel getProfile(int id) {
		
		UserModel user=userrepository.findById(id).get();
		return user;
	}
	public  UserModel updateProfile(UserModel i,int id) {
		Optional<UserModel> optional=userrepository.findById(id);
		UserModel obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setId(i.getId());
			obj.setEmail(i.getEmail());
			obj.setPassword(i.getPassword());
			obj.setUsername(i.getUsername());
			obj.setMobilenumber(i.getMobilenumber());
			obj.setUserrole(i.getUserrole());
			userrepository.saveAndFlush(i);
		}
		return obj;
	}
	public void deleteProfile(int i) 
	{
		userrepository.deleteById(i);
	}

}
