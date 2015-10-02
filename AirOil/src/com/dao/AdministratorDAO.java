package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Administrator;


/**
 * A data access object (DAO) providing persistence and search support for
 * Administrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Administrator
 * @author MyEclipse Persistence Tools
 */
public class AdministratorDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(AdministratorDAO.class);
	// property constants
	public static final String AD_NAME = "adName";
	public static final String AD_PWD = "adPwd";
	public static final String AD_GENDER = "adGender";
	public static final String AD_AGE = "adAge";
	public static final String ADPOSITION = "adposition";
	public static final String AD_EMAIL = "adEmail";
	public static final String AD_PHONE = "adPhone";
	public static final String AD_NAME1 = "adName1";
	public static final String AD_DEPARTMENT = "adDepartment";
	public static final String AD_ENROLLTIME = "adEnrolltime";

	protected void initDao() {
		// do nothing
	}

	public void save(Administrator transientInstance) {
		log.debug("saving Administrator instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Administrator persistentInstance) {
		log.debug("deleting Administrator instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(Administrator transientInstance) 
	{   
		log.debug("saving Book instance");   
		try 
		{   		             
			getHibernateTemplate().update(transientInstance);   
			log.debug("save successful");   
		}
		catch (RuntimeException re) 
		{   
			log.error("save failed", re);   
			throw re;   
		}   
	}

	public Administrator findById(java.lang.Integer id) {
		log.debug("getting Administrator instance with id: " + id);
		try {
			Administrator instance = (Administrator) getHibernateTemplate()
					.get("com.pojo.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrator instance) {
		log.debug("finding Administrator instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Administrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdName(Object adName) {
		return findByProperty(AD_NAME, adName);
	}

	public List findByAdPwd(Object adPwd) {
		return findByProperty(AD_PWD, adPwd);
	}

	public List findByAdGender(Object adGender) {
		return findByProperty(AD_GENDER, adGender);
	}

	public List findByAdAge(Object adAge) {
		return findByProperty(AD_AGE, adAge);
	}

	public List findByAdposition(Object adposition) {
		return findByProperty(ADPOSITION, adposition);
	}

	public List findByAdEmail(Object adEmail) {
		return findByProperty(AD_EMAIL, adEmail);
	}

	public List findByAdPhone(Object adPhone) {
		return findByProperty(AD_PHONE, adPhone);
	}

	public List findByAdName1(Object adName1) {
		return findByProperty(AD_NAME1, adName1);
	}

	public List findByAdDepartment(Object adDepartment) {
		return findByProperty(AD_DEPARTMENT, adDepartment);
	}

	public List findByAdEnrolltime(Object adEnrolltime) {
		return findByProperty(AD_ENROLLTIME, adEnrolltime);
	}

	public List findAll() {
		log.debug("finding all Administrator instances");
		try {
			String queryString = "from Administrator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Administrator merge(Administrator detachedInstance) {
		log.debug("merging Administrator instance");
		try {
			Administrator result = (Administrator) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrator instance) {
		log.debug("attaching dirty Administrator instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrator instance) {
		log.debug("attaching clean Administrator instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdministratorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdministratorDAO) ctx.getBean("AdministratorDAO");
	}
	
	public boolean verify(Administrator administrator)  { 	 
		String hql = "from Administrator as a where a.adName=? and a.adPwd=?"; 
		List list = this.getHibernateTemplate().find(hql, 
		new Object[]{administrator.getAdName(),administrator.getAdPwd()}); //返回用户名为user.getUsername(),密码为user.getUserpwd()的所有对象
		  if(list.size() > 0)   //判断返回的list有多少个值
		  {    
			  return true;  
		  }
		  else
		  {
			  return false; 
		  }
	}
}