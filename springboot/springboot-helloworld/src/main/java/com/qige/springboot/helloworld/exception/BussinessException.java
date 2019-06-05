package com.qige.springboot.helloworld.exception;

public class BussinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public BussinessException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	

}
