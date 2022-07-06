package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmpAddress;

@Repository
public interface EmpAddressRepo extends JpaRepository<EmpAddress, Integer> {
	 
	//@Query("SELECT c  FROM emp_address c WHERE c.address_line1 like :?1")
	List<EmpAddress> findByAddressLine1(String loc);

	List<EmpAddress> findByaddressLine1(String addressLine1);
}
