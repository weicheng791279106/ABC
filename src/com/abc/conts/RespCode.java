package com.abc.conts;

/**RespBase.code枚举*/
public enum RespCode {
	
	SUCCESS(200,"成功"), 
	FAIL(-1,"失败"), 
	FORBIDEN(-3,"认证失败");  
	
	private int code;
	private String msg;
	
	private RespCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
