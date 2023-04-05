package com.project.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Claim;

public interface ClaimService
{
	public void createClaim(Claim claim );
	
	public Map<String, Boolean> deleteClaim(int id) throws ResourceNotFoundException;
	
	public ResponseEntity<Claim> selectClaim(int id) throws ResourceNotFoundException;
	
	public List<Claim> selectAllClaim();
	
	public ResponseEntity<Claim> updateClaim(Claim claim,int id) throws ResourceNotFoundException;
}
