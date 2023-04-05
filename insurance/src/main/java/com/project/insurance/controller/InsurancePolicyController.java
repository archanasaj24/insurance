package com.project.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.InsurancePolicy;
import com.project.insurance.service.InsurancePolicyServiceImpl;

import jakarta.validation.Valid;

@RestController
public class InsurancePolicyController 
{
	@Autowired
	InsurancePolicyServiceImpl insurancePolicyServiceImpl;
	
	@PostMapping("POST/api/policies")
	public String createInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy)
	{
		insurancePolicyServiceImpl.createInsurancePolicy(insurancePolicy);
		return "New policy created";
	}
	
	@DeleteMapping("DELETE/api/policies/{id1}")
	public String deleteInsurancePolicy(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		insurancePolicyServiceImpl.deleteInsurancePolicy(id);
		return "Record deleted";
	}
	
	@GetMapping("GET/api/policies/{id1}")
	public ResponseEntity<InsurancePolicy> selectInsurancePolicy(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		ResponseEntity<InsurancePolicy> insurancePolicy=insurancePolicyServiceImpl.selectInsurancePolicy(id);
		return insurancePolicy;
	}
	
	@GetMapping("GET/api/policies")
	public List<InsurancePolicy> selectAllInsurancePolicy(){
		List<InsurancePolicy> insurancePolicy=insurancePolicyServiceImpl.selectAllInsurancePolicy();
		return insurancePolicy;
	}
	
	@PutMapping("PUT/api/policies/{id1}")
	public String updateInsurancePolicy(@PathVariable("id1") int id, @Valid @RequestBody InsurancePolicy insurancePolicy) throws ResourceNotFoundException
	{
		insurancePolicyServiceImpl.updateInsurancePolicy(insurancePolicy, id);
		return "Record updated";
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}
