package com.abc.po;

import java.util.List;

/**查询用户所创建的订单*/
public class UserOrderQueryVo extends User{

	private List<Order> orderList;

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
}
