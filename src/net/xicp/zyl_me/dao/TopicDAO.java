package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.entity.Topic;

public abstract class TopicDAO implements DAOInterface<Topic>
{
	public abstract boolean add(Topic topic);

	public abstract boolean delete(int id);

	public abstract boolean modify(Topic topic);

	public abstract ArrayList<Topic> getAll();

	public abstract Topic getById(int id);

}