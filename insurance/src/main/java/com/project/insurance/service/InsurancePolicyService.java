package com.project.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.InsurancePolicy;

public interface InsurancePolicyService
{

	public void createInsurancePolicy(InsurancePolicy insurance );
	
	public ResponseEntity<InsurancePolicy> selectInsurancePolicy(int id) throws ResourceNotFoundException;
	
	public List<InsurancePolicy> selectAllInsurancePolicy();
	
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(InsurancePolicy insurance,int id) throws ResourceNotFoundException;

	Map<String, Boolean> deleteInsurancePolicy(int id) throws ResourceNotFoundException;
}
