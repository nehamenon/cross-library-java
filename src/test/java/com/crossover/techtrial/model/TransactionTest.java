package com.crossover.techtrial.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void testSetId() {
		Transaction transaction = new Transaction();
		transaction.setId(123456789L);
		assertEquals(new Long(123456789L),transaction.getId());
	}
	
	@Test
	public void testSetBook() {
		Transaction transaction = new Transaction();
		Book book1 = new Book();
		book1.setId(1234L);
		book1.setTitle("Tom Sawyer");
		
		Book book2 = new Book();
		book2.setId(1234L);
		book2.setTitle("Tom Sawyer");
		transaction.setBook(book1);
		assertEquals(book2,transaction.getBook());
	}
	
	@Test
	public void testSetMember() {
		Transaction transaction = new Transaction();
		Member member1 = new Member();
		member1.setId(1234L);
		member1.setName("John Doe");
		member1.setEmail("john.doe@crossover.com");
		
		Member member2 = new Member();
		member2.setId(1234L);
		member2.setName("John Doe");
		member2.setEmail("john.doe@crossover.com");

		transaction.setMember(member1);
		assertEquals(member2,transaction.getMember());
	}
	
	@Test
	public void testSetDateOfIssue() {
		Transaction transaction = new Transaction();
		LocalDateTime ldt = LocalDateTime.now();
		
		transaction.setDateOfIssue(ldt);
		assertEquals(ldt,transaction.getDateOfIssue());
	}
	
	@Test
	public void testSetDateOfReturn() {
		Transaction transaction = new Transaction();
		LocalDateTime ldt = LocalDateTime.now();
		
		transaction.setDateOfReturn(ldt);
		assertEquals(ldt,transaction.getDateOfReturn());
	}
}
