package com.abc.service;

import java.util.List;

import com.abc.po.Emp;

public interface EmpService {
		
	/**����Id��ѯԱ��*/
	Emp getEmpById(int id) throws Exception;
	
	/**����������ѯԱ��*/
	List<Emp> getEmpList(Integer pageNo, Integer pageSize,Emp emp) throws Exception;
	
	/**
	 * ɾ��Ա��
	 * @return �ɹ����ر�ɾ�����ŵ�id,-1ɾ��ʧ��
	 * */
	int deleteEmp(int id) throws Exception;
	
	/**���Ա��*/
	Emp addEmp(Emp emp) throws Exception;
	
	/**����Ա��*/
	Emp update(Emp emp) throws Exception;
	
}
