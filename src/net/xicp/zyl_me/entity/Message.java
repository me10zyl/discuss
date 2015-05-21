package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import net.xicp.zyl_me.entity.*;
import net.xicp.zyl_me.entity.*;

public class Message
{
	private int message_id;
	private int topic_id;
	private int user_id;
	private String message_content;
	private String message_time;
	private int message_floor;
	private Topic topic;
	private User user;

	public Message()
	{

	}

	public Message(int message_id,int topic_id,int user_id,String message_content,String message_time,int message_floor)
	{
		this.message_id = message_id;
		this.topic_id = topic_id;
		this.user_id = user_id;
		this.message_content = message_content;
		this.message_time = message_time;
		this.message_floor = message_floor;
	}

	public void setMessage_id(int message_id)
	{
		this.message_id = message_id;
	}

	public int getMessage_id()
	{
		return message_id;
	}

	public void setTopic_id(int topic_id)
	{
		this.topic_id = topic_id;
	}

	public int getTopic_id()
	{
		return topic_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setMessage_content(String message_content)
	{
		this.message_content = message_content;
	}

	public String getMessage_content()
	{
		return message_content;
	}

	public void setMessage_time(String message_time)
	{
		this.message_time = message_time;
	}

	public String getMessage_time()
	{
		return message_time;
	}

	public void setMessage_floor(int message_floor)
	{
		this.message_floor = message_floor;
	}

	public int getMessage_floor()
	{
		return message_floor;
	}

	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}

	public Topic getTopic()
	{
		return topic;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public User getUser()
	{
		return user;
	}

	public String toString()
	{
		return message_id + "\t" + topic_id + "\t" + user_id + "\t" + message_content + "\t" + message_time + "\t" + message_floor + "\t" + (this.topic == null ? "" : "\t" + topic) + (this.user == null ? "" : "\t" + user);
	}
}
