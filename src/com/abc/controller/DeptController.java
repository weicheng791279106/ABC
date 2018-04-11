package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.po.Dept;
import com.abc.po.RespBase;
import com.abc.service.DeptService;

@Controller
@RequestMapping("dept/")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	/**����Id��ȡ����*/
	@ResponseBody
	@RequestMapping("getDeptById")
	public RespBase getDeptById(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		Dept dept = id == null ? null:deptService.getDeptById(id);
		return new RespBase(dept == null ? RespCode.FAIL:RespCode.SUCCESS).setData(dept);
	}
	
	/**�����������Ҳ���*/
	@ResponseBody
	@RequestMapping("getDeptList")
	public RespBase getDeptList(Integer pageNo,Integer pageSize,Integer id,String name) throws Exception{
		Dept dept = new Dept();
		if(id != null) dept.setId(id);
		dept.setName(name);
		return new RespBase(RespCode.SUCCESS).setData(deptService.getDeptList(pageNo, pageSize, dept));
	}
	
	/**��Ӳ���*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="addDept")
	public RespBase addDept(String name, String remark) throws Exception{
		Dept dept = deptService.addDept(name, remark);
		return new RespBase(dept == null ? RespCode.FAIL:RespCode.SUCCESS).setData(dept);
	}
	
	/**ɾ������*/
	@ResponseBody
	@RequestMapping("deleteDept")
	public RespBase deleteDept(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		int result = deptService.deleteDept(id);
		return new RespBase(result == -1 ? RespCode.FAIL:RespCode.SUCCESS).setData(result);
	}
	
	/**���²���*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="updateDept")
	public RespBase updateDept(Dept dept) throws Exception{
		if(dept.getId() == null) return new RespBase(RespCode.FAIL).setMsg("û�д���Id");
		dept = deptService.updateDept(dept);
		return new RespBase(dept == null ? RespCode.FAIL:RespCode.SUCCESS).setData(dept);
	}

}
