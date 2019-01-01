package com.crossover.techtrial.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class MemberTest {

	@Test
	public void testSetName() {
		Member member = new Member();
		member.setName("John Doe");
		assertEquals("John Doe",member.getName());
	}
	
	@Test
	public void testSetId() {
		Member member = new Member();
		member.setId(1234L);
		assertEquals(new Long(1234L),member.getId());
	}
	
	@Test
	public void testSetEmail() {
		Member member = new Member();
		member.setEmail("john.doe@crossover.com");
		assertEquals("john.doe@crossover.com",member.getEmail());
	}
	
	@Test
	public void testSetMembershipStatus() {
		Member member = new Member();
		member.setMembershipStatus(MembershipStatus.ACTIVE);;
		assertEquals(MembershipStatus.ACTIVE,member.getMembershipStatus());
	}
	
	@Test
	public void testSetMembershipStartDate() {
		Member member = new Member();
		LocalDateTime ldt = LocalDateTime.now();
		member.setMembershipStartDate(ldt);
		assertEquals(ldt,member.getMembershipStartDate());
	}
}
