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

public class LoginAction extends Action {
	//依赖注入UserService 
	private AdministratorService administratorService;   
	public static String ADNAME;
	 
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
		LoginActionForm LoginActionForm = (LoginActionForm) form;
		// TODO Auto-generated method stub  	 
		//得到session对象
		HttpSession session=request.getSession();   

		Administrator administrator=new Administrator(); 
		administrator.setAdName(LoginActionForm.getAdName()); 
		administrator.setAdPwd(LoginActionForm.getAdPwd());
		ADNAME = LoginActionForm.getAdName();

		//如果用户名和密码输入正确登录成功
		if(administratorService.Login(administrator)) 
		{    
			return mapping.findForward("success");
		} 
		//如果输入错误提示错误 
		else 
		{    
			return mapping.findForward("error"); 
		}   
		
	}
}
