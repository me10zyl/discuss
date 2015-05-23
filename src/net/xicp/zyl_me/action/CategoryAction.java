package net.xicp.zyl_me.action;

import java.util.ArrayList;

import net.xicp.zyl_me.dao.CategoryDAO;
import net.xicp.zyl_me.dao.impl.CategoryDAOImpl;
import net.xicp.zyl_me.entity.Category;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	public final static String FOOTER = "footer";
	private CategoryDAO categoryDAO;
	private ArrayList<Category> categories;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public String getFooter() {
		categories = categoryDAO.getAll();
		return FOOTER;
	}
}
