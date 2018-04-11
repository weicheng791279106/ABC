package com.abc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.DeptMapper;
import com.abc.po.Dept;
import com.abc.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public Dept getDeptById(int id) throws Exception {
		return deptMapper.getDeptById(id);
	}

	@Override
	public List<Dept> getDeptList(int pageNo, int pageSize, Dept dept) throws Exception {
		return deptMapper.getDeptList((pageNo-1)*pageSize, pageSize, dept);
	}

	@Override
	public int deleteDept(int id) throws Exception {
		Integer response = deptMapper.deleteDept(id);
		return response != null && response > 0 ? id:-1;
	}

	@Override
	public Dept addDept(String name,String remark) throws Exception {
		Dept dept = new Dept();
		dept.setName(name);
		dept.setRemark(remark);
		deptMapper.addDept(dept);
		return dept;
	}

	@Override
	public Dept updateDept(Dept dept) throws Exception {
		deptMapper.updateDept(dept);
		dept = deptMapper.getDeptById(dept.getId());
		return dept;
	}

}
