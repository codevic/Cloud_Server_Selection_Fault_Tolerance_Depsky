/**
 * 
 */
package com.kumar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kumar.util.Utility;



public class CommonDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static ResultSet getFiles(int id,String type) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_trans where user_id='"+id+"' and trans_type='"+type+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	public static int getUserID(String username) 
	{
		int id=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select m_id from m_user where m_user='"+username+"'");
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
			System.out.println("User ID to return : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."+e);
		}
		return id;
	}
	public static int getTransID() 
	{
		int id=1000;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select id from m_trans");
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
			System.out.println("Trans ID to return : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getTransID()....."+e);
		}
		return id;
	}
	public static boolean makeTrans(int id,String fileName,String type,int cid,String md,byte ds[])
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			PreparedStatement ps = connection.prepareStatement("insert into m_trans values (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, getTransID()+1);
			ps.setInt(2,id);
			ps.setString(3, fileName);
			ps.setString(4, type);
			ps.setString(5, md.toString());
			ps.setString(6, Utility.getDate());
			ps.setString(7, Utility.getTime());
			ps.setString(8, Utility.getDay());
			ps.setInt(9, cid);
			ps.setBytes(10, ds);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Upload File Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-makeTrans()....."+e);
		}
		return flag;
	}
	public static boolean UpdateTrans(String id,String type)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from m_trans where id='"+id+"' and trans_type='"+type+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("UpdateTrans  Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."+e);
		}
		return flag;
	}
	public static int getCloudNo(String id) 
	{
		int num=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select cloud from m_trans where id='"+id+"'");
			while(resultSet.next())
			{
				num=resultSet.getInt(1);
			}
			System.out.println("Cloud Number to return : "+num);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getCloudNo()....."+e);
		}
		return num;
	}
	public static String getFileName(String id) 
	{
		String fname="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select file_name from m_trans where id='"+id+"'");
			while(resultSet.next())
			{
				fname=resultSet.getString(1);
			}
			System.out.println("File Name to return : "+fname);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."+e);
		}
		return fname;
	}
	public static String getMD(String id) 
	{
		String md="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select file_md from m_trans where id='"+id+"'");
			while(resultSet.next())
			{
				md=resultSet.getString(1);
			}
			System.out.println("File MD to return : "+md);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getMD()....."+e);
		}
		return md;
	}
	public static int getUserId(String id) 
	{
		int id1=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select user_id from m_trans where id='"+id+"'");
			while(resultSet.next())
			{
				id1=resultSet.getInt(1);
			}
			System.out.println("User ID to return : "+id1);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserId()....."+e);
		}
		return id1;
	}
	public static String getUserName(int id) 
	{
		String uname="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select userid from m_user where m_id='"+id+"'");
			while(resultSet.next())
			{
				uname=resultSet.getString(1);
			}
			System.out.println("User Name to return : "+uname);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getUserName()....."+e);
		}
		return uname;
	}
	public static byte[] getPubKey(String username)throws Exception
	{
		byte pubKey[]=null;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			System.out.println("***** MD5 Message Digest Public Key Info ******");
			sql = "select pubkey from digkey where username ='"+username+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				pubKey=resultSet.getBytes(1);
			}
			System.out.println("User pubKey to return : "+pubKey);
		}
		catch(Exception e)
		{
			System.out.println("Unable to process file for getPvtKey : ");
			System.out.println("Opps Exception in CommonDAO-getPvtKey : ");
			e.printStackTrace();
		}
		return pubKey;
	}
	public static byte[] getPvtKey(String username)throws Exception
	{
		byte pvtKey[]=null;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			System.out.println("***** MD5 Message Digest Private Key Info ******");
			sql = "select pvtkey from digkey where username ='"+username+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				pvtKey=resultSet.getBytes(1);
			}
			System.out.println("User pvtKey to return : "+pvtKey);
		}
		catch(Exception e)
		{
			System.out.println("Unable to process file for getPvtKey : ");
			System.out.println("Opps Exception in CommonDAO-getPvtKey : ");
			e.printStackTrace();
		}
		return pvtKey;
	}
	public static byte[] getDS(int id)throws Exception
	{
		byte ds[]=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select file_ds from m_trans where user_id='"+id+"'");
			while(resultSet.next())
			{
				ds=resultSet.getBytes(1);
			}
			System.out.println("User getDS to return : "+ds);
		}
		catch(Exception e)
		{
			System.out.println("Unable to process file for getDS :"+e);
		}
		return ds;
	}
	public static String getMailID(String userid) 
	{
		String email="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select email from userlogin where userid='"+userid+"'");
			while(resultSet.next())
			{
				email=resultSet.getString(1);
			}
			System.out.println("email to return : "+email);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getMailID()....."+e);
		}
		return email;
	}
}
