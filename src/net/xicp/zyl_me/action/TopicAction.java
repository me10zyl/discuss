package net.xicp.zyl_me.action;

import net.xicp.zyl_me.dao.TopicDAO;

import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport{
	public static String TOPIC_LIST = "topic_list";
	private TopicDAO topicDAO;
	public TopicDAO getTopicDAO() {
		return topicDAO;
	}
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	public String scanTopicList()
	{
		return TOPIC_LIST;
	}
}
