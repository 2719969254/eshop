package com.shop.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc������
 * @author Administrator
 *
 * 1�� ��ȡ������
 * 
 * 2���ر���Դ
 */
public class JDBCTools {
	/**  ���ݿ���������*/
	private   static String drivername = null; 
	/**
	 * �������ӵ�ַ
	 */
	private  static String url = null;
	/**
	 * ���ݿ���û�����
	 */
	private  static String  username  = null;
	/**
	 * ���ݿ������
	 */
	private  static String password = null;
	
	
	 static{
		//����properties����
		Properties  prop = new Properties();
		
		//�������ļ� ��������ʽ ��ȡ����
		InputStream  is = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(is);
			drivername = prop.getProperty("jdbcdrivername");
			url = prop.getProperty("jdbcaddressname");
			username = prop.getProperty("dbusername");
			password = prop.getProperty("dbpassword");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			Class.forName(drivername).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	 }
	
	/**
	 * ��ȡ����
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ر���Դ
	 * @param rs    ResultSet 
	 * @param stmt  Statement
	 * @param conn  Connection
	 */
	public static void close(ResultSet rs, Statement  stmt, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn =null;
		}
	}
}
