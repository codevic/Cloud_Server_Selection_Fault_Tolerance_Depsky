<%@page import="com.kumar.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.kumar.DAO.AdminDAO"%>
<%@page import="com.kumar.DAO.UserDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>

</head>

<script language="javascript">
	function check()
	{
		if(document.f1.file.value.length==0)
		{
			alert("Please Select a File");
			return false
		}
		else
		{
			return true;
		}
	}
</script>

<body onload="startTimer()">
<img src="<%=request.getContextPath() %>/Resources/Images/header.jpg"></img>

<!-- Main Menu Development (Starts)-->

<div id="mainmenu">
  <ul class="glossymenu">
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/userhome.jsp" title="User Home"><b>Home</b></a></li>
    <li><a href="<%=request.getContextPath()%>/UserProfile" title="View User Profile"><b>Profile</b></a></li>
    <li class="current"><a href="<%=request.getContextPath()%>/Resources/JSP/User/upload_file.jsp" title="Upload Files To Cloud"><b>Upload File</b></a></li>
    <li><a href="<%=request.getContextPath()%>/DownloadFiles" title="Download Files From Cloud"><b>Dounload Files</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/transactions.jsp" title="View User Transactio Details"><b>Transactions</b></a></li>
    <li><a href="<%=request.getContextPath()%>/?no=5" title="User Logout"><b>Sign Out</b></a></li>
    
  </ul>
</div>

<%
	if(Utility.parse(request.getParameter("no"))==0)
	{
%>

<div id="a2" style="position:absolute;top:250px;left:250" class="c">
	<form name="f1" action="<%=request.getContextPath()%>/UploadFile" method="post" enctype="multipart/form-data">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#000000" style="font-style: bold" size="5">Upload Your File To Cloud</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
	    
		<tr id="label" align="center">
		    
			<td align="center" colspan="3">
				
					<input type="file" class="field2" name="file" required="required" width="150px"></input>
				
			</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<%
				UserDAO userDAO = UserDAO.getInstance();
		        int noOfClouds = userDAO.getCloud();
		%>
		
		<tr align="center">
		
		    <td>Number Of Clouds Required</td>
		    <td>:</td>
			<td align="center" colspan="3">
					<input type="text" class="field" value="<%= noOfClouds%>" readonly="readonly"></input>
			</td>
	    </tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr align="center">
			<td align="center" colspan="3">
					<input type="submit" class="button" value="Upload File" onclick="return check();"></input>
			</td>
	    </tr>
	
	</table>
	</form>
	</div>
	
	<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Opps,Some Thing Went Wrong !</p>
				</div>
			<%
		}
	%>
<% 	
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
		   
%>

	<div id="a2" style="position:absolute;top:240px;left:250" class="c">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="green" style="font-style: bold" size="5">File Upload Acknowledgement</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		
		<tr  bgcolor="#A9D2FB" align="center">
		
		    <td><font color="white" size="4px">Mr. <%= username %></font> </td>
		    
	    </tr>
		
		
		
		<tr  bgcolor="#A9D2FB" align="center">
		
		    <td><pre><font color="red">Your File has been Uploaded Successfully......</font></pre></td>
		    
	    </tr>
	    
	    <tr  bgcolor="#A9D2FB" align="center">
		
		    <td><pre><font color="white" size="5"><%=cloud%></font></pre></td>
		    
	    </tr>
		
		<tr  bgcolor="#A9D2FB" align="center">
		
		   <td>File Name  :  <%=fileName %> </td>
		    
	    </tr>
	    
	    <tr  bgcolor="#A9D2FB" align="center">
		
		   <td>Date  :  <%= date %>       &       Time  :  <%= time %> </td>
		    
	    </tr>
	    
	</table>
	</div>

<%
} 
%>
</body>
</html>