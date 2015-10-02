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

public class DeleteAction extends Action {
	 
		private AdministratorService administratorService;   
				 
		public AdministratorService getAdministratorService() {  
			return administratorService;  
			}   
		public void setAdministratorService(AdministratorService administratorService) {   
			this.administratorService = administratorService;  
			} 
		public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
		{
			String id=request.getParameter("ids");
			//String id = "14";
			Administrator administrator = administratorService.FindByAdId(Integer.parseInt(id));
			if(AdministratorService.Delete(administrator))
			{
				
				return ListAdministrator(mapping,form,request,response);
			}
			else
			{
				String message = "删除失败";
				request.setAttribute("message",message);
				return mapping.findForward("message");
			}
		}
		public ActionForward ListAdministrator(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		{
			List administrator = administratorService.FindAll();
			request.setAttribute("administrators",administrator);
			return mapping.findForward("deleteuser");
		}
}
