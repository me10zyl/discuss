package net.xicp.zyl_me.action;

import java.util.ArrayList;
import java.util.Map;

import net.xicp.zyl_me.dao.MessageDAO;
import net.xicp.zyl_me.dao.TopicDAO;
import net.xicp.zyl_me.entity.Message;
import net.xicp.zyl_me.entity.Topic;
import net.xicp.zyl_me.entity.User;

import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware{
	public static final String PROFILE_ME="profile_me";
	private ArrayList<Topic> topics;
	private ArrayList<Message> replies;
	public ArrayList<Message> getReplies() {
		return replies;
	}
	public void setReplies(ArrayList<Message> replies) {
		this.replies = replies;
	}

	private TopicDAO topicDAO;
	private MessageDAO messageDAO;
	private Map<String, Object> session;
	private User user;
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	private int hover = 0;
	public int getHover() {
		return hover;
	}
	public void setHover(int hover) {
		this.hover = hover;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Topic> getTopics() {
		return topics;
	}
	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	public TopicDAO getTopicDAO() {
		return topicDAO;
	}
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	public String scanUserInformation(){
		user = (User)session.get("user");
		return scanUserInformationById(user.getUser_id());
	}
	public String scanUserInformationById(int id)
	{
		topics = topicDAO.getTopicsByUserId(id);
		replies = messageDAO.getOthersMessagesByUserId(id);
		return PROFILE_ME;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
}
