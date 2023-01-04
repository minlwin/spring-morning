package com.jdc.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class SaleDetails {

	private String product;
	private int unitPrice;
	private int quentity;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuentity() {
		return quentity;
	}

	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}

}
