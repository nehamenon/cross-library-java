/**
 * 
 */
package com.crossover.techtrial.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.crossover.techtrial.model.Member;
import com.crossover.techtrial.service.MemberService;

/**
 * @author kshah
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = MemberController.class, secure = false)
public class MemberControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MemberService memberService;

	@Test
	public void testMemberRegsitrationsuccessful() throws Exception {
		Member member1 = new Member();
		member1.setId(1234L);
		member1.setName("John Doe");
		member1.setEmail("john.doe@crossover.com");

		Mockito.when(memberService.findById(Mockito.any())).thenReturn(member1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/member/1234").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"id\":1234,\"name\":\"John Doe\",\"email\":\"john.doe@crossover.com\",\"membershipStatus\":null,\"membershipStartDate\":null}";
		assertEquals(expected, result.getResponse().getContentAsString());
	}

}
