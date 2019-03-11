package com.cg.fra.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.fra.dto.FlatRegistrationDTO;

class FlatRegistrationDaoImplTest {

	static FlatRegistrationDaoImpl flat1 ;
	@BeforeAll
	public static void init() {
		flat1 = new FlatRegistrationDaoImpl();
	}
	@Test	void testRegisterFlat() {
		 
		FlatRegistrationDTO flat2 = new FlatRegistrationDTO();
		FlatRegistrationDTO flat3= new FlatRegistrationDTO();
		flat2.setOwnerId(1);
		flat2.setFlatType(1);
		flat2.setFlatArea(450);
		flat2.setRentAmount(4000);
		flat2.setDepositAmount(6000);
		flat3 = flat1.registerFlat(flat2);
		assertEquals(flat2, flat3);
	}

	@Test
	void testGetAllOwnersIds() {
		
		ArrayList< Integer> a= new ArrayList<Integer>(); 
		a.add(1);
		a.add(2);
		a.add(3);
		
	  assertEquals(a,flat1.getAllOwnersIds());


	}

}
