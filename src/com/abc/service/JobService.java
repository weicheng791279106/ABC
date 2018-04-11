package com.abc.service;

import java.util.List;

import com.abc.po.Job;


public interface JobService {

	/**根据Id查找岗位*/
	public Job getJobById(int id) throws Exception;
	
	/**根据条件查找岗位*/
	public List<Job> getJobList(int pageNo,int pageSize,Job job) throws Exception;
	
	/**
	 * 删除岗位
	 * @return 成功返回被删除部门的id,-1删除失败
	 * */
	public int deleteJob(int id) throws Exception;
	
	/**添加岗位*/
	public Job addJob(String name,String remark) throws Exception;
	
	/**
	 * 更新岗位
	 * @return 成功返回被更新岗位,null更新失败
	 * */
	public Job updateJob(Job job) throws Exception;
	
}
