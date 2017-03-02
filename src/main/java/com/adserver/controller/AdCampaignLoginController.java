package com.adserver.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adserver.entity.Partner;
import com.adserver.metadata.JwtTokenGen;
import com.adserver.metadata.ResponseObject;
import com.adserver.metadata.UserValidator;
import com.adserver.service.PartnerService;

@RestController
public class AdCampaignLoginController {

	@Autowired
	PartnerService partnerService;
	
	@Autowired
	JwtTokenGen jwtTokenGenVal;

	@Autowired
	UserValidator user;
	@RequestMapping(value="/", method = RequestMethod.GET )
	public String index(){
	    return "index";
	}   
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public ResponseEntity login(HttpServletRequest request,
			@RequestBody Map<String, String> json)
	{
		boolean userExists;
		String uuid=UUID.randomUUID().toString();
		ResponseObject responseObject=new ResponseObject();
		System.out.println("beforeeeeeeeeeee");
		String userName=json.get("emailId");
		String password=json.get("password");
		if(userName==null && password ==null)
		{
			responseObject.setErrorres("incorrect username and password please try again");
		}else{
			Partner partner=partnerService.authenticateUserDtls(userName, password);
			String name=partner.getPname();
			if(partner==null)
			{
				responseObject.setErrorres("username and password does not exist");
			}else
			{
				String token=jwtTokenGenVal.jwtTokenGenerator(userName, uuid);
				
				Map<String,String> map=new HashMap<String,String>();
				map.put("token", token);
				map.put("partnerName", name);
				
				user.saveToken(uuid, token);
				
				responseObject.setDatares(map);
			}
		}
		

		return new ResponseEntity(responseObject,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/signout",method=RequestMethod.POST)
	public ResponseEntity<ResponseObject> signout(HttpServletRequest req)
	{
		ResponseObject response=new ResponseObject();
		System.out.println(req.getHeader("token"));
		String token=req.getHeader("token");
		if(token==null)
		{	
			response.setErrorres("token empty");
		}else
		{
			user.removeToken(token);
			response.setSuccessres("successfully logged out");
		}
		
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
}
