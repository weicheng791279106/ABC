package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.po.Dept;
import com.abc.po.Emp;
import com.abc.po.Job;
import com.abc.po.RespBase;
import com.abc.po.User;
import com.abc.service.EmpService;

@Controller
@RequestMapping("emp/")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	/**根据Id查询员工*/
	@RequestMapping("getEmpById")
	@ResponseBody
	public RespBase getEmpById(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		Emp emp = empService.getEmpById(id);
		return new RespBase(emp == null ? RespCode.FAIL:RespCode.SUCCESS).setData(emp);
	}
	
	/**根据条件查询员工*/
	@RequestMapping("getEmpList")
	@ResponseBody
	public RespBase getEmpList(Integer pageSize,Integer pageNo,String name,Integer userId,Integer deptId,Integer jobId) throws Exception{
		if(pageSize == null || pageNo == null){
			pageSize = Integer.MAX_VALUE;
			pageNo = 1;
		}
		Emp emp = new Emp();
		emp.setName(name);
		if(userId != null){
			emp.setUser(new User());
			emp.getUser().setId(userId);
		}
		if(deptId != null){
			emp.setDept(new Dept());
			emp.getDept().setId(deptId);
		}
		if(jobId != null){
			emp.setJob(new Job());
			emp.getJob().setId(jobId);
		}
		List<Emp> empList = empService.getEmpList(pageNo, pageSize, emp);
		return new RespBase(emp == null ? RespCode.FAIL:RespCode.SUCCESS).setData(empList);
	}
	
	/**添加员工*/
	@RequestMapping(method=RequestMethod.POST,value="addEmp")
	@ResponseBody
	public RespBase addEmp(Emp emp,Integer userId,Integer deptId,Integer jobId) throws Exception{
		if(userId == null || deptId == null || jobId == null) return new RespBase(RespCode.FAIL).setMsg("请传入userId、deptId、jobId");
		emp.setUser(new User());
		emp.getUser().setId(userId);
		emp.setDept(new Dept());
		emp.getDept().setId(deptId);
		emp.setJob(new Job());
		emp.getJob().setId(jobId);
		empService.addEmp(emp);
		return new RespBase(RespCode.SUCCESS).setData(emp);
	}
	
	/**删除员工*/
	@RequestMapping("deleteEmp")
	@ResponseBody
	public RespBase deleteEmp(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		int result = empService.deleteEmp(id);
		return new RespBase(result == -1 ? RespCode.FAIL:RespCode.SUCCESS).setData(result);
	}
	
	/**更新员工*/
	@RequestMapping(method=RequestMethod.POST,value="updateEmp")
	@ResponseBody
	public RespBase updateEmp(Emp emp,Integer userId,Integer deptId,Integer jobId) throws Exception{
		if(emp == null) return new RespBase(RespCode.FAIL).setMsg("传入参数错误");
		if(emp.getId() == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		if(userId != null){
			emp.setUser(new User());
			emp.getUser().setId(userId);
		}
		if(deptId != null){
			emp.setDept(new Dept());
			emp.getDept().setId(deptId);
		}
		if(jobId != null){
			emp.setJob(new Job());
			emp.getJob().setId(jobId);
		}
		emp = empService.update(emp);
		return new RespBase(emp == null ? RespCode.FAIL:RespCode.SUCCESS).setData(emp);
	}

}
