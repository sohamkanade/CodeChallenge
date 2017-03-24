package com.home.api;

import java.math.BigDecimal;

public class ErpRecord {

	private String erpRecordId;
	private String erpReleaseRecordId;
	private String drawNumber;
	private String actionType;  // invoice, rejection and payment
	private String postDate;
	private String mainJobNumber;
	private String subContractNumber;
	private String invoiceNumber;
	private String revisionNumber;
	private String vendorId;
	private String checkNumber;
	private BigDecimal invoiceAmount;
	private BigDecimal releaseamount;
	private BigDecimal paymentAmount;

	

	public ErpRecord(String erpRecordId, 
					String erpReleaseRecordId, 
					String drawNumber, 
					String actionType, 
					String postDate,
					String mainJobNumber, 
					String subContractNumber, 
					String invoiceNumber, 
					String revisionNumber,
					String vendorId,
					String checkNumber,
					BigDecimal invoiceAmount, 
					BigDecimal releaseamount, 
					BigDecimal paymentAmount) {
		this.erpRecordId = erpRecordId;
		this.erpReleaseRecordId = erpReleaseRecordId;
		this.drawNumber = drawNumber;
		this.actionType = actionType;
		this.postDate = postDate;
		this.mainJobNumber = mainJobNumber;
		this.subContractNumber = subContractNumber;
		this.invoiceNumber = invoiceNumber;
		this.revisionNumber = revisionNumber;
		this.vendorId = vendorId;
		this.checkNumber = checkNumber;
		this.invoiceAmount = invoiceAmount;
		this.releaseamount = releaseamount;
		this.paymentAmount = paymentAmount;
	}


	public String getErpRecordId() {
		return erpRecordId;
	}


	public void setErpRecordId(String erpRecordId) {
		this.erpRecordId = erpRecordId;
	}


	public String getErpReleaseRecordId() {
		return erpReleaseRecordId;
	}


	public void setErpReleaseRecordId(String erpReleaseRecordId) {
		this.erpReleaseRecordId = erpReleaseRecordId;
	}


	public String getDrawNumber() {
		return drawNumber;
	}


	public void setDrawNumber(String drawNumber) {
		this.drawNumber = drawNumber;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public String getPostDate() {
		return postDate;
	}


	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}


	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}


	public BigDecimal getReleaseamount() {
		return releaseamount;
	}


	public void setReleaseamount(BigDecimal releaseamount) {
		this.releaseamount = releaseamount;
	}


	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public String getMainJobNumber() {
		return mainJobNumber;
	}


	public void setMainJobNumber(String mainJobNumber) {
		this.mainJobNumber = mainJobNumber;
	}


	public String getSubContractNumber() {
		return subContractNumber;
	}


	public void setSubContractNumber(String subContractNumber) {
		this.subContractNumber = subContractNumber;
	}


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public String getRevisionNumber() {
		return revisionNumber;
	}


	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public String getCheckNumber() {
		return checkNumber;
	}


	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	
}
