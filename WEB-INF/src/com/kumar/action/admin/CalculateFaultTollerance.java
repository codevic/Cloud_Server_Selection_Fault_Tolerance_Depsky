/**
 * 
 */
package com.kumar.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kumar.DAO.AdminDAO;
import com.kumar.util.Utility;


public class CalculateFaultTollerance extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			AdminDAO adminDAO = AdminDAO.getInstance();
			rs = adminDAO.getUsers();
			
			if(submit.equals("Reset"))
			{
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/fault_tolerance.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Submit"))
			{
				
				    boolean flag = false;
					String prob = request.getParameter("probability");
					String formula = request.getParameter("formula");
					String val = request.getParameter("value");
					String cno = request.getParameter("cloud_no");
					
					double probability = Double.parseDouble(prob);
					double value = Double.parseDouble(val);
					int noOfClouds = Integer.parseInt(cno);
					
					flag = adminDAO.addFaultTolerance(probability, formula, value, noOfClouds);
					if(flag)
					{
						rd=request.getRequestDispatcher("/Resources/JSP/Admin/fault_tolerance.jsp?no=1");
						rd.forward(request, response);
					}
					else
					{
						rd=request.getRequestDispatcher("/Resources/JSP/Admin/fault_tolerance.jsp?no=2");
						rd.forward(request, response);
					}
				
		 }
		
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin CalculateFaultTollerance Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin CalculateFaultTollerance Servlet......"+e);
		}
	}
}
