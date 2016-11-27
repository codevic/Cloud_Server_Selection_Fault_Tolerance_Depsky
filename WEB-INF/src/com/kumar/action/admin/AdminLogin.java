/**
 * 
 */
package com.kumar.action.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kumar.DAO.AdminDAO;




public class AdminLogin extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String admin=request.getParameter("username");
			String pass=request.getParameter("password");
			System.out.println(admin+"---"+pass);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("username",admin);
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.checkAdmin(admin, pass);
			if(result)
			{
				RequestDispatcher rd=null;
				HttpSession hs=request.getSession();
				hs.setAttribute("admin", admin);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/adminhome.jsp");
				rd.forward(request,response);
			}
			else
			{
				response.sendRedirect("index1.jsp?no=4");
			}
		}
		catch(Exception e)
		{
			System.out.println("********* Exception In AdminLogin Servlet ********\n");
			e.printStackTrace();
		}
	}
}
