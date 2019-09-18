package com.cts;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockMarketUserApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testCreateUser() throws Exception{
		mvc.perform(MockMvcRequestBuilders
		   .post("/user")
		   .content(asJsonString(new User("Ajinkya","ajjupajju","user","ajju@gmail.com","132456789","confirmed")))
		   .contentType(MediaType.APPLICATION_JSON)
		   .accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isCreated());
		   
	}
	
	@Test
	public void testEditUser() throws Exception{
		mvc.perform(MockMvcRequestBuilders
		   .post("/user/edit")
		   .content(asJsonString(new User(1,"Ajju","465","user","ajju@gmail.com","989877","confirmed")))
		   .contentType(MediaType.APPLICATION_JSON)
		   .accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isAccepted());
		   
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
