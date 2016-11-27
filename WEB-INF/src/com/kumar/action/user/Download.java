/**
 * 
 */
package com.kumar.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kumar.DAO.UserDAO;
import com.kumar.util.FileDownload;
import com.kumar.util.Utility;


public class Download extends HttpServlet
{
	
	private static String CLOUD1="ftp://dhsinformatics.com/cloud1";
	private static String CLOUD2="ftp://dhsinformatics.com/cloud2";
	private static String CLOUD3="ftp://dhsinformatics.com/cloud3";
	private static String CLOUD4="ftp://dhsinformatics.com/cloud4";
	private static String cloud1Status="";
	private static String cloud2Status="";
	private static String cloud3Status="";
	private static String cloud4Status="";
	private static String inActiveStatus="";
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		ResultSet rs = null; 
		String username = "";
		  int userid = 0;
		  int cloudId = 0;
		  int uploadId=0;
		  String fileName="";
		  String fileType="";
		  String uId="";
		  String msgDigest = "";
		  
		  ArrayList list = null;
		  
		  String integrityStatus="";
		  
		  String downloadDir = "";
		  
		  UserDAO userDAO = UserDAO.getInstance();
		  
		  RequestDispatcher rd=null;
		  
		  StringBuffer sb = null;
		  
		  HttpSession session = req.getSession();  
		  username = (String) session.getAttribute("username");
		  fileName = (String) req.getParameter("fname");
		  fileType = (String) req.getParameter("ftype");
		  uId = req.getParameter("uid");
		  uploadId = Integer.parseInt(uId);
		 
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor='#CCCCFF'>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
	    	   out.print("<font color='red'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font>");
	    	   out.println( "You downloading process is in progress......  " );
	    	   out.println( "Please wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	   session.removeAttribute( "waitPage" );  
			try
			{
				PrintWriter out=res.getWriter();
				res.setContentType("text/html");
				
				boolean flag = false;
				
				String ftpserver = "dhsinformatics.com";
		        String ftpusername = "dhsinf17";
		        String ftppassword = "nikisujai";
		        
		        list = userDAO.getCloudIDByUploadId(uploadId);
		        sb = new StringBuffer();
		        
		        cloud1Status = userDAO.getCloudStatus(CLOUD1);
				cloud2Status = userDAO.getCloudStatus(CLOUD2);
				cloud3Status = userDAO.getCloudStatus(CLOUD3);
				cloud4Status = userDAO.getCloudStatus(CLOUD4);
				
				/* getting clouds status (Starts)*/
				
						if(cloud1Status.equals("Inactive"))
						{
							inActiveStatus = "cloud1";
							sb.append(inActiveStatus + ",");
						}
						if(cloud2Status.equals("Inactive"))
						{
							inActiveStatus = "cloud2";
							sb.append(inActiveStatus + ",");
						}
						if(cloud3Status.equals("Inactive"))
						{
							inActiveStatus = "cloud3";
							sb.append(inActiveStatus + ",");
						}
						if(cloud4Status.equals("Inactive"))
						{
							inActiveStatus = "cloud4";
							sb.append(inActiveStatus + ",");
						}
				
				/* getting clouds status (Ends)*/
				
				boolean chk = true;
				
				if(chk)
				{
					for(int i=0;i<list.size();i++)
					{
						int id = Integer.parseInt(list.get(i).toString());
					
				        if(cloud1Status.equals("Active") && (id == 1) && chk == true)
		        		{
				        	 downloadDir = "cloud1";
				        	 cloudId = 1;
				        	 flag = FileDownload.download(ftpserver, ftpusername, ftppassword, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud1. ^^^^^^^^.");
		        		}
				        else if(cloud2Status.equals("Active") && (id == 2) && chk == true)
		        		{
				        	 downloadDir = "cloud2";
				        	 cloudId = 2;
				        	 flag = FileDownload.download(ftpserver, ftpusername, ftppassword, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud2. ^^^^^^^^.");
		        		}
				        else if(cloud3Status.equals("Active") && (id == 3) && chk == true)
		        		{
				        	 downloadDir = "cloud3";
				        	 cloudId = 3;
				        	 flag = FileDownload.download(ftpserver, ftpusername, ftppassword, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud3. ^^^^^^^^.");
		        		}
				        else if(cloud4Status.equals("Active") && (id == 4) && chk == true)
		        		{
				        	 downloadDir = "cloud4";
				        	 cloudId = 4;
				        	 flag = FileDownload.download(ftpserver, ftpusername, ftppassword, username, downloadDir, fileName,fileType,uploadId,cloudId);
				        	 chk = false;
				        	 System.out.println(" ^^^^^^^^ File Downloaded From Cloud4. ^^^^^^^^.");
		        		}
				       
			        
					}
					
				}
				
				
				
		        
		        //downloadDir = "cloud1";
		        //cloudId = 1;
				//flag = FileDownload.download(ftpserver, ftpusername, ftppassword, username, downloadDir, fileName,fileType,uploadId,cloudId);
				
				 if(flag)
		            {
			            try 
			            {
		                   /* Adding the download Transaction details (Start)*/
							
							/*Calendar currentDate = Calendar.getInstance();
							SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
							SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
							String date = formatter.format(currentDate.getTime());
							String time = formatter1.format(currentDate.getTime());
							
							UserDAO userDAO = UserDAO.getInstance();
							
							userid = userDAO.getID(username);
							
							
							
							flag = userDAO.addDownloadTransaction(fileName,fileType,date,time,userid, msgDigest,uploadId,cloudId,integrityStatus);*/
							
			            	File file = new File("C:\\Documents and Settings\\DHS-13\\My Documents\\Downloads\\Multi-Cloud\\"+fileName);
			            	
			            	msgDigest = Utility.MD(file);
			            	
			            	System.out.println("*********** Message Digest Info ******");
			            	System.out.println("\n msg  : "  + msgDigest);
			            	
			            	userid = userDAO.getID(username);
			            	
			            	flag = userDAO.updateDownloadMessageDigest(fileName, msgDigest);
			            	
							if(flag)
							{
								rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=1&fname="+fileName+"&dfrom="+downloadDir+"&ic="+sb.toString()+"");
								rd.forward(req, res);
							}
							else
							{
								rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=3");
								rd.forward(req, res);
							}
						}
			            catch (Exception e)
			            {
							e.printStackTrace();
						}
		            }
				    else
					{
						rd=req.getRequestDispatcher("/Resources/JSP/User/download_file.jsp?no=3");
						rd.forward(req, res);
					}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	   }	
}
