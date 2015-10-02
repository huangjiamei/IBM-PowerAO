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

public class ShowselfAction extends Action {
	 
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
		ShowselfActionForm showselfActionForm = (ShowselfActionForm) form;
		// TODO Auto-generated method stub  	 
	
		HttpSession session=request.getSession();   
		//String LoginadName = LoginAction.ADNAME;
		
		//Administrator administrator=new Administrator(); 
		List administrator = administratorService.FindByAdName(LoginAction.ADNAME);
		request.setAttribute("users",administrator);
		return mapping.findForward("editself");	
	}
}
