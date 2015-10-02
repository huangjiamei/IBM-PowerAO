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

public class EditpwdAction extends Action {
	//依赖注入UserService 
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
		EditpwdActionForm editpwdActionForm = (EditpwdActionForm) form;
		// TODO Auto-generated method stub
		//得到session对象
		HttpSession session=request.getSession();

		Administrator administrator_1 = administratorService.FindByAdId(editpwdActionForm.getAdId());
		Administrator administrator = new Administrator();
		Administrator administrator_2 = new Administrator();
		administrator_2.setAdName(LoginAction.ADNAME);
		administrator_2.setAdPwd(editpwdActionForm.getAdPwdl());
		
		
		if(administratorService.Ispwd(administrator_2)) 
		{    
			administrator.setAdId(editpwdActionForm.getAdId());
			administrator.setAdName(administrator_1.getAdName());
			administrator.setAdPwd(editpwdActionForm.getAdPwdn());
			administrator.setAdName1(administrator_1.getAdName1());
			administrator.setAdGender(administrator_1.getAdGender());
			administrator.setAdAge(administrator_1.getAdAge());
			administrator.setAdPhone(administrator_1.getAdPhone());
			administrator.setAdEmail(administrator_1.getAdEmail());
			administrator.setAdposition(administrator_1.getAdposition());
			administrator.setAdDepartment(administrator_1.getAdDepartment());
			administrator.setAdEnrolltime(administrator_1.getAdEnrolltime());
			
			administratorService.Update(administrator);
			return Showpwd(mapping,form,request,response);
		} 
		//如果输入错误提示错误 
		else 
		{    
			return mapping.findForward("error"); 
		}
	}
	public ActionForward Showpwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
	{ 
		
		List administrator = administratorService.FindByAdName(LoginAction.ADNAME);
		request.setAttribute("users",administrator);
		return mapping.findForward("savepwd");	
	}

}
