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

import com.abc.controller.EmpController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springmvc.xml","classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-transaction.xml"})
@WebAppConfiguration
public class EmpControllerTest {

	@Autowired
	EmpController empController;
	
	@Autowired
	private WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //构造MockMvc
	}
	
	@org.junit.Test
	public void getEmpByIdTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/emp/getEmpById")
				.param("id", "1")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void getEmpListTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/emp/getEmpList")
				//.param("jobId", "3")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void addEmpTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/emp/addEmp")
				.param("userId", "10")
				.param("deptId", "1")
				.param("jobId", "1")
				.param("name", "韦小宝")
				.param("salary", "10000")
				.param("phone", "13065474747")
				.param("addr", "深圳南山")
				.param("email", "79797979@qq.com")
				.param("sex", "1")
				.param("birthday", "1991-08-15")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void deleteEmpTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/emp/deleteEmp")
				.param("id", "1")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void updateEmpTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/emp/updateEmp")
				.param("id", "3")
				.param("userId", "15")
				.param("deptId", "3")
				.param("jobId", "3")
				.param("name", "肖大宝")
				.param("salary", "14000")
				.param("phone", "13065474747")
				.param("addr", "深圳福田")
				.param("email", "79797979@qq.com")
				.param("sex", "1")
				.param("birthday", "1991-09-02")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
}
