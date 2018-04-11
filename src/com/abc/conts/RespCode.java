package com.abc.conts;

/**RespBase.codeö��*/
public enum RespCode {
	
	SUCCESS(200,"�ɹ�"), 
	FAIL(-1,"ʧ��"), 
	FORBIDEN(-3,"��֤ʧ��");  
	
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
