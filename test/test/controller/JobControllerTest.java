package test.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.abc.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springmvc.xml","classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"})
@WebAppConfiguration
public class JobControllerTest {

	@Autowired
	UserController userController;
	
	@Autowired
	private WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //构造MockMvc
	}
	
	@org.junit.Test
	public void getJobByIdTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/job/getJobById")
				.param("id", "1")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void getJobListTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/job/getJobList")
				.param("pageNo", "1")
				.param("pageSize", "10")
				//.param("id", "1")
				.param("name", "Android")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void addJobTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/job/addJob")
				.param("name", "iOS开发")
				.param("remark", "水果机真贵")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void deleteJobTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/job/deleteJob")
				.param("id", "2")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void updateJobTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/job/updateJob")
				.param("id", "3")
				.param("remark", "水果机是真真贵")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	
	
}
