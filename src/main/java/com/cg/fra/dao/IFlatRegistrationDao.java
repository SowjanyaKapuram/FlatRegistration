package com.cg.fra.dao;

import java.util.ArrayList;

import com.cg.fra.dto.FlatRegistrationDTO;

public interface IFlatRegistrationDao {
	FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat);
	ArrayList<Integer> getAllOwnersIds();
	

}
