<%@page import="com.kumar.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.kumar.DAO.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>

</head>
<body onload="startTimer()">
<img src="<%=request.getContextPath() %>/Resources/Images/header.jpg"></img>

<!-- Main Menu Development (Starts)-->

<div id="mainmenu">
  <ul class="glossymenu">
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/adminhome.jsp" title="Admin Home"><b>Home</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Profile" title="Admin Profile"><b>Profile</b></a></li>
    <li class="current"><a href="<%=request.getContextPath()%>/ServerList?submit=get" title="Cloud Server Details" onclick=""><b>Servers</b></a></li>
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
	String username="",url="",password="",status="",remarks="";
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/ServerList">
<div align="right" style="position:absolute;top:211px;left:550px">
	<input type="submit" name="submit" value="Add" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Edit" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Delete" class="gradientbuttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div id="a3" align="right" style="position:absolute;top:250px;left:75px;width: 775px;height: 300px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="700px">
		
		<tr>
			
			<td colspan="5" align="center">
			<font color="#000000" style="font-style: bold" size="5">Cloud Server Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Select</th>
			<th>Cloud Server Url</th>
			<th>Username</th>
			<th>Password</th>
			<th>Status</th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			url=rs.getString(2);
			username=rs.getString(3);
			password=rs.getString(4);
			status=rs.getString(5);
			remarks=rs.getString(6);
		    
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=id%>"></td>
						<td><%=url%></td>
						<td><%=username%></td>
						<td><%=password%></td>
						<td><%=status%></td>
			</tr>
<%
		}
    }

%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:600px;left:675px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',6); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

<%-- Adding The Server Details --%>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Server Details Added successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Server Details Updated successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opps,Select atleast one checkbox !</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==4)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opps,Select only one checkbox to edit!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==5)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Server Details Deleted successfully ..!</p>
			</div>
		<%
	}
}
	if(no == 2)
	{
%>
		
		<div id="a2" align="right" style="position:absolute;top:200px;left:150px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/ServerList">
				<input type="hidden" name="submit" value="Add"></input>
				<input type="hidden" name="add1" value="YES"></input>
					
					<tr>
							<td colspan="3" align="center">
							<font color="#000000" style="font-style: bold" size="5">Add Server Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Host Name</td>
							<td width="75px">:</td>
							<td width="200px"><input class="field" type="text" name="host" required="yes"></input></td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Username</td>
							<td >:</td>
							<td> 
								<input class="field" type="text" name="username" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Password</td>
							<td>:</td>
							<td> 
									<input class="field" type="password" name="password" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Status</td>
							<td>:</td>
							<td>
								 <select class="field1" name="status" required="yes">
								 		<option value="Active">Active</option>
								 		<option value="Inactive">Inactive</option>
								 </select>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Remarks</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="remarks"></input>
							</td>
					</tr>
					
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="3" align="center">
								<input class="button" type="submit"  value="Add Server"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry,This host is already exists  !</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}


}

if(no == 3)
{
	/* Adding The Server Details */
	
	String hostName="";
	
	 if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			url=rs.getString(2);
			username=rs.getString(3);
			password=rs.getString(4);
			status=rs.getString(5);
			remarks=rs.getString(6);
			
			if(!url.equals(""))
			{
				String data[] = url.split("//");
				hostName = data[1];
			}
		}
    }   
%>
		
		<div id="a2" align="right" style="position:absolute;top:200px;left:150px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/ServerList">
				<input type="hidden" name="submit" value="Edit"></input>
			    <input type="hidden" name="edit1" value="YES"></input>
			    <input type="hidden" name="id" value="<%=id %>"></input>
					
					<tr>
							<td colspan="3" align="center">
							<font color="#000000" style="font-style: bold" size="5">Edit Server Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Host Name</td>
							<td width="75px">:</td>
							<td width="200px"><input class="field" type="text" name="host" value="<%=hostName%>" required="yes"></input></td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Username</td>
							<td >:</td>
							<td> 
								<input class="field" type="text" name="username" value="<%=username%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Password</td>
							<td>:</td>
							<td> 
									<input class="field" type="password" name="password" value="<%=password%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Status</td>
							<td>:</td>
							<td>
								 <select class="field1" name="status" required="yes">
								 		<option value="Active">Active</option>
								 		<option value="Inactive">Inactive</option>
								 </select>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Remarks</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="remarks" value="<%=remarks%>"></input>
							</td>
					</tr>
					
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="3" align="center">
								<input class="button" type="submit"  value="Update Server"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}


}
%>
</body>
</html>


