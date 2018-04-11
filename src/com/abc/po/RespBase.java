package com.abc.po;

import com.abc.conts.RespCode;

/**接口返回基本数据结构*/
public class RespBase {

	private int code = RespCode.FAIL.getCode();
	
	private String msg = RespCode.FAIL.getMsg();
	
	private Object data;
	
	
	public RespBase(RespCode respCode) {
		if(respCode == null) return;
		setCode(respCode.getCode());
		setMsg(respCode.getMsg());
	}

	public int getCode() {
		return code;
	}

	public RespBase setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public RespBase setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public RespBase setData(Object data) {
		this.data = data;
		return this;
	}
	
}
