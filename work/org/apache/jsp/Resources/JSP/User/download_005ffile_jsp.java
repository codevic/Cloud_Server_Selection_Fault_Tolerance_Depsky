package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kumar.util.Utility;
import java.sql.ResultSet;
import com.kumar.DAO.AdminDAO;
import com.kumar.DAO.UserDAO;

public final class download_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
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
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/upload_file.jsp\" title=\"Upload Files To Cloud\"><b>Upload File</b></a></li>\r\n");
      out.write("    <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/DownloadFiles\" title=\"Download Files From Cloud\"><b>Download Files</b></a></li>\r\n");
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
      out.write("\r\n");
      out.write("<!-- Main Menu Development (Ends) -->\r\n");
      out.write("\r\n");

    int no=Utility.parse(request.getParameter("no"));
    
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,noOfClouds=0,userid;
	String fileName="",fileTypes="",username="";
	UserDAO userDAO = UserDAO.getInstance();
	if(no==0)
	{

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<div id=\"a3\" align=\"right\" style=\"position:absolute;top:230px;left:50px;width: 800px;height: 300px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("<p>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" border=\"1\" cellpadding=\"5px\" cellspacing=\"4px\" width=\"800px\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Available Files To Download</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>ID</th>\r\n");
      out.write("\t\t\t<th>File Name</th>\r\n");
      out.write("\t\t\t<th>File Type</th>\r\n");
      out.write("\t\t\t<th>No of Clouds</th>\r\n");
      out.write("\t\t\t<th>Member</th>\r\n");
      out.write("\t\t\t<th>Download</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			fileName=rs.getString(2);
			fileTypes=rs.getString(3);
			noOfClouds=rs.getInt(8);
			userid=rs.getInt(6);
			
			username = userDAO.getUsername(userid);
			 

      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(id);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(fileName);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(fileTypes);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(noOfClouds);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(username);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"");
      out.print(request.getContextPath() );
      out.write("/Download?uid=");
      out.print(id);
      out.write("&ftype=");
      out.print(fileTypes);
      out.write("&fname=");
      out.print(fileName);
      out.write("\">Download</a></td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");

		}
    
}

      out.write("\r\n");
      out.write("  \t </table>\r\n");
      out.write("  \t </p>\r\n");
      out.write("   </div>\r\n");
      out.write(" </form>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"position:absolute;top:600px;left:675px\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results',6); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("\r\n");
 	
	
}
	if(Utility.parse(request.getParameter("no"))==1)
	{
		
     String file_name = request.getParameter("fname");	
     String downloadedFrom = request.getParameter("dfrom");
     String inactiveClouds = request.getParameter("ic");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"a2\" style=\"position:absolute;top:240px;left:250\" class=\"c\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"green\" style=\"font-style: bold\" size=\"5\">File Download Acknowledgement</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"green\">Your File has been Downloaded Successfully......</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t     <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><pre><font color=\"red\">Inactive Clouds</font></pre></td>\r\n");
      out.write("\t\t    <td>:</td>\r\n");
      out.write("\t\t    <td>");
      out.print( inactiveClouds );
      out.write("</td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><pre><font color=\"white\">File Name</font></pre></td>\r\n");
      out.write("\t\t    <td>:</td>\r\n");
      out.write("\t\t    <td>");
      out.print( file_name );
      out.write("</td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td><pre><font color=\"white\">File Downloaded From </font></pre></td>\r\n");
      out.write("\t\t    <td>:</td>\r\n");
      out.write("\t\t    <td>");
      out.print( downloadedFrom );
      out.write("</td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   <td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t   \t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/VerifyFile\">\r\n");
      out.write("\t\t   \t\t\t     <input type=\"submit\" class=\"button\" value=\"Veryfy\"> \r\n");
      out.write("\t\t   \t\t\t     <input type=\"hidden\" name=\"file_name\" value=\"");
      out.print(file_name );
      out.write("\">\r\n");
      out.write("\t\t   \t\t\t</form>\r\n");
      out.write("\t\t   </td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t   \r\n");
      out.write("\t    \r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");

} 

if(Utility.parse(request.getParameter("no"))==2)
{
	
   if(Utility.parse(request.getParameter("no1"))== 1)
   {
	
		

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"a2\" style=\"position:absolute;top:240px;left:250\" class=\"c\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"green\" style=\"font-style: bold\" size=\"5\">File Verification Acknowledgement</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"green\">Your File verified Successfully......</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"white\" size=\"4\">Your File is not corrupted.</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t   \r\n");
      out.write("\t    \r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");

   }
   else
   {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"a2\" style=\"position:absolute;top:240px;left:250\" class=\"c\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"green\" style=\"font-style: bold\" size=\"5\">File Verification Acknowledgement</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"green\">Your File verified </font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"red\">Sorry,Your File is corrupted.</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t   \r\n");
      out.write("\t    \r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");

	} 
}
   if(Utility.parse(request.getParameter("no"))==3)
	{
    

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"a2\" style=\"position:absolute;top:240px;left:250\" class=\"c\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"green\" style=\"font-style: bold\" size=\"5\">File Download Acknowledgement</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"red\">Sorry Download Process Failed.</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"red\">Server is not active or</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <tr  bgcolor=\"#A9D2FB\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    <td colspan=\"3\" align=\"center\"><pre><font color=\"red\">Something Went Wrong...</font></pre></td>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t  \r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");

} 

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
