package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import net.xicp.zyl_me.entity.*;

public class Category
{
	private int category_id;
	private String category_name;
	private ArrayList<Topic> topic = new ArrayList<Topic>();

	public Category()
	{

	}


	public void setCategory_id(int category_id)
	{
		this.category_id = category_id;
	}

	public int getCategory_id()
	{
		return category_id;
	}

	public void setCategory_name(String category_name)
	{
		this.category_name = category_name;
	}

	public String getCategory_name()
	{
		return category_name;
	}

	public void setTopic(ArrayList<Topic> topic)
	{
		this.topic = topic;
	}

	public ArrayList<Topic> getTopic()
	{
		return topic;
	}

	public String toString()
	{
		return category_id + "\t" + category_name + "\t" + (this.topic.size() == 0? "" : "\t" + topic);
	}
}
