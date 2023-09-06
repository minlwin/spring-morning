package com.jdc.balance.model.data.vo;

import java.util.List;

import lombok.Data;

@Data
public class Pager {

	private int pageSize;

	private long totalCount;

	private int currentPage;

	public int totalPage() {
		// TODO implement here
		return 0;
	}

	public List<Integer> pageLinks() {
		// TODO implement here
		return null;
	}

}