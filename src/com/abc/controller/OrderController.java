package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.po.Order;
import com.abc.po.RespBase;
import com.abc.po.UserOrderQueryVo;
import com.abc.service.OrderService;

@Controller
@RequestMapping("order/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping("getOrderById")
	public RespBase getOrderById(Integer id) throws Exception{
		Order order = orderService.getOrderById(id);
		return new RespBase(order == null ? RespCode.FAIL:RespCode.SUCCESS).setData(order);
	}
	
	@ResponseBody
	@RequestMapping("getUserOrderQueryVoList")
	public RespBase getUserOrderQueryVoList(Integer id) throws Exception{
		List<UserOrderQueryVo> result = orderService.getUserOrderQueryVoList();
		return new RespBase(RespCode.SUCCESS).setData(result);
	}

}
