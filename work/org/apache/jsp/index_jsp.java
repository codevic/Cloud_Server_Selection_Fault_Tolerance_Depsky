package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 

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
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>User Login Page</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\">\r\n");
      out.write("// Our own function for message hiding (in Admin Login We used startTimer() from js by including style.js)\r\n");
      out.write("function hideMessage()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"message\").style.display=\"none\"; \r\n");
      out.write("}\r\n");
      out.write("function startTimer() \r\n");
      out.write("{\r\n");
      out.write("\tvar tim = window.setTimeout(\"hideMessage()\", 2000);  // 5000 milliseconds = 5 seconds\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("#login\r\n");
      out.write("{\r\n");
      out.write("\tmargin:5em auto;\r\n");
      out.write("\tbackground:#A9D0F5;\r\n");
      out.write("\tborder:40px solid #EEEEEE;\r\n");
      out.write("\twidth:400px;\r\n");
      out.write("\theight:310px;\r\n");
      out.write("\t\r\n");
      out.write("\t-moz-border-radius:100px;\r\n");
      out.write("\t-webkit-border-radius:100px;\r\n");
      out.write("\tborder-radius:100px;\r\n");
      out.write("\t\r\n");
      out.write("\t-moz-box-shadow:0 0 300px #777777;\r\n");
      out.write("\t-webkit-box-shadow:0 0 300px #777777;\r\n");
      out.write("\tbox-shadow:0 0 300px #777777;\r\n");
      out.write("\t\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\tleft:500px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login a, #login a:visited{color:#0283b2;}\r\n");
      out.write("#login a:hover{color:#111;}\r\n");
      out.write("\r\n");
      out.write("#login h1\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\tcolor:#5BACC4;\r\n");
      out.write("\ttext-shadow:#007dab 0 2px 0;\r\n");
      out.write("\tfont-size:14px;\r\n");
      out.write("\tpadding:18px 23px;\r\n");
      out.write("\tmargin:0 0 1.5em 0;\r\n");
      out.write("\tborder-bottom:1px solid #007dab;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login .field\r\n");
      out.write("{\r\n");
      out.write("\tborder:10px solid #A2A7A2;\r\n");
      out.write("\tcolor:white;\r\n");
      out.write("\twidth:300px;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tline-height:1.5em;\r\n");
      out.write("\tpadding:4px;\r\n");
      out.write("\t-moz-box-shadow:inset 0 0 5px #ccc;\r\n");
      out.write("\t-webkit-box-shadow:inset 0 0 5px #ccc;\r\n");
      out.write("\tbox-shadow:inset 0 0 50px #000000;\r\n");
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write("#login div.submit label{float:none;display:inline;font-size:11px;}\r\n");
      out.write("\t\r\n");
      out.write("#login button\r\n");
      out.write("{\r\n");
      out.write("\tborder:0;\r\n");
      out.write("\tpadding:0 30px;\r\n");
      out.write("\theight:30px;\r\n");
      out.write("\tline-height:30px;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tcolor:#fff;\r\n");
      out.write("\ttext-shadow:#007dab 0 1px 0;\r\n");
      out.write("\tbackground:#424242;\r\n");
      out.write("\t-moz-border-radius:50px;\r\n");
      out.write("\t-webkit-border-radius:50px;\r\n");
      out.write("\tborder-radius:50px;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#kumar\r\n");
      out.write("{\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\ttop: 150px;\r\n");
      out.write("\tleft:520px;\r\n");
      out.write("\tbackground:#FFFFCC;\r\n");
      out.write("\tcolor:#222222;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\twidth:500px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.username.value.length==0 && document.f1.password.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=1';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.username.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=2';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.password.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\twindow.location.href = 'index.jsp?no=3';\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    

      out.write("       \r\n");
      out.write("    \t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Enter Username and Password !</p>\r\n");
      out.write("    \t\t</div>\t\r\n");
      out.write("    \t \r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Username.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Please,Enter Your Password.!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==4)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("    \t\t\t<p> Sorry,Invalid Username/Password!</p>\r\n");
      out.write("    \t</div>\t\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==5)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:130px;left:530px\">\t\r\n");
      out.write("\t\t\t<p>Loged out successfully...!</p>\r\n");
      out.write("\t\t</div>\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload = \"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/header.jpg\"></img>\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"f1\" id=\"login\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\"> \r\n");
      out.write("\t    \r\n");
      out.write("\t    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/user_mail.jpg\" width=\"75\" height=\"50\" align=\"center\"></img>\r\n");
      out.write("\t    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/user_female.jpg\" width=\"75\" height=\"50\" align=\"center\"/>\r\n");
      out.write("\t    <h1> \r\n");
      out.write("\t    \t<font color=\"white\" size=\"4\"><strong>User Login</strong></font>\r\n");
      out.write("\t   </h1>\r\n");
      out.write("\t    \r\n");
      out.write("    \t<div>\r\n");
      out.write("    \t\tUsername\r\n");
      out.write("    \t\t<input type=\"text\" name=\"username\" id=\"login_username\" class=\"field required\"  />\r\n");
      out.write("    \t</div>\t\t\t\r\n");
      out.write("\t    <div>\r\n");
      out.write("    \t\tPassword\r\n");
      out.write("    \t\t<input type=\"password\" name=\"password\" id=\"login_password\" class=\"field required\"  />\r\n");
      out.write("    \t</div>\t\r\n");
      out.write("    \t\r\n");
      out.write("  \t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/index1.jsp\">Are you a Admin?</a>\r\n");
      out.write("    \t<div class=\"submit\">\r\n");
      out.write("        \t<button type=\"submit\" onclick=\"return check();\">Log in</button><br>   \r\n");
      out.write("\t\t    ");
      out.write("\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<br>\r\n");
      out.write("    \t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/login_lock2.jpg\" width=\"75\" height=\"50\" align=\"center\"></img>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:absolute;top:150px;left:100px;font-size:50px;color:red;\">\r\n");
      out.write("\tMulti Cloud\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"position:absolute;top:200px;left:50px\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/clouds.jpg\" height=\"450\" width=\"350\"></img>\r\n");
      out.write("</div>\r\n");
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
