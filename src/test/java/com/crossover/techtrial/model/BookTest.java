package com.crossover.techtrial.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookTest {

	@Test
	public void testSetTitle() {
		Book book = new Book();
		book.setTitle("mybook");
		assertEquals("mybook",book.getTitle());
	}
	
	@Test
	public void testSetId() {
		Book book = new Book();
		book.setId(1234L);
		assertEquals(new Long(1234L),book.getId());
	}
}
