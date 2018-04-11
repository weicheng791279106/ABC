package com.abc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.mapper.JobMapper;
import com.abc.po.Job;
import com.abc.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobMapper jobMapper;
	
	@Override
	public Job getJobById(int id) throws Exception {
		return jobMapper.getJobById(id);
	}

	@Override
	public List<Job> getJobList(int pageNo, int pageSize, Job job) throws Exception {
		return jobMapper.getJobList((pageNo-1)*pageSize, pageSize, job);
	}

	@Override
	public int deleteJob(int id) throws Exception {
		Integer response = jobMapper.deleteJob(id);
		return response != null && response > 0 ? id:-1;
	}

	@Override
	public Job addJob(String name,String remark) throws Exception {
		Job job = new Job();
		job.setName(name);
		job.setRemark(remark);
		jobMapper.addJob(job);
		return job;
	}

	@Override
	public Job updateJob(Job job) throws Exception {
		jobMapper.updateJob(job);
		job = jobMapper.getJobById(job.getId());
		return job;
	}

}
