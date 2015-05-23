package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.entity.Message;

public abstract class MessageDAO implements DAOInterface<Message>
{
	public abstract boolean add(Message message);
	
	public abstract void rawAdd(Message message);

	public abstract boolean delete(int id);

	public abstract boolean modify(Message newMessage);

	public abstract ArrayList<Message> getAll();

	public abstract Message getById(int id);
	
}