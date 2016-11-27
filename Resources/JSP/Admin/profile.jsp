<%@page import="com.kumar.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.kumar.DAO.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>

</head>
<body onload="startTimer()">
<img src="<%=request.getContextPath() %>/Resources/Images/header.jpg"></img>

<!-- Main Menu Development (Starts)-->

<div id="mainmenu">
  <ul class="glossymenu">
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/adminhome.jsp" title="Admin Home"><b>Home</b></a></li>
    <li class="current"><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/profile.jsp" title="Admin Profile"><b>Profile</b></a></li>
    <li><a href="<%=request.getContextPath()%>/ServerList?submit=get" title="Cloud Server Details" onclick=""><b>Servers</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/fault_tolerance.jsp" title="Cloud Fault Tolerance"><b>Fault Tolerance</b></a></li>
    <li><a href="<%=request.getContextPath()%>/UserList?submit=get" title="Users Details"><b>Members</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/transactions.jsp" title="View All Users Transactio Details"><b>Transactions</b></a></li>
    <li><a href="<%=request.getContextPath()%>/" title="Admin Logout"><b>Sign Out</b></a></li>
  </ul>
</div>


<!-- Main Menu Development (Ends) -->

<%
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0;
	String username="",name="",add="",email="",phone="";
	
	while(rs.next())
	{
		id=rs.getInt(1);
		username=rs.getString(4);
		name=rs.getString(2);
		add=rs.getString(5);
		email=rs.getString(7);
		phone=rs.getString(6);
	}

	if(no==1)
	{
%>
			<div class="error" id="message" style="position:absolute;top:225px;left:300px">		
				<p>Opp's,Seems something went wrong ..!</p>
			</div>
<%
	}
	else if(no==0)
	{
%>
			<br>
			<div align="right" style="position:absolute;top:238px;left:475px">
				<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?username=<%=username %>&no=1">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?username=<%=username %>&no=1&id=<%=id %>" target="myIframe">Change Password</a>
			</div>
			<br>
			<div id="a2" align="right" style="position:absolute;top:267px;left:125px">
			
				<p>
				
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">Admin Profile Details</font>
									</td>
									
							</tr>
							
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Name</td>
									<td >:</td>
									<td> <%=name %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your User ID</td>
									<td>:</td>
									<td> <%=username %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Mail ID </td>
									<td>:</td>
									<td> <%=email %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Cell N0  </td>
									<td>:</td>
									<td> <%=phone %></td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Address  </td>
									<td>:</td>
									<td>  <%=add %></td>
							</tr>
					</table>
				</p>
				
				
			</div>
		<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Your profile updated successfully ..!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Your Password updated successfully ..!</p>
				</div>
			<%
		}
	}
	else if(no==2)
	{
%>


<!-- Display Contents (Starts) -->

					<form id="login" action="<%=request.getContextPath() %>/EditProfile?no=2">
					<input type="hidden" name="admin" value="<%=username %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div align="right" style="position:absolute;top:200px;left:475px">
						<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?username=<%=username %>&no=1&id=<%=id %>" target="afrm">Change Password</a>
					</div>
					<br></br>
					<div id="a2" align="right" style="position:absolute;top:240px;left:125px">
						
						<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">Edit Admin Profile Details</font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Name</td>
									<td >:</td>
									<td> 
										<input class="field" type="text" name="name" value="<%=name %>"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your User ID</td>
									<td>:</td>
									<td> <%=username %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Mail ID </td>
									<td>:</td>
									<td>
										<input class="field" type="text" name="email" value="<%=email %>"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Cell No  </td>
									<td>:</td>
									<td> 
										<input class="field" type="text" name="phone" value="<%=phone %>"></input>
									</td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Address  </td>
									<td>:</td>
									<td>
										<input class="field" type="text" name="add" value="<%=add %>"></input>
									</td>
							</tr>
					</table>
				</p>
						
		</div>
</form>

<!-- Display Contents (Ends) -->
<%
}
	else if(no==3)
	{
%>
      <form id="login" action="<%=request.getContextPath() %>/ChangePass?no=2">
		<input type="hidden" name="admin" value="<%=username %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		<div align="right" style="position:absolute;top:220px;left:501px">
			<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?username=<%=username%>&no=1">Edit Profile</a>
			<input type="submit" value="Save Updates" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<br></br>
		
		<div id="a2" align="right" style="position:absolute;top:260px;left:125px">
				<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">Change Password</font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Current Password</td>
									<td >:</td>
									<td> 
										<input class="field" type="password" name="pass"/>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>New Password</td>
									<td>:</td>
									<td>
										<input class="field" type="password" name="npass"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Confirm new password   </td>
									<td>:</td>
									<td> 
										<input class="field" type="password" name="cpass"></input>
									</td>
							</tr>
							
					</table>
				</p>
		</div>
	</form>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opp's,your current password is wrong ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opp's,your new password do not match with confirm password ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opp's,Seems something went wrong....!</p>
			</div>
		<%
	}
}
%>
</body>
</html>


