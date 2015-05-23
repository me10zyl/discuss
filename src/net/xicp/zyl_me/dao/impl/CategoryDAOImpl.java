package net.xicp.zyl_me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.xicp.zyl_me.dao.CategoryDAO;
import net.xicp.zyl_me.entity.Category;
import net.xicp.zyl_me.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDAOImpl extends CategoryDAO{
	@Override
	public boolean add(Category category) {
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean delete(int id) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modify(Category newCategory) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Category> getAll() {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Category");
		ArrayList<Category> arr = (ArrayList<Category>) query.list();
		HibernateUtil.closeSession();
		return arr;
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		Category category = (Category)HibernateUtil.getSession().get(Category.class, id);
		HibernateUtil.closeSession();
		return category;
	}

}
