package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.AbstractDAO;
import net.xicp.zyl_me.entity.User;

public abstract class UserDAO extends AbstractDAO<User>
{
	public abstract void add(User user);

	public abstract void delete(int id);

	public abstract void modify(User newUser);

	public abstract ArrayList<User> getAll();

	public abstract User getById(int id);
}