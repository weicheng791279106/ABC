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
public class NoticeControllerTest {

	@Autowired
	EmpController empController;
	
	@Autowired
	private WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //ππ‘ÏMockMvc
	}
	
	@org.junit.Test
	public void getNoticeByIdTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/notice/getNoticeById")
				.param("id", "1")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void getUserNoticeListTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/notice/getUserNoticeList")
				.param("id", "9")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}
	
	@org.junit.Test
	public void getAllUserNoticeListTest() throws Exception{
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/notice/getAllUserNoticeList")
				.accept(MediaType.APPLICATION_JSON));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("\n\n\n" + result + "\n\n\n");
	}

}
