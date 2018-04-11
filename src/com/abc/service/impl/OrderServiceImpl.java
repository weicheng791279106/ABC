package com.abc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.OrderMapper;
import com.abc.po.Order;
import com.abc.po.UserOrderQueryVo;
import com.abc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Order getOrderById(Integer id) throws Exception {
		return orderMapper.getOrderById(id);
	}

	@Override
	public List<UserOrderQueryVo> getUserOrderQueryVoList() throws Exception {
		return orderMapper.getUserOrderQueryVoList();
	}

}
