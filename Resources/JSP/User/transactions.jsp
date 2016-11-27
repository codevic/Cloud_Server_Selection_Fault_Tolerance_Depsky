<%@page import="com.kumar.util.Utility"%><html>
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
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/userhome.jsp" title="User Home"><b>Home</b></a></li>
    <li><a href="<%=request.getContextPath()%>/UserProfile" title="View User Profile"><b>Profile</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/upload_file.jsp" title="Upload Files To Cloud"><b>Upload File</b></a></li>
    <li><a href="<%=request.getContextPath()%>/DownloadFiles" title="Download Files From Cloud"><b>Dounload Files</b></a></li>
    <li class="current"><a href="#" title="View User Transactio Details"><b>Transactions</b></a></li>
    <li><a href="<%=request.getContextPath()%>/?no=5" title="User Logout"><b>Sign Out</b></a></li>
    
  </ul>
</div>


<div id="a2" style="position:absolute;top:230px;left:250" class="c">
	<form name="f1" action="<%=request.getContextPath()%>/ViewUserTransaction">
	<table id="login" align="center">
	    
	    <h1 align="center"><font color="#000000" style="font-style: bold" size="5">View Transaction Details</font></h1>
	    
		<hr size="10" color="#5E74D8"></hr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
	    
		<tr  align="center">
		    
			<td align="center">
			        
					<input type="radio" class="field" name="tType" value="Upload" required="required" width="150px"></input>
					
					 <td>View Upload Transactions Details</td>
			</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr align="center">
		    
			<td align="center">
			        
					<input type="radio" class="field" name="tType" value="Download" required="required" width="150px"></input>
					
					 <td>View Download Transactions Details</td>
			</td>
		</tr>
		
		<tr>
				<td>&nbsp;</td>
		</tr>
		
		<tr align="center">
		    
			<td align="center" colspan="3">
			        
					<input type="submit" class="button" value="View Transaction" ></input>
					
			</td>
		</tr>
		
	
	</table>
	</form>
	</div>

</body>
</html>


