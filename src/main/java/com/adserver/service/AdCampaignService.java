package com.adserver.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adserver.dao.AdCampaignDao;
import com.adserver.entity.AdCampaign;

@Service
public class AdCampaignService {

	@Autowired
	AdCampaignDao adCampaignDao;

	public AdCampaign createAdCampaign(AdCampaign adCampaign) {
		
		return adCampaignDao.save(adCampaign);

	}

	public List<AdCampaign> getAdCampaign() {

		return adCampaignDao.findAll();

	}

	public List<AdCampaign> getAdCampaignById(String partnerId) {
		List<AdCampaign> adCampaignList = adCampaignDao.findAdCampaignByPartnerId(partnerId);
		List<AdCampaign> adCampaignNew = new ArrayList<AdCampaign>();
		Calendar cal = Calendar.getInstance();
		for (AdCampaign adCampaign : adCampaignList) {
			cal.setTimeInMillis(adCampaign.getCreatedAt().getTime());
			cal.add(Calendar.SECOND, adCampaign.getDuration());
			Timestamp adDuration = new Timestamp(cal.getTime().getTime());
			Timestamp current = new Timestamp(Calendar.getInstance().getTime().getTime());

			if (adDuration.after(current)) {
				adCampaignNew.add(adCampaign);
			}

		}

		return adCampaignNew;

	}

}
