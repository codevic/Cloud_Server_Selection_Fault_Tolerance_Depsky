/**
 * 
 */
package com.kumar.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kumar.DAO.UserDAO;


public class FileDownload 
{
	public static boolean download( String ftpServer, String ftpuser, String ftppassword,String username,String downloadDir,String fileName,String fileType,int uploadId,int cloudId) throws MalformedURLException,
	         IOException
	   {
		   boolean flag=false;
		   int userid=0;
		   String msgDigest = "";
		   String integrityStatus = "Passed";
	      if (ftpServer != null && fileName != null )
	      {
	         StringBuffer sb = new StringBuffer( "ftp://" );
	         // check for authentication else assume its anonymous access.
	         if (ftpuser != null && ftppassword != null)
	         {
	            sb.append( ftpuser );
	            sb.append( ':' );
	            sb.append( ftppassword );
	            sb.append( '@' );
	         }
	         sb.append( ftpServer );
	         sb.append( '/' );
	         sb.append( downloadDir );
	         sb.append( '/' );
	         sb.append( fileName );
	         
	         /*
	          * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
	          * listing
	          */
	         sb.append( ";type=i" );
	         BufferedInputStream bis = null;
	         BufferedOutputStream bos = null;
	         try
	         {
	            URL url = new URL( sb.toString() );
	            URLConnection urlc = url.openConnection();
	            /* Download Location */
	           // String dir="C:\\";
	            String dir = "C:/Documents and Settings/DHS-13/My Documents/Downloads/Multi-Cloud/";
	            File f = new File(dir);
	             
	            if(!f.exists())
	            {
	            	f.mkdir();
	            }
	            bis = new BufferedInputStream( urlc.getInputStream());
	            bos = new BufferedOutputStream( new FileOutputStream(f+"\\"+fileName) );
	           // outputStream = new BufferedOutputStream( new FileOutputStream(file+"\\"+fileName) );
	            System.out.println("Downloaded......");
	            
	            System.out.println("Url : " + url);

	           int i;
	            while ((i = bis.read()) != -1)
	            {
	               bos.write( i );
	               flag=true;
	            }
	           
	            if(flag)
	            {
		            try 
		            {
	                   /* Adding the download Transaction details (Start)*/
						
		            	
						Calendar currentDate = Calendar.getInstance();
						SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
						SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
						String date = formatter.format(currentDate.getTime());
						String time = formatter1.format(currentDate.getTime());
						
						UserDAO userDAO = UserDAO.getInstance();
						
						userid = userDAO.getID(username);
						
						flag = userDAO.addDownloadTransaction(fileName, fileType, date, time, userid, msgDigest, uploadId, cloudId, integrityStatus);
						
						//flag = true;
						
						System.out.println("*************** Download Flag : " + flag);
						
						/* Adding the Download Transaction details (End)*/
					}
		            catch (Exception e)
		            {
						
		            	System.out.println("**************** Exception *************************");
		            	
		            	e.printStackTrace();
					}
	            }
	            
	         }
	         finally
	         {
	            if (bis != null)
	               try
	               {
	                  bis.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	            if (bos != null)
	               try
	               {
	                  bos.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	         }
	      }
	      else
	      {
	         System.out.println( "Input not available" );
	      }
	      return flag;
	   }
}
