package com.struts;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class SaveselfActionForm extends ActionForm {
	private Integer adId;
	private String adName;
	private String adPwd;
	private String adGender;
	private String adAge;
	private String adposition;
	private String adEmail;
	private String adPhone;
	private String adName1;
	private String adDepartment;
	private String adEnrolltime;
	
	
	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return this.adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPwd() {
		return this.adPwd;
	}

	public void setAdPwd(String adPwd) {
		this.adPwd = adPwd;
	}

	public String getAdGender() {
		return this.adGender;
	}

	public void setAdGender(String adGender) {
		this.adGender = adGender;
	}

	public String getAdAge() {
		return this.adAge;
	}

	public void setAdAge(String adAge) {
		this.adAge = adAge;
	}

	public String getAdposition() {
		return this.adposition;
	}

	public void setAdposition(String adposition) {
		this.adposition = adposition;
	}

	public String getAdEmail() {
		return this.adEmail;
	}

	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	public String getAdPhone() {
		return this.adPhone;
	}

	public void setAdPhone(String adPhone) {
		this.adPhone = adPhone;
	}

	public String getAdName1() {
		return this.adName1;
	}

	public void setAdName1(String adName1) {
		this.adName1 = adName1;
	}

	public String getAdDepartment() {
		return this.adDepartment;
	}

	public void setAdDepartment(String adDepartment) {
		this.adDepartment = adDepartment;
	}

	public String getAdEnrolltime() {
		return this.adEnrolltime;
	}

	public void setAdEnrolltime(String adEnrolltime) {
		this.adEnrolltime = adEnrolltime;
	}

}
