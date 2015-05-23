package net.xicp.zyl_me.action;

import net.xicp.zyl_me.dao.UserDAO;
import net.xicp.zyl_me.entity.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	public final static String HEADER = "header";
	public final static String REGISTER_RESULT = "register_result";
	public final static String ACTION_SCANTOPICLIST = "action_scantopiclist";
	private boolean result = false;
	private String message;
	private UserDAO userDAO;
	private String user_email;
	private String user_nickname;
	private String user_password;
	private String user_password_confirm;

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

	public String register() {
		if (checkForm()) {
			User user = new User();
			user.setUser_email(user_email);
			user.setUser_nickname(user_nickname);
			user.setUser_password(user_password);
			boolean result = userDAO.add(user);
			if (result) {
				message = "ע��ɹ�!";
				result = true;
			} else {
				message = "ע��ʧ��!";
				result = false;
			}
		}
		return REGISTER_RESULT;
	}

	public String checkEmail() {
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "����Ϊ��!";
		}
		checkIsEmailBeRegisted_();
		return REGISTER_RESULT;
	}
	
	public String checkNickname(){
		if (user_nickname == null || "".equals(user_nickname)) {
			result = false;
			message = "�ǳ�Ϊ��!";
		}else
		{
			result = true;
		}
		return REGISTER_RESULT;
	}
	
	public String checkPassword(){
		System.out.println("LoginAction.checkPassword()");
		if (user_password == null || "".equals(user_password)) {
			result = false;
			message = "����Ϊ��!";
		}else
		{
			result = true;
		}
		return REGISTER_RESULT;
	}
	
	public String checkPasswordconfirm()
	{
		System.out.println("LoginAction.checkPasswordconfirm()");
		if (user_password_confirm == null || "".equals(user_password_confirm)) {
			result = false;
			message = "ȷ������Ϊ��!";
			return REGISTER_RESULT;
		} 
		if (!user_password_confirm.equals(user_password)) {
			message = "������ȷ�����벻��ͬ!";
			result = false;
		}else
		{
			result = true;
		}
		return REGISTER_RESULT;
	}
	private boolean checkForm() {
		boolean isRegisted = checkIsEmailBeRegisted_();
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "����Ϊ��!";
		} else if (user_nickname == null || "".equals(user_nickname)) {
			result = false;
			message = "�ǳ�Ϊ��!";
		} else if (user_password == null || "".equals(user_password)) {
			result = false;
			message = "����Ϊ��!";
		} else if (user_password_confirm == null || "".equals(user_password_confirm)) {
			result = false;
			message = "ȷ������Ϊ��!";
		} else if (isRegisted) {
			result = false;
			message = "���û����ѱ�ע��!";
		} else if (!user_password.equals(user_password_confirm)) {
			message = "������ȷ�����벻��ͬ!";
			result = false;
		}
		return result;
	}

	private boolean checkIsEmailBeRegisted_() {
		boolean isRegisted = false;
		result = true;
		if (user_email == null || "".equals(user_email)) {
			result = false;
			message = "����Ϊ��!";
		} else {
			isRegisted = userDAO.isUserEmailRegisted(user_email);
			if (isRegisted) {
				message = "���û����ѱ�ע��!";
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
}
