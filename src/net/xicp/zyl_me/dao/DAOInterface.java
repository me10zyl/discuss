package net.xicp.zyl_me.dao;

/**
 * ���ڴ��븴�ã�����������DB��������е���ͬ����
 * ������DB�������ĸ���
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

/**
 * @author ZyL
 *
 */
public interface DAOInterface<T>
{
	public abstract ArrayList<T> getAll() throws ClassNotFoundException,SQLException;
	
	public abstract T getById(int id) throws ClassNotFoundException,SQLException;
	
	public abstract boolean add(T user) throws ClassNotFoundException,SQLException;
	
	public abstract boolean modify(T newUser) throws ClassNotFoundException,SQLException;
	
	public abstract boolean delete(int id) throws ClassNotFoundException,SQLException;
	
	
}
