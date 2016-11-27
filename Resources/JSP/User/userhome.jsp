<%@page import="com.kumar.util.Utility"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>

</head>
<body onload="startTimer()">
<img src="<%=request.getContextPath() %>/Resources/Images/header.jpg"></img>

<!-- Main Menu Development (Starts)-->

<div id="mainmenu">
  <ul class="glossymenu">
    <li class="current"><a href="<%=request.getContextPath()%>/Resources/JSP/User/userhome.jsp" title="User Home"><b>Home</b></a></li>
    <li><a href="<%=request.getContextPath()%>/UserProfile" title="View User Profile"><b>Profile</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/upload_file.jsp" title="Upload Files To Cloud"><b>Upload File</b></a></li>
    <li><a href="<%=request.getContextPath()%>/DownloadFiles" title="Download Files From Cloud"><b>Dounload Files</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/User/transactions.jsp" title="View User Transactio Details"><b>Transactions</b></a></li>
    <li><a href="<%=request.getContextPath()%>/?no=5" title="User Logout"><b>Sign Out</b></a></li>
    
  </ul>
</div>


<!-- Main Menu Development (Ends) -->

<!-- Display Contents (Starts) -->

<div style="position:absolute;top:180px;left:50px;">
	<iframe align="middle" src="<%=request.getContextPath()%>/Resources/Images/multi_cloud4.jpg" frameborder="0" scrolling="auto" name="myIframe" height="470" width="950"></iframe>
</div>	

<!-- Display Contents (Ends) -->
</body>
</html>


