package net.xicp.zyl_me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Transaction;

import net.xicp.zyl_me.dao.MessageDAO;
import net.xicp.zyl_me.entity.Message;
import net.xicp.zyl_me.entity.Topic;
import net.xicp.zyl_me.util.HibernateUtil;

public class MessageDAOImpl extends MessageDAO{

	@Override
	public boolean add(Message message) {
		Transaction transaction = null;
		boolean result = false;
		try {
			// TODO Auto-generated method stub
			transaction = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().save(message);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modify(Message newMessage) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Message> getAll() {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Message");
		ArrayList<Message> messages = (ArrayList<Message>)query.list();
		HibernateUtil.closeSession();
		return messages;
	}

	@Override
	public Message getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rawAdd(Message message) {
		// TODO Auto-generated method stub
		HibernateUtil.getSession().save(message);
	}
	
	

	@Override
	public ArrayList<Message> getOthersMessagesByUserId(int user_id) {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Message where topic_id in (select topic.topic_id from Message where user_id = ? and message_floor = 1) and message_floor != 1 and user_id != ?");
		query.setInteger(0, user_id);
		query.setInteger(1, user_id);
		ArrayList<Message> messages = (ArrayList<Message>)query.list();
		if(messages != null && messages.size() > 0)
		{
			return messages;
		}
		HibernateUtil.closeSession();
		return null;
	}

}
