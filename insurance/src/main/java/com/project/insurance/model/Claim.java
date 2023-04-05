package com.project.insurance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Claim 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int claimId;
	
	@NotBlank(message="Enter claim number")
	private long claimNumber;
	
	@NotEmpty(message="Enter claim description")
	private String description;
	
	@JsonFormat(pattern="dd/mm/yyyy",shape = Shape.STRING)
	private String claimDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private InsurancePolicy insurancePolicy;
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(int claimId, long claimNumber, String description, String claimDate) {
		super();
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", description=" + description
				+ ", claimDate=" + claimDate + "]";
	}
	
	
	
	
}
