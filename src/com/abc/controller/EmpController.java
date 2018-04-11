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
	
	/**����Id��ѯԱ��*/
	@RequestMapping("getEmpById")
	@ResponseBody
	public RespBase getEmpById(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		Emp emp = empService.getEmpById(id);
		return new RespBase(emp == null ? RespCode.FAIL:RespCode.SUCCESS).setData(emp);
	}
	
	/**����������ѯԱ��*/
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
	
	/**���Ա��*/
	@RequestMapping(method=RequestMethod.POST,value="addEmp")
	@ResponseBody
	public RespBase addEmp(Emp emp,Integer userId,Integer deptId,Integer jobId) throws Exception{
		if(userId == null || deptId == null || jobId == null) return new RespBase(RespCode.FAIL).setMsg("�봫��userId��deptId��jobId");
		emp.setUser(new User());
		emp.getUser().setId(userId);
		emp.setDept(new Dept());
		emp.getDept().setId(deptId);
		emp.setJob(new Job());
		emp.getJob().setId(jobId);
		empService.addEmp(emp);
		return new RespBase(RespCode.SUCCESS).setData(emp);
	}
	
	/**ɾ��Ա��*/
	@RequestMapping("deleteEmp")
	@ResponseBody
	public RespBase deleteEmp(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		int result = empService.deleteEmp(id);
		return new RespBase(result == -1 ? RespCode.FAIL:RespCode.SUCCESS).setData(result);
	}
	
	/**����Ա��*/
	@RequestMapping(method=RequestMethod.POST,value="updateEmp")
	@ResponseBody
	public RespBase updateEmp(Emp emp,Integer userId,Integer deptId,Integer jobId) throws Exception{
		if(emp == null) return new RespBase(RespCode.FAIL).setMsg("�����������");
		if(emp.getId() == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
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
