package net.xicp.zyl_me.entity;

import java.util.ArrayList;
import net.xicp.zyl_me.entity.*;

public class User
{
	private int user_id;
	private String user_email;
	private String user_password;
	private String user_nickname;
	private String user_avatar;
	private String user_introduction;
	private ArrayList<Message> message = new ArrayList<Message>();

	public User()
	{

	}


	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_email(String user_email)
	{
		this.user_email = user_email;
	}

	public String getUser_email()
	{
		return user_email;
	}

	public void setUser_password(String user_password)
	{
		this.user_password = user_password;
	}

	public String getUser_password()
	{
		return user_password;
	}

	public void setUser_nickname(String user_nickname)
	{
		this.user_nickname = user_nickname;
	}

	public String getUser_nickname()
	{
		return user_nickname;
	}

	public void setUser_avatar(String user_avatar)
	{
		this.user_avatar = user_avatar;
	}

	public String getUser_avatar()
	{
		return user_avatar;
	}

	public void setUser_introduction(String user_introduction)
	{
		this.user_introduction = user_introduction;
	}

	public String getUser_introduction()
	{
		return user_introduction;
	}

	public void setMessage(ArrayList<Message> message)
	{
		this.message = message;
	}

	public ArrayList<Message> getMessage()
	{
		return message;
	}

	public String toString()
	{
		return user_id + "\t" + user_email + "\t" + user_password + "\t" + user_nickname + "\t" + user_avatar + "\t" + user_introduction + "\t" + (this.message.size() == 0? "" : "\t" + message);
	}
}
