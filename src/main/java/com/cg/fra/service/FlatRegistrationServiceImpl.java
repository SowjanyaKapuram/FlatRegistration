package com.cg.fra.service;

import java.util.ArrayList;

import com.cg.fra.dao.FlatRegistrationDaoImpl;
import com.cg.fra.dao.IFlatRegistrationDao;
import com.cg.fra.dto.FlatRegistrationDTO;

public class FlatRegistrationServiceImpl implements IFlatRegistrationService {
	
	IFlatRegistrationDao flatRegistrationDao = new FlatRegistrationDaoImpl();
	
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO flat) {
		return flatRegistrationDao.registerFlat(flat);
		
	}

	public ArrayList<Integer> getAllOwnersIds() {
		 
		return flatRegistrationDao.getAllOwnersIds();
	}
	
	

}
