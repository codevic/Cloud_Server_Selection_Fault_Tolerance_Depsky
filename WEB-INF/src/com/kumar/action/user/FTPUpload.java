/**
 * 
 */
package com.kumar.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kumar.DAO.UserDAO;
import com.kumar.util.FileUpload;
import com.kumar.util.Utility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;



public class FTPUpload extends HttpServlet
{
	private static String username="";
	private static int userid=0;
	private static String selectedFileType="";
	private static String dirToUploadFile="";
	private static String CLOUD1="ftp://dhsinformatics.com/cloud1";
	private static String CLOUD2="ftp://dhsinformatics.com/cloud2";
	private static String CLOUD3="ftp://dhsinformatics.com/cloud3";
	private static String CLOUD4="ftp://dhsinformatics.com/cloud4";
	private static String cloud1Status="";
	private static String cloud2Status="";
	private static String cloud3Status="";
	private static String cloud4Status="";
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		   RequestDispatcher rd = null;
		   
		   UserDAO userDAO = UserDAO.getInstance();
		   
		   HttpSession session = req.getSession();  
		   
		   if(session != null)
			{
			  username = (String) session.getAttribute("username");
			}
		   
		   
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("<font color='white' size='5'>");
	    	   out.println( "File Uploading is in Process......  " );
	    	   out.println("</font><br>");
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
					
					String path=req.getParameter("path");
					System.out.println("Source ::> "+path);
					String filename=req.getParameter("fname");
					System.out.println("File Name ::> "+filename);
					
					String localFilePath = req.getRealPath("") +"\\Files\\Upload\\"+filename;
				    
					
					/* Uploading File On Cloud (Starts)*/
					
					String ftpserver = "dhsinformatics.com";
			        String ftpusername = "dhsinf17";
			        String ftppassword = "nikisujai";
			        
			        //Uploading Encrypted File To Cloud 
			        File file1=new File(localFilePath);
			        
			        int noOfClouds = userDAO.getCloud();
			        
					userid = userDAO.getID(username);
					cloud1Status = userDAO.getCloudStatus(CLOUD1);
					cloud2Status = userDAO.getCloudStatus(CLOUD2);
					cloud3Status = userDAO.getCloudStatus(CLOUD3);
					cloud4Status = userDAO.getCloudStatus(CLOUD4);
			        
			        StringBuffer sb = new StringBuffer("File Uploaded On : ");
			        
			      	if(cloud1Status.equals("Active"))
	        		{
	        			if(noOfClouds>0)
	        			{
	        				dirToUploadFile = "cloud1";
	        				sb.append(dirToUploadFile + ",");
	        				
	        				FileUpload.upload(ftpserver,ftpusername,ftppassword,filename,file1,dirToUploadFile);
	        				System.out.println("*****  File Uploaded Sucessfully on Cloud1. *****");
	        				noOfClouds--;
	        			}
	        		}
	        		if(cloud2Status.equals("Active"))
	        		{
	        			
	        			
	        			if(noOfClouds>0)
	        			{
	        				dirToUploadFile = "cloud2";
	        				sb.append(dirToUploadFile + ",");
	        				
	        				FileUpload.upload(ftpserver,ftpusername,ftppassword,filename,file1,dirToUploadFile);
	        				System.out.println("***** File Uploaded Sucessfully on Cloud2. *****");
	        				noOfClouds--;
	        			}
	        			
	        		}
	        		if(cloud3Status.equals("Active"))
	        		{
	        			
	        			if(noOfClouds>0)
	        			{
	        				dirToUploadFile = "cloud3";
	        				sb.append(dirToUploadFile + ",");
	        				
	        				FileUpload.upload(ftpserver,ftpusername,ftppassword,filename,file1,dirToUploadFile);
	        				System.out.println("***** File Uploaded Sucessfully on Cloud3. *****");
	        				noOfClouds--;
	        			}
	        		}
	        		if(cloud4Status.equals("Active"))
	        		{
	        			
	        			if(noOfClouds>0)
	        			{
	        				dirToUploadFile = "cloud4";
	        				sb.append(dirToUploadFile + ",");
	        				
	        				FileUpload.upload(ftpserver,ftpusername,ftppassword,filename,file1,dirToUploadFile);
	        				System.out.println("***** File Uploaded Sucessfully on Cloud4. *****");
	        				noOfClouds--;
	        			}
	        		}
			     
			         
					
					/* Uploading File On Cloud (Ends)*/
	        		String s= sb.toString();
	        		String a[] =s.split(":");
	        		String uploadedClouds = a[1];
	        		String clouds[] = uploadedClouds.split(",");
	        		
	        		System.out.println("7777777777777777777777777777777");
	        		System.out.println("Uploaded Clouds :");
	        		System.out.println(Arrays.toString(clouds));
	        		
	        		String url="ftp://dhsinformatics.com/";
	        		
	        		ArrayList list = new ArrayList();
	        		int cloud_id = 0;
	        		
	        		if(clouds.length!=0)
	        		{
	        			for(int i=0;i<clouds.length;i++)
	        			{
	        				cloud_id = userDAO.getCloudID(url+clouds[i].trim());
	        				list.add(cloud_id);
	        			}
	        		}
	        		
	        		System.out.println("Cloud Ids : " + list);
	        		System.out.println("7777777777777777777777777777777");
					
					/* Adding the upload Transaction details (Start)*/
					
					boolean flag = false;
					String transactionType="Support File Upload";
					int dotPos = filename.lastIndexOf(".");
				    String extension = filename.substring(dotPos);
				    String fileType=extension;
					
					Calendar currentDate = Calendar.getInstance();
					SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
					SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
					String date = formatter.format(currentDate.getTime());
					String time = formatter1.format(currentDate.getTime());
					
					String msgDigest = Utility.MD(file1);
					
					int numberOfClouds = userDAO.getCloud();
					
					//flag = dao.addTransaction(transactionType,filename,fileType, date, time,uid);
					
					flag = userDAO.addUploadTransaction(filename, fileType, date, time, userid, msgDigest,numberOfClouds);
					
					int maxUploadId = userDAO.getMaxUploadID();
					
					if(list.size()>0)
					{
						for(int i=0;i<list.size();i++)
						{
							flag = userDAO.addUploadConstraints(maxUploadId,Integer.parseInt(list.get(i).toString()));
						}
					}
					
					/* Adding the upload Transaction details (End)*/
					
					/* Displaying Success Message  */
					if(flag)
					{
						//rd=req.getRequestDispatcher("/Resources/JSP/User/uploadSupport_file.jsp?no=2&file_name="+filename+"");
						rd=req.getRequestDispatcher("/Resources/JSP/User/upload_file.jsp?no=1&file_name="+filename+"&cloud="+sb.toString()+"");
						rd.forward(req,res);
					}
					else
					{
						//rd=req.getRequestDispatcher("/Resources/JSP/User/uploadSupport_file.jsp?no=3");
						rd=req.getRequestDispatcher("/Resources/JSP/User/upload_file?no=0&no1=1");
						rd.forward(req,res);
					}
					
				}
				catch(Exception e)
				{
					System.out.println("\n ******** Exception In FTPUpload Servlet : \n");
					e.printStackTrace();
				}
		
	}}
}
