package com.crossover.techtrial.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TopMemberDTOTest {

	@Test
	public void testTopMemberDTO() {
		TopMemberDTO tdto = new TopMemberDTO(1234L,"John Doe","john.doe@crossover.com",2);
		assertEquals(new Long(1234L),tdto.getMemberId());
		assertEquals("John Doe",tdto.getName());
		assertEquals("john.doe@crossover.com",tdto.getEmail());
		assertEquals(new Integer(2),tdto.getBookCount());

	}
}
