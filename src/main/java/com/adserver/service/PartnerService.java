package com.adserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adserver.dao.PartnerDao;
import com.adserver.entity.Partner;

@Service
public class PartnerService {
	
	@Autowired
	public PartnerDao partnerDao;
	
	public Partner authenticateUserDtls(String userName,String password)
	{
		
		Partner partner=partnerDao.findPartnerByEmailIdAndPassword(userName, password);
		
		return partner;
	}

}
