/**
 * 
 */
package com.kumar.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.kumar.DAO.CommonDAO;
import com.kumar.util.Utility;


public class UploadToCloud extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String fileName="",root="",md="";
			String [] name=new String[2];int i=0;
			File uploadedFile = null;
			ResultSet rs=null;
			boolean flag=false;
			RequestDispatcher rd=null;
			Random random=new Random();
			int num,num1=0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            try
	            {
	            	List items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) 
	                {
	                	FileItem item = (FileItem) iterator.next();
	                    if (item.isFormField()) 
	                    {
	                    	name[i] = item.getString();
	                    	i++;
	                    }
	                    else
	                    {
	                    	fileName = item.getName();
	                    	root = getServletContext().getRealPath("/");
	                    	num1 = random.nextInt(12345) + 1;
	                    	uploadedFile = new File(root+"/"+num1+fileName);
	                    	item.write(uploadedFile);
	                    }
	                }
	                
	                md = Utility.MD(uploadedFile);
	                
	                byte ds[]=Utility.DS(md.getBytes(),CommonDAO.getPvtKey(name[0]));
	                
	                System.out.println("99999999 Name : " + name[0]);
	                
	                int id=CommonDAO.getUserID(name[0]);
	                num =( random.nextInt(( 2 - 1 ) + 1 ) ) + 1;
					flag=Utility.uploadFile(Utility.getPro("IP("+num+")"), Utility.getPro("S_Name("+num+")"), Utility.getPro("S_Pass("+num+")"), num1+fileName, root);
					if(flag)
					{
						CommonDAO.makeTrans(id, num1+fileName, "Upload", num, md,ds);
						flag=Utility.writeOnFile(name[0]+".txt", "User has uploaded file ("+fileName+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
						rs=CommonDAO.getFiles((id),"Upload");
						if(rs.next())
						{
							rs=CommonDAO.getFiles((id),"Upload");
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/Files/JSP/User/files.jsp?no=2&name="+name[0]);
							rd.forward(request, response);
						}
					}
					boolean b=uploadedFile.delete();
	            }
	            catch(Exception e1)
	            {
	            	System.out.println("Opps's Error is in User UploadToCloud isMultipart Servlet......"+e1);
	    			out.println("Opps's Error is in User UploadToCloud Servlet isMultipart......"+e1);
	            }
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UploadToCloud Servlet......"+e);
			out.println("Opps's Error is in User UploadToCloud Servlet......"+e);
		}
	}
}
