package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import net.xicp.zyl_me.entity.*;
import net.xicp.zyl_me.entity.*;

public class Message
{
	private int message_id;
	private String message_content;
	private String message_time;
	private int message_floor;
	private User user;
	private Topic topic;

	public Message()
	{

	}


	public void setMessage_id(int message_id)
	{
		this.message_id = message_id;
	}

	public int getMessage_id()
	{
		return message_id;
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

	public void setUser(User user)
	{
		this.user = user;
	}

	public User getUser()
	{
		return user;
	}

	public void setTopic(Topic topic)
	{
		this.topic = topic;
	}

	public Topic getTopic()
	{
		return topic;
	}

}
