package com.adserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adserver.entity.AdCampaign;

@Repository
public interface AdCampaignDao extends JpaRepository<AdCampaign, String> {

	public List<AdCampaign> findAdCampaignByPartnerId(String partnerId);


}

