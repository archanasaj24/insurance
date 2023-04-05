package com.project.insurance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.InsurancePolicyRepository;
import com.project.insurance.exception.ResourceNotFoundException;
import com.project.insurance.model.Client;
import com.project.insurance.model.InsurancePolicy;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService 
{

	@Autowired
	InsurancePolicyRepository insurancePolicyRepo;
	
	@Override
	public void createInsurancePolicy(InsurancePolicy insurance) {
		insurancePolicyRepo.save(insurance);
		
	}

	@Override
	public Map<String, Boolean> deleteInsurancePolicy(int id) throws ResourceNotFoundException {
		InsurancePolicy insurancePolicy = insurancePolicyRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Policy not found for this id :: " + id));
		 
		 insurancePolicyRepo.delete(insurancePolicy);
		         Map<String, Boolean> response = new HashMap<>();
		         response.put("deleted", Boolean.TRUE);
		         return response;
		
	}


	@Override
	public ResponseEntity<InsurancePolicy> selectInsurancePolicy(int id) throws ResourceNotFoundException
	{
		InsurancePolicy insurancePolicy = insurancePolicyRepo.findById(id)
		           .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
		         return ResponseEntity.ok().body(insurancePolicy);
	}

	@Override
	public List<InsurancePolicy> selectAllInsurancePolicy() {
		List<InsurancePolicy> policyList=new ArrayList<>();
		insurancePolicyRepo.findAll().forEach(insurance->policyList.add(insurance));
		return policyList;
	}

	@Override
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(InsurancePolicy policy, int id) throws ResourceNotFoundException
	{
		InsurancePolicy policy1 = insurancePolicyRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Policy not found for this id :: " + id));
        
		policy1.setPolicyNumber(policy.getPolicyNumber());
		policy1.setPolicyType(policy.getPolicyType());
		policy1.setCoverage(policy.getCoverage());
		policy1.setPremium(policy.getPremium());
		policy1.setStartDate(policy.getStartDate());
		policy1.setEndDate(policy.getEndDate());
      final InsurancePolicy updatePolicy = insurancePolicyRepo.save(policy1);
      return ResponseEntity.ok(updatePolicy);
	}

}
