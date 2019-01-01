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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.crossover.techtrial.model.Book;
import com.crossover.techtrial.service.BookService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = BookController.class, secure = false)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	public void testBookReturnSuccessful() throws Exception {
		Book book1 = new Book();
		book1.setId(1234L);
		book1.setTitle("Tom Sawyer");

		Mockito.when(bookService.findById(Mockito.any())).thenReturn(book1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/1234").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"id\":1234,\"title\":\"Tom Sawyer\"}";
		assertEquals(expected, result.getResponse().getContentAsString());
	}

}
