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

/**全局异常处理器*/
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object arg2,Exception ex) {
		 ModelAndView mv = new ModelAndView();             
         /*  使用response返回    */  
		 resp.setStatus(HttpStatus.OK.value()); //设置状态码  
		 resp.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType  
		 resp.setCharacterEncoding("UTF-8"); //避免乱码  
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
