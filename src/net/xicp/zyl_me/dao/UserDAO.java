package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.entity.User;

public abstract class UserDAO implements DAOInterface<User>
{
	public abstract boolean add(User user);

	public abstract boolean delete(int id);

	public abstract boolean modify(User newUser);

	public abstract ArrayList<User> getAll();

	public abstract User getById(int id);
	
	public abstract User getByUserEmail(String user_email);
	
	public abstract boolean isUserEmailRegisted(String user_email);
}