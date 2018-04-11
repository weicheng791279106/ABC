package com.abc.dao.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.springframework.stereotype.Repository;

import com.abc.conts.DbConts;
import com.abc.po.Article;
import com.abc.po.Order;
import com.abc.po.UserOrderQueryVo;

@Repository
public interface OrderMapper {

	
	/**根据订单Id查询订单*/
	@Select("SELECT id,addr,total,user_id FROM " + DbConts.TABLE_ORDER + " WHERE id = #{id}")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="user",column="user_id",one = @One(select = "com.abc.dao.mapper.UserMapper.getUserById")),
		@Result(property="articleList",column="id",many = @Many(select = "getOrderArticle"))
	})
	public Order getOrderById(Integer id) throws Exception;
	
	
	/**根据订单Id查询对应的商品列表*/
	@Select("SELECT t_a.id,t_a.name,t_a.price,t_od.count "
			+ " FROM " + DbConts.TABLE_ORDER_DETAIL + " t_od ," + DbConts.TABLE_ARTICLE + " t_a"
			+ " WHERE t_od.order_id = #{orderId} AND t_a.id = t_od.article_id")
	public List<Article> getOrderArticle(Integer orderId) throws Exception;
	
	
	/**查询有下订单的用户及其所创建的订单*/
	@Select("SELECT user." + UserMapper.QUERY_COLUMN + ",torder.id orderId "
			+ "FROM "+ DbConts.TABLE_USER + " user," + DbConts.TABLE_ORDER + " torder WHERE torder.user_id = user.id GROUP BY user.id")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="orderList",column="id",many = @Many(select = "getOrderByUserIdNoUser"))
	})
	public List<UserOrderQueryVo> getUserOrderQueryVoList() throws Exception;
	
	
	/**根据用户Id查询订单不查User*/
	@Select("SELECT id,addr,total,user_id FROM " + DbConts.TABLE_ORDER + " WHERE user_id = #{userId}")
	@Results({
		@Result(id=true,property="id",column="id"),
		@Result(property="articleList",column="id",many = @Many(select = "getOrderArticle"))
	})
	public List<Order> getOrderByUserIdNoUser(Integer userId) throws Exception;
	
	
}
