package com.abc.service;

import java.util.List;

import com.abc.po.Order;
import com.abc.po.UserOrderQueryVo;

public interface OrderService {

	public Order getOrderById(Integer id) throws Exception;
	
	public List<UserOrderQueryVo> getUserOrderQueryVoList() throws Exception;
	
}
