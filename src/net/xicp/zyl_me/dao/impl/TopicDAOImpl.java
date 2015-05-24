package net.xicp.zyl_me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Transaction;

import net.xicp.zyl_me.dao.TopicDAO;
import net.xicp.zyl_me.entity.Category;
import net.xicp.zyl_me.entity.Message;
import net.xicp.zyl_me.entity.Topic;
import net.xicp.zyl_me.util.HibernateUtil;

public class TopicDAOImpl extends TopicDAO {

	@Override
	public boolean add(Topic topic) {
		Transaction transaction = null;
		boolean result = false;
		try {
			// TODO Auto-generated method stub
			transaction = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().save(topic);
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
	public boolean modify(Topic topic) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Topic> getAll() {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Topic order by topic_id desc");
		ArrayList<Topic> topics = (ArrayList<Topic>)query.list();
		HibernateUtil.closeSession();
		return topics;
	}

	@Override
	public Topic getById(int id) {
		Topic topic = (Topic)HibernateUtil.getSession().get(Topic.class, id);
		HibernateUtil.closeSession();
		return topic;
	}

	@Override
	public Message getFirstMessageById(int id) {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Message where topic_id = ? and message_floor = 1");
		query.setInteger(0, id);
		ArrayList<Message> messages = (ArrayList<Message>)query.list();
		HibernateUtil.closeSession();
		if(messages == null)
			return null;
		return messages.size() == 0 ? null : messages.get(0);
	}

	@Override
	public ArrayList<Message> getMessagesById(int id) {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Message where topic_id = ? order by message_floor");
		query.setInteger(0, id);
		ArrayList<Message> messages = (ArrayList<Message>)query.list();
		HibernateUtil.closeSession();
		return messages;
	}

	@Override
	public void rawAdd(Topic topic) {
		// TODO Auto-generated method stub
		HibernateUtil.getSession().save(topic);
	}

	@Override
	public ArrayList<Topic> getTopicsByUserId(int user_id) {
		// TODO Auto-generated method stub
		Query query = HibernateUtil.getSession().createQuery("from Topic where topic_id in (select topic.topic_id from Message where user_id = ? and message_floor = 1)");
		query.setInteger(0, user_id);
		ArrayList<Topic> topics = (ArrayList<Topic>)query.list();
		if(topics != null && topics.size() > 0)
		{
			return topics;
		}
		HibernateUtil.closeSession();
		return null;
	}

}
