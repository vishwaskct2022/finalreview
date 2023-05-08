package com.eductionalloan.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Icecreamshop.demo.model.Icecreamshop;
import com.eductionalloan.demo.Model.LoanApplicationModel;
import com.eductionalloan.demo.Repository.LoanApplicationRepository;
@Service
public class AdminService {
	

	@Autowired
	LoanApplicationRepository loanapplicationrepository;
	
	public LoanApplicationModel saveDetails(LoanApplicationModel l)
	{
		return loanapplicationrepository.save(l);
	}

	public List<LoanApplicationModel> getAllLoans() {
		return loanapplicationrepository.findAll();
	}
	public  LoanApplicationModel updateLoans(LoanApplicationModel i,int loanid) {
		Optional<LoanApplicationModel> optional=loanapplicationrepository.findById(loanid);
		LoanApplicationModel obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setLoanid(i.getLoanid());
			obj.setLoantype(i.getLoantype());
			obj.setApplicantname(i.getApplicantname());
			obj.setApplicantaddress(i.getApplicantaddress());
			obj.setApplicantmobile(i.getApplicantmobile());
			obj.setApplicantemail(i.getApplicantemail());
			obj.setApplicantaadhar(i.getApplicantaadhar());
			obj.setApplicantpan(i.getApplicantpan());
			obj.setApplicantsalary(i.getApplicantsalary());
			obj.setLoanamountrequired(i.getLoanamountrequired());
			obj.setLoanrepaymentmonths(i.getLoanrepaymentmonths());
			loanapplicationrepository.saveAndFlush(i);
		}
		return obj;
	}
	public void deleteLoans(int i) 
	{
		loanapplicationrepository.deleteById(i);
	}

}
