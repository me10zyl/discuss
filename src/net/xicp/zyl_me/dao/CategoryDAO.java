package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.AbstractDAO;
import net.xicp.zyl_me.entity.Category;

public abstract class CategoryDAO extends AbstractDAO<Category>
{
	public abstract void add(Category category);

	public abstract void delete(int id);

	public abstract void modify(Category newCategory);

	public abstract ArrayList<Category> getAll();

	public abstract Category getById(int id);

}