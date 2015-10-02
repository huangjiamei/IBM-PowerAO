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

public class SaveselfAction extends Action {
	//依赖注入UserService 
	private AdministratorService administratorService;   
	//public static String ADNAME;
	 
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
		SaveselfActionForm saveselfActionForm = (SaveselfActionForm) form;
		// TODO Auto-generated method stub
		//得到session对象
		HttpSession session=request.getSession();

		Administrator administrator_1 = administratorService.FindByAdId(saveselfActionForm.getAdId());
		Administrator administrator = new Administrator();
		
		administrator.setAdId(saveselfActionForm.getAdId());
		administrator.setAdName(administrator_1.getAdName());
		administrator.setAdPwd(administrator_1.getAdPwd());
		administrator.setAdName1(saveselfActionForm.getAdName1());
		administrator.setAdGender(saveselfActionForm.getAdGender());
		administrator.setAdAge(saveselfActionForm.getAdAge());
		administrator.setAdPhone(saveselfActionForm.getAdPhone());
		administrator.setAdEmail(saveselfActionForm.getAdEmail());
		administrator.setAdposition(administrator_1.getAdposition());
		administrator.setAdDepartment(administrator_1.getAdDepartment());
		administrator.setAdEnrolltime(administrator_1.getAdEnrolltime());

		administratorService.Update(administrator);
		return mapping.findForward("saveself");
	}

}
