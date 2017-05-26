package com.plateno.common.config;

public enum ResultCode {
	
	SUCCESS(0,"success"),
	ERROR_ADD_FAILURE(1001,"add object to db failure"),
	ERROR_SYSTEM(1002,"system error"),
	ERROR_PARAM_ILLGAL(1003,"param illgal"),
	ERROR_MODIFY_FAILURE(1004,"modify object to db failure"),
	;
	
	private int code;
	private String msg;
	
	ResultCode(int code,String msg){
		this.code=code;
		this.msg=msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}	
	
	public static String getMsg(int code){
		String msg=null;
		for (ResultCode result : values()) {
			if(result.getCode()==code){
				msg=result.getMsg();
				break;
			}
		}
		return msg;
	}
	

}
