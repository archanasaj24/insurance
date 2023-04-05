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

@Entity(name="insurance")
public class InsurancePolicy
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int policyId;
	
	@NotEmpty(message="Policy number required")
	private String policyNumber;
	
	@NotBlank(message="Should enter Policy type")
	private String policyType;
	
	@NotEmpty(message="Enter coverage")
	private double coverage;
	
	@NotEmpty(message="Enter premium amount")
	private double premium;
	
	@JsonFormat(pattern="dd/mm/yyyy",shape = Shape.STRING)
	private String startDate;
	
	@JsonFormat(pattern="dd/mm/yyyy",shape = Shape.STRING)
	private String endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Client client;
	
	public InsurancePolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsurancePolicy(int policyId, String policyNumber, String policyType, double coverage, double premium,
			String startDate, String endDate) {
		super();
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.coverage = coverage;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyNumber=" + policyNumber + ", policyType=" + policyType
				+ ", coverage=" + coverage + ", premium=" + premium + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
