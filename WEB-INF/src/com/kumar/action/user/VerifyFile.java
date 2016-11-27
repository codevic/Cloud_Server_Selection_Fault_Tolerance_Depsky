
package com.kumar.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kumar.DAO.UserDAO;

public class VerifyFile extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		RequestDispatcher rd = null;
		UserDAO userDAO = UserDAO.getInstance();
		
		String fileName = "";
		String uploadMsgDigest = "";
		String downloadMsgDigest = "";
		String integrityStatus = "";
		
		fileName = req.getParameter("file_name");
		
		System.out.println("****************** Verify File Info *******************************");
		System.out.println("File Name : " + fileName);
		
		try 
		{
			uploadMsgDigest = userDAO.getUploadMsgDigest(fileName);
			downloadMsgDigest = userDAO.getDownloadMsgDigest(fileName);
			
		    if(uploadMsgDigest.equals(downloadMsgDigest))
		    {
		    	System.out.println("File is not corrupted....");
		    	
		    	rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=2&no1=1");
				rd.forward(req, resp);
		    	
		    }
		    else
		    {
		    	System.out.println("File is corrupted....");
		    	integrityStatus = "Failed";
		    	userDAO.updateDownloadIntegrityStatus(fileName,integrityStatus);
		    	
		    	rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=2");
				rd.forward(req, resp);
		    }
			
		}
		catch (Exception e) 
		{
			System.out.println("Exception in VerifyFile Servlet :");
			e.printStackTrace();
		}
		
	}
}
