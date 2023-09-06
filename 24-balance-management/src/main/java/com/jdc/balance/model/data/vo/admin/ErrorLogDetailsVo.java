package com.jdc.balance.model.data.vo.admin;

import lombok.Data;

@Data
public class ErrorLogDetailsVo {

	private ErrorLogListVo summary;

	private String stackTrace;

}