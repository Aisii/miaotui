package com.mt.util;

/**
 * ajax 交互..格式定义
 */
public class BaseResult {

	private int code = 0;
	private String message = "";
	private Object data;

	public BaseResult() {
	}
	
	public BaseResult(int code) {
		super();
		this.code = code;
	}
	
	public BaseResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseResult(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
