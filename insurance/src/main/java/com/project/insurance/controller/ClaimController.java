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
import com.project.insurance.model.Claim;
import com.project.insurance.service.ClaimServiceImpl;

@RestController
public class ClaimController
{
	@Autowired
	ClaimServiceImpl claimServiceImpl;
	
	@PostMapping("POST/api/claims")
	public String createClaim(@RequestBody Claim claim)
	{
		claimServiceImpl.createClaim(claim);
		return "New claim created";
	}
	
	@DeleteMapping("DELETE/api/claims/{id1}")
	public String deleteClaim(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		claimServiceImpl.deleteClaim(id);
		return "Record deleted";
	}
	
	@GetMapping("GET/api/claims/{id1}")
	public ResponseEntity<Claim> selectClaim(@PathVariable("id1") int id) throws ResourceNotFoundException
	{
		ResponseEntity<Claim> claim=claimServiceImpl.selectClaim(id);
		return claim;
	}
	
	@GetMapping("GET/api/claims")
	public List<Claim> selectAllClaim(){
		List<Claim> claim=claimServiceImpl.selectAllClaim();
		return claim;
	}
	
	@PutMapping("PUT/api/claims/{id1}")
	public String updateClaim(@PathVariable("id1") int id, @RequestBody Claim claim) throws ResourceNotFoundException
	{
		claimServiceImpl.updateClaim(claim, id);
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
