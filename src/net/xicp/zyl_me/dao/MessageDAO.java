package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.AbstractDAO;
import net.xicp.zyl_me.entity.Message;

public abstract class MessageDAO extends AbstractDAO<Message>
{
	public abstract void add(Message message);

	public abstract void delete(int id);

	public abstract void modify(Message newMessage);

	public abstract ArrayList<Message> getAll();

	public abstract Message getById(int id);

}