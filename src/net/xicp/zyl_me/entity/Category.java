package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Category
{
	private int category_id;
	private String category_name;
	private Set<Topic> topics = new TreeSet<Topic>(new Comparator<Topic>() {
		@Override
		public int compare(Topic o1, Topic o2) {
			// TODO Auto-generated method stub
			return o2.getTopic_id() - o1.getTopic_id();
		}
		
	});

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

	public void setTopics(Set<Topic> topics)
	{
		this.topics = topics;
	}

	public Set<Topic> getTopics()
	{
		return topics;
	}

}
