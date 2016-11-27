package org.apache.jsp.Resources.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kumar.util.Utility;

public final class adminhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
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
      out.write("    <li class=\"current\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/Admin/adminhome.jsp\" title=\"Admin Home\" ><b>Home</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Profile\" title=\"Admin Profile\"><b>Profile</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/ServerList?submit=get\" title=\"Cloud Server Details\" onclick=\"\"><b>Servers</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/Admin/fault_tolerance.jsp\" title=\"Cloud Fault Tolerance\"><b>Fault Tolerance</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/UserList?submit=get\" title=\"Users Details\"><b>Members</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/Admin/transactions.jsp\" title=\"View All Users Transactio Details\"><b>Transactions</b></a></li>\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/?no=5\" title=\"Admin Logout\"><b>Sign Out</b></a></li>\r\n");
      out.write("    \r\n");
      out.write("  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Main Menu Development (Ends) -->\r\n");
      out.write("\r\n");
      out.write("<!-- Display Contents (Starts) -->\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:absolute;top:180px;left:50px;\">\r\n");
      out.write("\t<iframe align=\"middle\" src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/multi_cloud4.jpg\" frameborder=\"0\" scrolling=\"auto\" name=\"myIframe\" height=\"470\" width=\"950\"></iframe>\r\n");
      out.write("</div>\t\r\n");
      out.write("\r\n");
      out.write("<!-- Display Contents (Ends) -->\r\n");
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
