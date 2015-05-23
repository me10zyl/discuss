package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.entity.Category;

public abstract class CategoryDAO implements DAOInterface<Category>
{
	public abstract boolean add(Category category);

	public abstract boolean delete(int id);

	public abstract boolean modify(Category newCategory);

	public abstract ArrayList<Category> getAll();

	public abstract Category getById(int id);

}