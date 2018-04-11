package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.conts.RespCode;
import com.abc.po.Job;
import com.abc.po.RespBase;
import com.abc.service.JobService;

@Controller
@RequestMapping("job/")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	/**根据Id获取岗位*/
	@ResponseBody
	@RequestMapping("getJobById")
	public RespBase getJobById(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		Job job = id == null ? null:jobService.getJobById(id);
		return new RespBase(job == null ? RespCode.FAIL:RespCode.SUCCESS).setData(job);
	}
	
	/**根据条件查找岗位*/
	@ResponseBody
	@RequestMapping("getJobList")
	public RespBase getJobList(Integer pageNo,Integer pageSize,Integer id,String name) throws Exception{
		Job job = new Job();
		if(id != null) job.setId(id);
		job.setName(name);
		return new RespBase(RespCode.SUCCESS).setData(jobService.getJobList(pageNo, pageSize, job));
	}
	
	/**添加岗位*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="addJob")
	public RespBase addJob(String name, String remark) throws Exception{
		Job job = jobService.addJob(name, remark);
		return new RespBase(job == null ? RespCode.FAIL:RespCode.SUCCESS).setData(job);
	}
	
	/**删除岗位*/
	@ResponseBody
	@RequestMapping("deleteJob")
	public RespBase deleteJob(Integer id) throws Exception{
		if(id == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		int result = jobService.deleteJob(id);
		return new RespBase(result == -1 ? RespCode.FAIL:RespCode.SUCCESS).setData(result);
	}
	
	/**更新岗位*/
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="updateJob")
	public RespBase updateJob(Job job) throws Exception{
		if(job.getId() == null) return new RespBase(RespCode.FAIL).setMsg("没有传入Id");
		job = jobService.updateJob(job);
		return new RespBase(job == null ? RespCode.FAIL:RespCode.SUCCESS).setData(job);
	}

}
