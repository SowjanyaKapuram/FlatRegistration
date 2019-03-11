package com.cg.fra.service;

import java.util.ArrayList;

import com.cg.fra.dto.FlatRegistrationDTO;

public interface IFlatRegistrationService {
	FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat);
	ArrayList<Integer> getAllOwnersIds();
	

}
