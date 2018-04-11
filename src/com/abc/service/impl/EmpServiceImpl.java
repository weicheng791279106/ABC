package com.abc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.EmpMapper;
import com.abc.po.Emp;
import com.abc.service.EmpService;
import com.abc.util.StringUtil;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public Emp getEmpById(int id) throws Exception {
		return empMapper.getEmpById(id);
	}
	
	@Override
	public List<Emp> getEmpList(Integer pageNo, Integer pageSize, Emp emp) throws Exception {
		if(emp == null) return empMapper.getEmpList((pageNo-1)*pageSize, pageSize, null,null,null,null);
		return empMapper.getEmpList((pageNo-1)*pageSize, pageSize, StringUtil.isEmpty(emp.getName()) ? null:emp.getName(),
								emp.getDept() != null ? emp.getDept().getId():null,
								emp.getJob() != null ? emp.getJob().getId():null,
								emp.getUser() != null ? emp.getUser().getId():null);
	}

	@Override
	public int deleteEmp(int id) throws Exception {
		Integer result = empMapper.deleteEmp(id);
		return result == null || result == 0 ? -1:id;
	}

	@Override
	public Emp addEmp(Emp emp) throws Exception {
		empMapper.addEmp(emp);
		return emp;
	}

	@Override
	public Emp update(Emp emp) throws Exception {
		empMapper.updateEmp(emp);
		emp = empMapper.getEmpById(emp.getId());
		return emp;
	}

}
