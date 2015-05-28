package net.xicp.zyl_me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;

import net.xicp.zyl_me.dao.UserDAO;
import net.xicp.zyl_me.entity.Topic;
import net.xicp.zyl_me.entity.User;
import net.xicp.zyl_me.util.HibernateUtil;

public class UserDAOImpl extends UserDAO {
	@Override
	public boolean add(User user) {
		Transaction transaction = null;
		boolean result = false;
		try {
			// TODO Auto-generated method stub
			transaction = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().save(user);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}finally{
		HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean modify(User newUser) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		try {
			// TODO Auto-generated method stub
			transaction = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().update(newUser);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
		return result;
	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		User user = (User)HibernateUtil.getSession().get(User.class, id);
		HibernateUtil.closeSession();
		return user;
	}

	@Override
	public User getByUserEmail(String user_email) {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from User where user_email = ?");
		query.setString(0, user_email);
		ArrayList<User> users = (ArrayList<User>) query.list();
		HibernateUtil.closeSession();
		if(users == null)
		{
			return null;
		}
		return users.size() == 0 ? null : users.get(0);
	}

	@Override
	public boolean isUserEmailRegisted(String user_email) {
		// TODO Auto-generated method stub
		boolean isRegisted = false;
		User user = getByUserEmail(user_email);
		if(user != null)
			isRegisted = true;
		return isRegisted;
	}
}
