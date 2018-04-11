package com.abc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.abc.conts.RespCode;
import com.abc.conts.SessionConts;
import com.abc.po.RespBase;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		if(true) return true; // �Ȳ�����¼У�飬��ȻControllerTest��Ԫ�����鷳
		if(req.getRequestURI().contains("login")) return true; /*��¼�ӿڲ�����*/
		if(req.getSession().getAttribute(SessionConts.USERNAME) != null) return true; /*���ǵ�¼�ӿڣ�ͨ��session�б�����û���Ϣ�ж��Ƿ��ѵ�¼*/
		/*  ʹ��response����    */  
		resp.setStatus(HttpStatus.OK.value()); //����״̬��  
		resp.setContentType(MediaType.APPLICATION_JSON_VALUE); //����ContentType  
		resp.setCharacterEncoding("UTF-8"); //��������  
		resp.setHeader("Cache-Control", "no-cache, must-revalidate");  
		RespBase respBase = new RespBase(RespCode.FAIL).setMsg("���ȵ�¼");
        try {  
       	 	resp.getWriter().write(new ObjectMapper().writeValueAsString(respBase));  
        } catch (Exception e) {  
       	 System.out.println(e);
        }  
		return false;
	}

}
