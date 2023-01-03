package com.jdc.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class SalePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime saleTime;
	private int customerId;

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

	@Override
	public int hashCode() {
		return Objects.hash(customerId, saleTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalePK other = (SalePK) obj;
		return customerId == other.customerId && Objects.equals(saleTime, other.saleTime);
	}

}
