package net.xicp.zyl_me.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import net.xicp.zyl_me.dao.CategoryDAO;
import net.xicp.zyl_me.dao.MessageDAO;
import net.xicp.zyl_me.dao.TopicDAO;
import net.xicp.zyl_me.dao.UserDAO;
import net.xicp.zyl_me.entity.Category;
import net.xicp.zyl_me.entity.Message;
import net.xicp.zyl_me.entity.Topic;
import net.xicp.zyl_me.entity.User;
import net.xicp.zyl_me.util.HibernateUtil;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport implements SessionAware {
	public static String TOPIC_LIST = "topic_list";
	public static String TOPIC_SINGLE = "topic_single";
	public static String RESULT = "result";
	public static String TOPICS = "topics";
	public static String MESSAGES = "messages";
	private TopicDAO topicDAO;
	private MessageDAO messageDAO;
	private CategoryDAO categoryDAO;
	private UserDAO userDAO;
	private ArrayList<Category> categories;
	private ArrayList<Topic> topics;
	private String message_content;
	private int category_id;
	private int select_category_id;
	public int getSelect_category_id() {
		return select_category_id;
	}
	public void setSelect_category_id(int select_category_id) {
		this.select_category_id = select_category_id;
	}

	private String topic_title;
	private int topic_id;
	private boolean result;
	private String message;

	private Map<String, Object> session;
	private ArrayList<Message> messages;
	private Topic topic;
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public int getCategory_id() {
		return category_id;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage_content() {
		return message_content;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public boolean getResult() {
		return result;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public String getTopic_title() {
		return topic_title;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

	public String getTopicList()
	{
		topics = topicDAO.getAll();
		return TOPICS;
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public String scanTopicList() {
		topics = topicDAO.getAll();
		categories = categoryDAO.getAll();
		return TOPIC_LIST;
	}
	public String scanTopicListByCategoryId() {
		if(category_id == -1)
		{
			return scanTopicList();
		}
		select_category_id = category_id;
		Category category = categoryDAO.getById(category_id);
		topics = new ArrayList<Topic>();
		Iterator<Topic> iterator = category.getTopics().iterator();
		while(iterator.hasNext())
		{
			Topic topic = iterator.next();
			System.out.println(topic);
			topics.add(topic);
		}
		categories = categoryDAO.getAll();
		return TOPIC_LIST;
	}
	
	public String getTopicListByCategoryId() {
		if(category_id == -1)
		{
			return getTopicList();
		}
		Category category = categoryDAO.getById(category_id);
		select_category_id = category_id;
		topics = new ArrayList<Topic>();
		Iterator<Topic> iterator = category.getTopics().iterator();
		while(iterator.hasNext())
		{
			Topic topic = iterator.next();
			System.out.println(topic);
			topics.add(topic);
		}
		return TOPICS;
	}

	public String scanTopicSingle(){
		topic = topicDAO.getById(topic_id);
		messages = topicDAO.getMessagesById(topic_id);
		return TOPIC_SINGLE;
	}
	
	public String getMessageList(){
		messages = topicDAO.getMessagesById(topic_id);
		return MESSAGES;
	}
	
	public String setMessage()
	{
		User user = (User) session.get("user");
		if(user == null)
		{
			result = false;
			message = "游客不能回复";
		}
		else if(message_content == null || "".equals(message_content))
		{
			result = false;
			message = "内容不能为空";
		}else{
			Message message2 = new Message();
			message2.setMessage_content(message_content);
			message2.setMessage_time(getCurrentTime());
			Topic topic = topicDAO.getById(topic_id);
			topic.setTopic_id(topic_id);
			message2.setTopic(topic);
			message2.setUser(user);
			message2.setMessage_floor(topic.getMessages().size() + 1);
			boolean success = messageDAO.add(message2);
			if(success)
			{
				result = true;
				message = "添加成功";
			}else
			{
				result = false;
				message = "回复失败";
			}
		}
		return RESULT;
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public String setTopic() {
		result = false;
		if (message_content == null || "".equals(message_content)) {
			result = false;
			message = "内容不能为空";
		} else if (category_id == -1) {
			result = false;
			message = "请选择主题";
		} else if (topic_title == null || topic_title.equals("")) {
			result = false;
			message = "请填写标题";
		} else {
			String time = getCurrentTime();
			Message message = new Message();
			message.setMessage_content(message_content);
			message.setMessage_floor(1);
			message.setMessage_time(time);
			System.out.println((User) session.get("user"));
			message.setUser((User) session.get("user"));
			Topic topic = new Topic();
			topic.setTopic_replyCount(0);
			topic.setTopic_scanCount(0);
			topic.setTopic_title(topic_title);
			topic.setCategory(categoryDAO.getById(category_id));
			topic.setTopic_activeTime("just now");
			Transaction transaction = HibernateUtil.getSession().beginTransaction();
			boolean success = false;
			try {
				topicDAO.rawAdd(topic);
				System.out.println(topic.getTopic_id());
				message.setTopic(topic);
				messageDAO.rawAdd(message);
				transaction.commit();
				success = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				transaction.rollback();
				e.printStackTrace();
			} finally {
				HibernateUtil.getSession().close();
			}
			if (success) {
				result = true;
				this.message = "发表主题成功";
			} else {
				result = false;
				this.message = "发表主题失败";
			}
		}
		return RESULT;
	}
	private String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date(System.currentTimeMillis()));
		return time;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public void setTopic_title(String topic_title) {
		this.topic_title = topic_title;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
