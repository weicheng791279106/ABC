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
public class UserControllerTest {

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
	public void getUserListTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserList")
				.param("loginName", "meng")
				.param("userName", "萌")
				.param("pageNo", "1")
				.param("pageSize", "2")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	
	@org.junit.Test
	public void addUserTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user/addUser")
				.param("loginName", "chunmengdriver")
				.param("pwd", "123456")
				.param("userName", "蠢萌车主")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void deleteUserTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/user/deleteUser")
				.param("id", "6")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void updateUserTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user/updateUser")
				.param("id", "7")
				.param("userName", "王大宝")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	
	
}







