package com.mkthakral.tech.challange.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mkthakral.tech.challange.controller.MyController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MyController.class)
public class SmaatoControllerTest {

	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testAcceptIdMinInt() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/smaato/accept?id=" + Integer.MIN_VALUE);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		assertEquals("ok", result.getResponse().getContentAsString());
	}

	@Test
	public void testAcceptIdMaxInt() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/smaato/accept?id=" + Integer.MAX_VALUE);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		assertEquals("ok", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testAcceptIdNull() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/smaato/accept?id=");
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		assertEquals("ok", result.getResponse().getContentAsString());
	}
	
	@Test
	public void testAcceptParamMissing() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/smaato/accept");
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		assertEquals("failed", result.getResponse().getContentAsString());
	}

}
