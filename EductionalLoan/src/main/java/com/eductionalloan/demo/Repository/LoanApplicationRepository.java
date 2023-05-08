package com.eductionalloan.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eductionalloan.demo.Model.LoanApplicationModel;

public interface LoanApplicationRepository extends JpaRepository<LoanApplicationModel,Integer> {

	Optional<LoanApplicationModel> findById(Integer loanid);





}
