package com.project.insurance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.insurance.dao.ClaimRepository;
import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Claim;
import com.project.insurance.model.Client;

@Service
public class ClaimServiceImpl implements ClaimService
{
	@Autowired
	ClaimRepository claimRepo;

	@Override
	public void createClaim(Claim claim)
	{
		claimRepo.save(claim);
		
	}

	@Override
	public Map<String, Boolean> deleteClaim(int id) throws ResourceNotFoundException {
		 Claim claim = claimRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + id));
		 
		         claimRepo.delete(claim);
		         Map<String, Boolean> response = new HashMap<>();
		         response.put("deleted", Boolean.TRUE);
		         return response;
		
	}

	@Override
	public ResponseEntity<Claim> selectClaim(int id) throws ResourceNotFoundException
	{
		Claim claim = claimRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + id));
		         return ResponseEntity.ok().body(claim);

	}

	@Override
	public List<Claim> selectAllClaim() {
		List<Claim> claimList=new ArrayList<>();
		claimRepo.findAll().forEach(claim->claimList.add(claim));
		return claimList;
	}

	@Override
	public ResponseEntity<Claim> updateClaim(Claim claim, int id) throws ResourceNotFoundException
	{
		Claim claim1 = claimRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Claim not found for this id :: " + id));
        
		claim1.setClaimNumber(claim.getClaimNumber());
		claim1.setDescription(claim.getDescription());
		claim1.setClaimDate(claim.getClaimDate());
		
        final Claim updateClaim = claimRepo.save(claim);
        return ResponseEntity.ok(updateClaim);
		
	}

}
