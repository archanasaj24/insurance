package com.project.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.insurance.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
