/**
 * 
 */
package com.kumar.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kumar.DAO.DAO;

public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(adminDAO == null)
		{
			adminDAO= new AdminDAO();
		}
		return adminDAO;
	}
	public boolean checkAdmin(String admin,String pass)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where adminid='"+admin+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	
/* Get Profile Details (Starts) */
	
	public static ResultSet getProfile(String username)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_admin where adminid='"+username+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Profile Details (Ends) */
	
	
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_admin set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
			System.out.println("******* Edit Profile Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	public boolean chnagePass(int id,String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_admin set password='"+cpass+"' where id='"+id+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
/* Get Server Details (Starts) */
	
	public static ResultSet getServerDetails()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_cloud";
			System.out.println("******* Server Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getServerDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Server Details (Ends) */
	
/* Get Specific Server Details (Starts) */
	
	public static ResultSet getServerSpecificDetails(int serverId)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_cloud where c_id='"+serverId+"'";
			System.out.println("******* Get Specific Server Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getServerSpecificDetails(int serverId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Specific Server Details (Ends) */
	
/* Add Server Details (Starts) */
	
	public boolean addServerDetails(String hostName, String username, String password, String status,String remarks) 
	{
		boolean flag=false;
		String sql = "";
		String url="";
		try
		{
			url = "ftp://"+hostName;
			
			if(remarks.equals(""))
			{
				remarks = "";
			}
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "insert into m_cloud (c_url,c_username,c_password,c_status,c_remarks) values('"+url+"','"+username+"','"+password+"','"+status+"','"+remarks+"')";
			System.out.println("******* Add Server Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Add Server Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addServerDetails() :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Server Details (Ends) */
	
/* Check Server Existence (Starts) */
	
	public boolean checkServerHostExistence(String hostName) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{
            url = "ftp://"+hostName;
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_cloud where c_url='"+url+"'";
			System.out.println("******* Check Server Existence *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Check Server Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-checkServerHostExistence : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check Server Existence (Ends) */
	
/* Edit Server Details (Starts) */
	
	public boolean editServerDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{   
			url = "ftp://"+s[1];
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_cloud set c_url='"+url+"',c_username='"+s[2]+"',c_password='"+s[3]+"',c_status='"+s[4]+"',c_remarks='"+s[5]+"' where c_id='"+s[0]+"'";
			System.out.println("******* Edit Server Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Server Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editServerDetails(String [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit Server Details (Starts) */
	

/* Delete Server Details (Starts) */
	
	public boolean deleteServerDetails(int serverId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_cloud where c_id='"+serverId+"'";
			System.out.println("******* Delete Server Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete Server Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in deleteServerDetails(int serverId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete Server Details (Ends) */
	
	public ResultSet getUsers()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUsers(): "+ e);
		}
		return resultSet;
	}
	
	
	
	public String getUser(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_name from m_user where m_id='"+id+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUser(int id): "+ e);
		}
		return name;
	}
	
/* Check User Existence (Starts) */
	
	public boolean checkUserExistence(String username) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_user where m_user='"+username+"'";
			System.out.println("******* Check User Existence *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Check User Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-checkUserExistence(String username) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check User Existence (Ends) */
	
/* Add User Details (Starts) */
	
	public boolean addUserDetails(String username, String password, String name, String city,	String mobile) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "insert into m_user (m_user,m_pass,m_name,m_city,m_mob) values('"+username+"','"+password+"','"+name+"','"+city+"','"+mobile+"')";
			System.out.println("******* Add User Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Registeration Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addUserDetails : ");
			e.printStackTrace();
		}
		return flag;
	}

/* Add User Details (Ends) */
	
/* Edit User Details (Starts) */

	public boolean editUserDetail(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set m_user='"+s[1]+"',m_pass='"+s[2]+"',m_name='"+s[3]+"',m_city='"+s[4]+"',m_mob='"+s[5]+"' where m_id='"+s[0]+"'";
			System.out.println("******* Edit User Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetail(String [] s): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit User Details (Ends) */
	
	public static ResultSet getSpecificUserDetails(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where m_id='"+id+"'");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getSpecificUserDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Delete User Details (Starts) */
	
	public boolean deleteUserDetails(int userId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_user where m_id='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Admin-deleteUserDetails(int userId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete User Details (Ends) */
	
/* Add Fault Tolerance Details (Starts)*/	
	
	public boolean addFaultTolerance(double probability, String formula,double value,int noOfClouds) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_fault_tolerance set f_probability='"+probability+"',f_formula='"+formula+"',f_value='"+value+"',f_no_of_clouds='"+noOfClouds+"' where f_id='1'";
			System.out.println("******* Add Fault Tolerance Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Add FaultTolerance Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addFaultTolerance() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	/* Add Fault Tolerance Details (Ends)*/	
	
	
	/* Get Admin Upload Transaction(Starts) */

	public ResultSet getAdminUploadTransaction()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_upload");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Admin Upload Transaction(Ends) */
	
	/* Get Admin Download Transaction(Starts) */

	public ResultSet getAdminDownloadTransaction()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_download");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Admin Download Transaction(Ends) */
}
