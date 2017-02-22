package com.adserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="partner")
@NamedQuery(name="Partner.findAll", query="SELECT e FROM Partner e")
public class Partner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private String partnerId ;
	
	@Column(name="name")
	private String pname ;
	
	@Column(name="emailid")
	private String emailId ;
	
	@Column(name="password")
	private String password ;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
