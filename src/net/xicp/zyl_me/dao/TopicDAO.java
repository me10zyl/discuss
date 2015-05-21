package net.xicp.zyl_me.dao;

import java.util.ArrayList;

import net.xicp.zyl_me.AbstractDAO;
import net.xicp.zyl_me.entity.Topic;

public abstract class TopicDAO extends AbstractDAO<Topic>
{
	public abstract void add(Topic topic);

	public abstract void delete(int id);

	public abstract void modify(Topic topic);

	public abstract ArrayList<Topic> getAll();

	public abstract Topic getById(int id);

}