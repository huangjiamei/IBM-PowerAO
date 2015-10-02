package com.service;
import com.pojo.Administrator;
import com.dao.AdministratorDAO;
import java.util.List;   
import org.springframework.context.ApplicationContext;   
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdministratorService {
	private static AdministratorDAO administratorDAO;
	
	public AdministratorDAO getAdministratorDAO()
	{
		return administratorDAO;
	}
	
	public void setAdministratorDAO(AdministratorDAO administratorDAO)
	{
		this.administratorDAO = administratorDAO;
	}
	
	//判断登陆
	public boolean Login(Administrator administrator)
	{
		return administratorDAO.verify(administrator);
	}
	
	//根据工号查询
	public List FindByAdName(Object adName)
	{
		return administratorDAO.findByAdName(adName);
	}
	
	//根据编号ID查询、
	public Administrator FindByAdId(java.lang.Integer adId)
	{
		return administratorDAO.findById(adId);
	}
	
	//更新个人信息
	public void Update(Administrator administrator)
	{
		administratorDAO.update(administrator);
	}
	
	//查询所有信息
	public List FindAll()
	{
		return administratorDAO.findAll();
	}

	//添加用户
	public void Add(Administrator administrator)
	{
		administratorDAO.save(administrator);
	}
	
	//删除选中的数据
	public static boolean Delete(Administrator administrator) {   
        try {   

        	administratorDAO.delete(administrator);   
            return true;   
        } catch (Exception e) {   
        }   
        return false;   
    }

	//判断密码是否正确
	public boolean Ispwd(Administrator administrator)
	{
		return administratorDAO.verify(administrator);
	}

}
