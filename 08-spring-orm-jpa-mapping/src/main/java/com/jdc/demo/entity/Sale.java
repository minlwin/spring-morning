package com.jdc.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(SalePK.class)
public class Sale {

	private int total;
	private String remark;
	
	@Id
	@Column(name = "sale_time")
	private LocalDateTime saleTime;
	@Id
	@Column(name = "customer_id")
	private int customerId;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(LocalDateTime saleTime) {
		this.saleTime = saleTime;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
