package com.lams.model.bo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationsBO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long applicationTypeId;
	
	private String applicationTypeName;
	
	private Long loanTypeId;
	
	private String loanTypeName;

	private Long userId;
	
	private Double outstandingAmount;
	
	private Double emi;
	
	private Double balance_tenure;
	
	private Integer closeBeforeDisbsmnt;
	
	private Integer tenure;

	private Double propertyCost;
	
	private String propertyAddress;
	
	private String bankName;
	
	private String bankAccNumber;
	
	private Double loanAmount;
	
	private Date createdDate;
	
	private Date modifyDate;
	
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationTypeId() {
		return applicationTypeId;
	}

	public void setApplicationTypeId(Long applicationTypeId) {
		this.applicationTypeId = applicationTypeId;
	}

	public String getApplicationTypeName() {
		return applicationTypeName;
	}

	public void setApplicationTypeName(String applicationTypeName) {
		this.applicationTypeName = applicationTypeName;
	}

	public Long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public Double getBalance_tenure() {
		return balance_tenure;
	}

	public void setBalance_tenure(Double balance_tenure) {
		this.balance_tenure = balance_tenure;
	}

	public Integer getCloseBeforeDisbsmnt() {
		return closeBeforeDisbsmnt;
	}

	public void setCloseBeforeDisbsmnt(Integer closeBeforeDisbsmnt) {
		this.closeBeforeDisbsmnt = closeBeforeDisbsmnt;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getPropertyCost() {
		return propertyCost;
	}

	public void setPropertyCost(Double propertyCost) {
		this.propertyCost = propertyCost;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccNumber() {
		return bankAccNumber;
	}

	public void setBankAccNumber(String bankAccNumber) {
		this.bankAccNumber = bankAccNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}