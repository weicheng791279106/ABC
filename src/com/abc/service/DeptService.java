package com.abc.service;

import java.util.List;

import com.abc.po.Dept;

public interface DeptService {

	/**����Id���Ҳ���*/
	public Dept getDeptById(int id) throws Exception;
	
	/**�����������Ҳ���*/
	public List<Dept> getDeptList(int pageNo,int pageSize,Dept dept) throws Exception;
	
	/**
	 * ɾ������
	 * @return �ɹ����ر�ɾ�����ŵ�id,-1ɾ��ʧ��
	 * */
	public int deleteDept(int id) throws Exception;
	
	/**��Ӳ���*/
	public Dept addDept(String name,String remark) throws Exception;
	
	/**
	 * ���²���
	 * @return �ɹ����ر����²���,null����ʧ��
	 * */
	public Dept updateDept(Dept dept) throws Exception;
	
}
