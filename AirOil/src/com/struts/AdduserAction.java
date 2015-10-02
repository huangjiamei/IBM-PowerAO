package com.struts;

import java.util.List;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action; 
import org.apache.struts.action.ActionForm; 
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 
import com.pojo.Administrator; 
import com.service.AdministratorService;
import com.dao.AdministratorDAO;

public class AdduserAction extends Action {
	 
	private AdministratorService administratorService;   
		 
	public AdministratorService getAdministratorService() 
	{  
		return administratorService;  
	}   
	public void setAdministratorService(AdministratorService administratorService) 
	{   
		this.administratorService = administratorService;  
	} 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
	{ 
		AdduserActionForm adduserActionForm = (AdduserActionForm) form;
		// TODO Auto-generated method stub  	 
	
		HttpSession session=request.getSession();   
		Administrator administrator_1 = new Administrator();
		if(adduserActionForm.getAdName()!="")
		{
			administrator_1.setAdName(adduserActionForm.getAdName());
			administrator_1.setAdPwd("123456");
			administrator_1.setAdName1(adduserActionForm.getAdName1());
			administrator_1.setAdGender(adduserActionForm.getAdGender());
			administrator_1.setAdAge(adduserActionForm.getAdAge());
			administrator_1.setAdPhone(adduserActionForm.getAdPhone());
			administrator_1.setAdEmail(adduserActionForm.getAdEmail());
			administrator_1.setAdposition(adduserActionForm.getAdposition());
			administrator_1.setAdDepartment(adduserActionForm.getAdDepartment());
			administrator_1.setAdEnrolltime(adduserActionForm.getAdEnrolltime());
		
			administratorService.Add(administrator_1);
		
			List administrator = administratorService.FindAll();
			request.setAttribute("administrators",administrator);
			return mapping.findForward("adduser");
		}
		else
		{
			return mapping.findForward("addfail");
		}
	}
}
