package com.jdc.balance.model.data.vo;

import java.util.List;

import lombok.Data;

@Data
public class PageResultVo<T> {

	private List<T> content;

	private Pager pager;

}