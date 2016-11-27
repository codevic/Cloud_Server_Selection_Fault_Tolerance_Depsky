package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kumar.util.Utility;
import java.sql.ResultSet;
import com.kumar.DAO.AdminDAO;
import com.kumar.DAO.UserDAO;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public final class upload_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.file.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please Select a File\");\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/header.jpg\"></img>\r\n");
      out.write("\r\n");
      out.write("<!-- Main Menu Development (Starts)-->\r\n");
      out.write("\r\n");
      out.write("<div id=\"mainmenu\">\r\n");
      out.write("  <ul class=\"glossymenu\">\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/userhome.jsp\" title=\"User Home\"><b>Home</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/UserProfile\" title=\"View User Profile\"><b>Profile</b></a></li>\r\n");
      out.write("    <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/upload_file.jsp\" title=\"Upload Files To Cloud\"><b>Upload File</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/DownloadFiles\" title=\"Download Files From Cloud\"><b>Dounload Files</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/transactions.jsp\" title=\"View User Transactio Details\"><b>Transactions</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/?no=5\" title=\"User Logout\"><b>Sign Out</b></a></li>\r\n");
      out.write("    \r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==0)
	{

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"a2\" style=\"position:absolute;top:250px;left:250\" class=\"c\">\r\n");
      out.write("\t<form name=\"f1\" action=\"");
      out.print(request.getContextPath());
      out.write("/UploadFile\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Upload Your File To Cloud</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<tr id=\"label\" align=\"center\">\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" class=\"field2\" name=\"file\" required=\"required\" width=\"150px\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

				UserDAO userDAO = UserDAO.getInstance();
		        int noOfClouds = userDAO.getCloud();
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td>Number Of Clouds Required</td>\r\n");
      out.write("\t\t    <td>:</td>\r\n");
      out.write("\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"field\" value=\"");
      out.print( noOfClouds);
      out.write("\" readonly=\"readonly\"></input>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"button\" value=\"Upload File\" onclick=\"return check();\"></input>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");

		if(Utility.parse(request.getParameter("no1"))==1)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:200px;left:200px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Opps,Some Thing Went Wrong !</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}
	
      out.write('\r');
      out.write('\n');
 	
	}
	if(Utility.parse(request.getParameter("no"))==1)
	{
		String fileName = request.getParameter("file_name");
		String cloud = request.getParameter("cloud");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
		String date = formatter.format(currentDate.getTime());
		String time = formatter1.format(currentDate.getTime());
		String username = ""; 
		HttpSession sesion = request.getSession();
		
	   	if(sesion != null)
		{
		  username = (String) session.getAttribute("username");
		}
		   

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"a2\" style=\"position:absolute;top:240px;left:250\" class=\"c\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"green\" style=\"font-style: bold\" size=\"5\">File Upload Acknowledgement</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><font color=\"white\" size=\"4px\">Mr. ");
      out.print( username );
      out.write("</font> </td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><pre><font color=\"red\">Your File has been Uploaded Successfully......</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><pre><font color=\"white\" size=\"5\">");
      out.print(cloud);
      out.write("</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   <td>File Name  :  ");
      out.print(fileName );
      out.write(" </td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   <td>Date  :  ");
      out.print( date );
      out.write("       &       Time  :  ");
      out.print( time );
      out.write(" </td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");

} 

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
