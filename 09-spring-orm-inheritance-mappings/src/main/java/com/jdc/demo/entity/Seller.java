package com.jdc.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Seller extends Member {

	private String phone;
	private String shop;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

}
