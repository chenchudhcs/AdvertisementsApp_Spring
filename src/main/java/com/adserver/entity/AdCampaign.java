package com.adserver.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ad_campaign")
@NamedQuery(name = "AdCampaign.findAll", query = "SELECT e FROM AdCampaign e")
public class AdCampaign implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "SNO")
	private String sno;

	@Column(name = "PARTNER_ID")
	private String partnerId;

	private int duration;

	@Column(name = "AD_CONTENT")
	private String adContent;

	@Column(name = "CREATED_AT")
	private Timestamp createdAt;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	@Override
	public String toString() {
		return "AdCampaign [partnerId=" + partnerId + ", duration=" + duration + ", adContent=" + adContent + "]";
	}

}
