package com.abc.service;

import java.util.List;

import com.abc.po.Emp;

public interface EmpService {
		
	/**根据Id查询员工*/
	Emp getEmpById(int id) throws Exception;
	
	/**根据条件查询员工*/
	List<Emp> getEmpList(Integer pageNo, Integer pageSize,Emp emp) throws Exception;
	
	/**
	 * 删除员工
	 * @return 成功返回被删除部门的id,-1删除失败
	 * */
	int deleteEmp(int id) throws Exception;
	
	/**添加员工*/
	Emp addEmp(Emp emp) throws Exception;
	
	/**更新员工*/
	Emp update(Emp emp) throws Exception;
	
}
