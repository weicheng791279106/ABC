package com.abc.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.abc.conts.RespCode;
import com.abc.po.RespBase;
import com.fasterxml.jackson.databind.ObjectMapper;

/**ȫ���쳣������*/
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object arg2,Exception ex) {
		 ModelAndView mv = new ModelAndView();             
         /*  ʹ��response����    */  
		 resp.setStatus(HttpStatus.OK.value()); //����״̬��  
		 resp.setContentType(MediaType.APPLICATION_JSON_VALUE); //����ContentType  
		 resp.setCharacterEncoding("UTF-8"); //��������  
		 resp.setHeader("Cache-Control", "no-cache, must-revalidate");  
		 RespBase respBase = new RespBase(RespCode.FAIL).setMsg(ex.getMessage());
         try {  
        	 resp.getWriter().write(new ObjectMapper().writeValueAsString(respBase));  
         } catch (Exception e) {  
        	 System.out.println(e);
         }  
         return mv;  
	}

}
