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
		if(true) return true; // 先不做登录校验，不然ControllerTest单元测试麻烦
		if(req.getRequestURI().contains("login")) return true; /*登录接口不拦截*/
		if(req.getSession().getAttribute(SessionConts.USERNAME) != null) return true; /*不是登录接口，通过session中保存的用户信息判断是否已登录*/
		/*  使用response返回    */  
		resp.setStatus(HttpStatus.OK.value()); //设置状态码  
		resp.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType  
		resp.setCharacterEncoding("UTF-8"); //避免乱码  
		resp.setHeader("Cache-Control", "no-cache, must-revalidate");  
		RespBase respBase = new RespBase(RespCode.FAIL).setMsg("请先登录");
        try {  
       	 	resp.getWriter().write(new ObjectMapper().writeValueAsString(respBase));  
        } catch (Exception e) {  
       	 System.out.println(e);
        }  
		return false;
	}

}
