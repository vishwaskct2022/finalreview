package com.eductionalloan.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eductionalloan.demo.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{

	UserModel findByEmail(String email);
}

