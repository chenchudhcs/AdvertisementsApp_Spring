package com.adserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adserver.entity.Partner;

@Repository
public interface PartnerDao extends JpaRepository<Partner,String>{

	public Partner findPartnerByEmailIdAndPassword(String userName,String password);
}
