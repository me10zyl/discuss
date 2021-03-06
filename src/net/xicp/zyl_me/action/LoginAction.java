package net.xicp.zyl_me.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import net.xicp.zyl_me.dao.UserDAO;
import net.xicp.zyl_me.entity.User;
import net.xicp.zyl_me.util.AvatarUtil;
import net.xicp.zyl_me.util.HibernateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	public final static String HEADER = "header";
	public final static String REGISTER_RESULT = "result";
	public final static String INDEX = "index";
	public final static String ACTION_SCANTOPICLIST = "action_scantopiclist";
	private boolean result = false;
	private String message;
	private UserDAO userDAO;
	private String user_email;
	private String user_nickname;
	private String user_password;
	private String user_password_confirm;
	private Map<String, Object> session;

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_password_confirm() {
		return user_password_confirm;
	}

	public void setUser_password_confirm(String user_password_confirm) {
		this.user_password_confirm = user_password_confirm;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getHeader() {
		return HEADER;
	}

	public String getMessage() {
		return message;
	}

	public boolean isResult() {
		return result;
	}
	
	public String logout()
	{
		session.put("loginStatus", "logout");
		session.remove("user");
		return INDEX;
	}

	public String register() {
		if (checkForm()) {
			User user = new User();
			user.setUser_email(user_email);
			user.setUser_nickname(user_nickname);
			user.setUser_password(user_password);
			user.setUser_avatar(AvatarUtil.getRandomAvatar());
			boolean result = userDAO.add(user);
			if (result) {
				message = "注册成功!";
				result = true;
			} else {
				message = "注册失败!";
				result = false;
			}
		}
		return REGISTER_RESULT;
	}

	public String login() {
		result = true;
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "邮箱为空!";
		} else if (user_password == null || "".equals(user_password)) {
			result = false;
			message = "密码为空!";
		} else {
			User user = userDAO.getByUserEmail(user_email);
			if (user == null) {
				result = false;
				message = "邮箱不存在!";
			} else {
				if (user.getUser_password().equals(user_password)) {
					result = true;
					message = "登陆成功!";
					session.put("user", user);
					session.put("loginStatus", "login");
				} else {
					result = false;
					message = "密码错误!";
				}
			}
		}
		return REGISTER_RESULT;
	}

	public String checkEmail() {
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "邮箱为空!";
			return REGISTER_RESULT;
		}else if(!user_email.matches("[\\w_\\.]+@[\\w_]+(\\.[\\w_]+)+"))
		{
			message = "邮箱格式不正确!";
			result = false;
			return REGISTER_RESULT;
		}
		checkIsEmailBeRegisted_();
		return REGISTER_RESULT;
	}

	public String checkNickname() {
		if (user_nickname == null || "".equals(user_nickname)) {
			result = false;
			message = "昵称为空!";
		} else {
			result = true;
		}
		return REGISTER_RESULT;
	}

	public String checkPassword() {
		System.out.println("LoginAction.checkPassword()");
		if (user_password == null || "".equals(user_password)) {
			result = false;
			message = "密码为空!";
		} else {
			result = true;
		}
		return REGISTER_RESULT;
	}

	public String checkPasswordconfirm() {
		System.out.println("LoginAction.checkPasswordconfirm()");
		if (user_password_confirm == null || "".equals(user_password_confirm)) {
			result = false;
			message = "确认密码为空!";
			return REGISTER_RESULT;
		}
		if (!user_password_confirm.equals(user_password)) {
			message = "密码与确认密码不相同!";
			result = false;
		} else {
			result = true;
		}
		return REGISTER_RESULT;
	}

	private boolean checkForm() {
		boolean isRegisted = checkIsEmailBeRegisted_();
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "邮箱为空!";
		} else if (user_nickname == null || "".equals(user_nickname)) {
			result = false;
			message = "昵称为空!";
		} else if (user_password == null || "".equals(user_password)) {
			result = false;
			message = "密码为空!";
		} else if (user_password_confirm == null || "".equals(user_password_confirm)) {
			result = false;
			message = "确认密码为空!";
		} else if (isRegisted) {
			result = false;
			message = "该用户名已被注册!";
		} else if (!user_password.equals(user_password_confirm)) {
			message = "密码与确认密码不相同!";
			result = false;
		}else if(!user_email.matches("[\\w_\\.]+@[\\w_]+(.[\\w_]+)+"))
		{
			message = "邮箱格式不正确!";
			result = false;
		}
		return result;
	}

	private boolean checkIsEmailBeRegisted_() {
		boolean isRegisted = false;
		result = true;
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "邮箱为空!";
		} else {
			isRegisted = userDAO.isUserEmailRegisted(user_email);
			if (isRegisted) {
				message = "该用户名已被注册!";
				result = false;
			}
		}
		return isRegisted;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
