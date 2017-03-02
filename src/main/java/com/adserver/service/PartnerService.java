package com.adserver.service;

import java.util.List;

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
	
	public List<Partner> getPartnersList()
	{
		
		
		return partnerDao.findAll();
		
	}

}
