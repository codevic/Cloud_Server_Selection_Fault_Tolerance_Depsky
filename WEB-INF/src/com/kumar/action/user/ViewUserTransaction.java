
package com.kumar.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kumar.DAO.AdminDAO;
import com.kumar.DAO.UserDAO;

public class ViewUserTransaction extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String transactionType = "";
		
		RequestDispatcher rd=null;
		ResultSet rs = null;
		
		UserDAO userDAO = UserDAO.getInstance();
		
		transactionType = req.getParameter("tType");
		System.out.println("Transaction Type : " + transactionType);
		
		String username = "";
		int userid = 0;
		HttpSession session = null;
	
		session = req.getSession();

	    if(session != null)
	    {
	    	username = session.getAttribute("username").toString();
	    }
		
	    userid = userDAO.getID(username);
		
		try 
		{
			
			if(transactionType.equals("Upload"))
			{
				rs = userDAO.getFilesToDownload(userid);
				req.setAttribute("rs",rs);
				rd=req.getRequestDispatcher("/Resources/JSP/User/upload_transactions.jsp");
				rd.forward(req, resp);
			}
			if(transactionType.equals("Download"))
			{
				rs = userDAO.getUserDownloadTransaction(userid);
				req.setAttribute("rs",rs);
				rd=req.getRequestDispatcher("/Resources/JSP/User/download_transactions.jsp");
				rd.forward(req, resp);
			}
		} 
		catch (Exception e)
		{
		     System.out.println("Opps, Exception in ViewAdminTransaction Servlet :");
		     e.printStackTrace();
		}
		
		
	}
}
