package com.adserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adserver.entity.AdCampaign;
import com.adserver.metadata.ResponseObject;
import com.adserver.service.AdCampaignService;
import com.adserver.service.PartnerService;


@RestController
@RequestMapping(value = "/adcampaign")
public class AdCampaignController {

	private static final Logger logger = LoggerFactory.getLogger(AdCampaignController.class);
	
	@Autowired
	AdCampaignService adCampaignService;

	@Autowired
	PartnerService partnerService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> saveAdCampaign(@RequestBody AdCampaign adCampaign) {
		ResponseObject responseObject = new ResponseObject();
		logger.debug(" /create, request: " + adCampaign.toString());
		if (adCampaign.equals("") || adCampaign == null) {
			responseObject.setErrorres("sorry nulls are not allowed");
			logger.error("/create, sorry nulls are not allowed");
		} else {
			adCampaignService.createAdCampaign(adCampaign);
			logger.info("AdCampaignController /savecandiddtls, data saved successfully");
			responseObject.setSuccessres("data saved successfully");
		}
		logger.debug(" /create, response: " + responseObject);
		
		return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/fetchbyid/{partnerId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseObject> getAdCampaignById(@PathVariable String partnerId) {
		ResponseObject responseObject = new ResponseObject();
		logger.info("partner id"+partnerId);
			if (adCampaignService.getAdCampaignById(partnerId).isEmpty()) {
				responseObject.setErrorres("No Data Found in table");
				logger.error("/fetchbyid, No Data Found ");

			} else {
				responseObject.setDatares(adCampaignService.getAdCampaignById(partnerId));
				logger.debug("/fetchbyid,reponse: " + responseObject);

			}

			return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);


	}
	
	@RequestMapping(value = "/fetchads", method = RequestMethod.GET)
	public ResponseEntity<ResponseObject> getAllAdCampaigns() {
		ResponseObject responseObject = new ResponseObject();
			if (adCampaignService.getAdCampaign().isEmpty()==true) {
				responseObject.setErrorres("No Data Found in table");
				logger.error("/fetchbyid, No Data Found ");

			} else {
				responseObject.setDatares(adCampaignService.getAdCampaign());
				logger.info("response"+responseObject.getDatares());
				logger.debug("/fetchbyid,reponse: " + responseObject);

			}

			return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);


	}
	
	

	@RequestMapping(value = "/fetchpartners", method = RequestMethod.GET)
	public ResponseEntity<ResponseObject> getPartners() {
		ResponseObject responseObject = new ResponseObject();
			if (adCampaignService.getAdCampaign().isEmpty()==true) {
				responseObject.setErrorres("No Data Found in table");
				logger.error("/fetchbyid, No Data Found ");

			} else {
				responseObject.setDatares(partnerService.getPartnersList());
				logger.info("response"+responseObject.getDatares());
				logger.debug("/fetchbyid,reponse: " + responseObject);

			}

			return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);


	}
	
	
}
