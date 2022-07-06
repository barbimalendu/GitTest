package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmpAddress;
import com.example.demo.model.EmpDetails;
import com.example.demo.repo.EmpAddressRepo;
import com.example.demo.repo.EmpDetailsRepo;

@RestController

public class MainController {
	
	@Autowired
	private EmpDetailsRepo detailsDBobj;
	
	@Autowired
	private EmpAddressRepo addressDBobj;
	
	
	
	
	
	@GetMapping("/viewAll/{loc1}")
	public ResponseEntity<?> viewEmpByLoc(@PathVariable String loc1 ){
		
		
		List<EmpAddress> addressList = new ArrayList<>();
		addressList = addressDBobj.findByAddressLine1(loc1);
		List<Map> update = new ArrayList<>();
		if( addressList.size()== 0)
			return ResponseEntity.ok("Employee not exist for "+loc1 +" city");
		else {
		for (EmpAddress addObj:addressList) {
			EmpDetails empObj=detailsDBobj.findById(addObj.getId()).get();
		
			Map<String, Object> returnMap = new HashMap<>(); 
			
			returnMap.put("id", empObj.getId());
			returnMap.put("empName", empObj.getEmpName());
			returnMap.put("jobDescription", empObj.getJobDescription());
			returnMap.put("salary", empObj.getSalary());
			returnMap.put("address", addObj);
			update.add(returnMap);
		
		}
		return ResponseEntity.ok(update);
		}
	}
	
	
	@PostMapping("/addRecord")
	public String addData(@RequestBody org.json.simple.JSONObject data) {
		try {
			JSONObject jsonObject = new JSONObject (data); 
			System.out.println(jsonObject);
			
			EmpDetails empObj = new EmpDetails();
			EmpAddress addressObj= new EmpAddress();
			
			empObj.setId(jsonObject.getInt("id"));
			empObj.setEmpName(jsonObject.getString("empName"));
			empObj.setJobDescription(jsonObject.getString("jobDescription"));
			empObj.setSalary(jsonObject.getInt("salary"));
			
			empObj = this.detailsDBobj.save(empObj);
			
		
						
			JSONObject jsonAddressObj = jsonObject.getJSONObject("address");
			addressObj.setId(jsonAddressObj.getInt("id"));
			addressObj.setStreetName(jsonAddressObj.getString("streetName"));
			addressObj.setLandmark(jsonAddressObj.getString("landmark"));
			addressObj.setAddressLine1(jsonAddressObj.getString("addressLine1"));
			addressObj.setAddressLine2(jsonAddressObj.getString("addressLine2"));
			addressDBobj.save(addressObj);			
			
			return "Data Saved sucessfully";
			
		}catch(Exception e) {
				return "error";}
	}
	
	
	
	/*
	 * @GetMapping("/view5thSalary") public ResponseEntity<?> viewAllData(){
	 * 
	 * Map<String, Object> returnMap1 = new HashMap<>(); Optional<EmpAddress>
	 * addressObj= Optional.of(new EmpAddress());
	 * 
	 * List<EmpDetails> eList= new ArrayList<>(); eList= detailsDBobj.findAll();
	 * 
	 * Collections.sort(eList);
	 * 
	 * HashSet<Integer> set = new HashSet<Integer>(); for (EmpDetails emp:eList) {
	 * set.add(emp.getSalary());
	 * 
	 * } Integer[] salArr = set.toArray(new Integer[set.size()]);
	 * 
	 * int ecount=0; int acount=0; for(EmpDetails emp :eList) {
	 * 
	 * if(Integer.compare(emp.getSalary(), salArr[4])== 0) {
	 * 
	 * addressObj=addressDBobj.findById(emp.getEmpID());
	 * 
	 * returnMap1.put("Employee"+ecount++,emp);
	 * returnMap1.put("Address"+acount++,addressObj);
	 * 
	 * 
	 * 
	 * } if(Integer.compare(emp.getSalary(), salArr[4])== 1 ) { break; }
	 * 
	 * }
	 * 
	 * return ResponseEntity.ok(returnMap1);
	 * 
	 * 
	 * 
	 * }
	 */
	 
	
	
	@GetMapping("/count/{loc1}")
	public Integer countByLocation(@PathVariable String loc1 ){
		try {
			List<EmpAddress> locList = new ArrayList<>();
			locList = addressDBobj.findByAddressLine1(loc1);
			return (locList.size());
		}
		catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
		
		//return (addressDBobj.countByLocation(loc1));
	
		//return ResponseEntity.ok(returnMap1);
		

		
	}
	
	@GetMapping("/location/{addressLine1}")
	public ResponseEntity<List<EmpAddress>>  find(@PathVariable String addressLine1 ){
		List<EmpAddress> locList = addressDBobj.findByaddressLine1(addressLine1);
		return ResponseEntity.ok(locList);
		//return (addressDBobj.countByLocation(loc1));
	
		//return ResponseEntity.ok(returnMap1);
		

		
	}
	
	

}
