package com.abc.service;

import java.util.List;

import com.abc.po.Job;


public interface JobService {

	/**����Id���Ҹ�λ*/
	public Job getJobById(int id) throws Exception;
	
	/**�����������Ҹ�λ*/
	public List<Job> getJobList(int pageNo,int pageSize,Job job) throws Exception;
	
	/**
	 * ɾ����λ
	 * @return �ɹ����ر�ɾ�����ŵ�id,-1ɾ��ʧ��
	 * */
	public int deleteJob(int id) throws Exception;
	
	/**��Ӹ�λ*/
	public Job addJob(String name,String remark) throws Exception;
	
	/**
	 * ���¸�λ
	 * @return �ɹ����ر����¸�λ,null����ʧ��
	 * */
	public Job updateJob(Job job) throws Exception;
	
}
