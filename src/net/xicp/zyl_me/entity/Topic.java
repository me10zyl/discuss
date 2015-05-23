package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Topic
{
	private int topic_id;
	private String topic_title;
	private int topic_replyCount;
	private int topic_scanCount;
	private String topic_activeTime;
	private Category category;
	private Set<Message> messages = new HashSet<Message>();

	public Topic()
	{

	}

	public void setTopic_id(int topic_id)
	{
		this.topic_id = topic_id;
	}

	public int getTopic_id()
	{
		return topic_id;
	}


	public void setTopic_title(String topic_title)
	{
		this.topic_title = topic_title;
	}

	public String getTopic_title()
	{
		return topic_title;
	}

	public void setTopic_replyCount(int topic_replyCount)
	{
		this.topic_replyCount = topic_replyCount;
	}

	public int getTopic_replyCount()
	{
		return topic_replyCount;
	}

	public void setTopic_scanCount(int topic_scanCount)
	{
		this.topic_scanCount = topic_scanCount;
	}

	public int getTopic_scanCount()
	{
		return topic_scanCount;
	}

	public void setTopic_activeTime(String topic_activeTime)
	{
		this.topic_activeTime = topic_activeTime;
	}

	public String getTopic_activeTime()
	{
		return topic_activeTime;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setMessages(Set<Message> messages)
	{
		this.messages = messages;
	}

	public Set<Message> getMessages()
	{
		return messages;
	}

}
