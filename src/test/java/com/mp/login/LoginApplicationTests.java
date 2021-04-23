package com.mp.login;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import org.junit.jupiter.api.BeforeAll;
// import org.springframework.boot.test.context.SpringBootTest;
// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@WebMvcTest
@AutoConfigureMockMvc
class LoginApplicationTests {

	@Autowired
	private HelloUser controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void accessProtected() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isUnauthorized());
	}

	@Test
	public void loginUser() throws Exception {
		this.mockMvc.perform(get("/").with(httpBasic("user", "password"))).andExpect(authenticated());
		this.mockMvc.perform(get("/home").with(httpBasic("user", "admin"))).andExpect(authenticated());
	}

	@Test
	public void loginValidUser() throws Exception {
		this.mockMvc.perform(get("/").with(httpBasic("admin", "admin"))).andExpect(status().is2xxSuccessful());

		this.mockMvc.perform(get("/welcome").with(httpBasic("admin", "admin"))).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void loginUser2() throws Exception {
		this.mockMvc.perform(get("/").with(httpBasic("user", "password"))).andExpect(authenticated());
	}

	@Test
	public void loginUser1() throws Exception {
		this.mockMvc.perform(get("/").with(httpBasic("user", "password"))).andExpect(unauthenticated());
	}

	@Test
	public void testUser() throws Exception {
		mockMvc.perform(get("/").with(user("admin").password("pass"))).andExpect(status().is2xxSuccessful());
	}

}
