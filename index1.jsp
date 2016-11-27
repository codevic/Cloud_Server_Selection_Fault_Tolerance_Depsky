<html>
<%! 
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
%>
<head>
<title>Admin Login Page</title>

<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>


<!-- STYLE -->

<style>

#login
{
	margin:5em auto;
	background:#A9D0F5;
	border:40px solid #EEEEEE;
	width:400px;
	height:310px;
	
	-moz-border-radius:100px;
	-webkit-border-radius:100px;
	border-radius:100px;
	
	-moz-box-shadow:0 0 300px #777777;
	-webkit-box-shadow:0 0 300px #777777;
	box-shadow:0 0 300px #777777;
	
	text-align:center;
	position:absolute;
	left:500px
}

#login a, #login a:visited{color:#0283b2;}
#login a:hover{color:#111;}

#login h1
{
	
	color:#5BACC4;
	text-shadow:#007dab 0 2px 0;
	font-size:14px;
	padding:18px 23px;
	margin:0 0 1.5em 0;
	border-bottom:1px solid #007dab;
}

#login .field
{
	border:10px solid #A2A7A2;
	color:white;
	width:300px;
	font-size:12px;
	line-height:1.5em;
	padding:4px;
	-moz-box-shadow:inset 0 0 5px #ccc;
	-webkit-box-shadow:inset 0 0 5px #ccc;
	box-shadow:inset 0 0 50px #000000;
}	

#login div.submit label{float:none;display:inline;font-size:11px;}
	
#login button
{
	border:0;
	padding:0 30px;
	height:30px;
	line-height:30px;
	text-align:center;
	font-size:12px;
	color:#fff;
	text-shadow:#007dab 0 1px 0;
	background:#424242;
	-moz-border-radius:50px;
	-webkit-border-radius:50px;
	border-radius:50px;
	cursor:pointer;
}



</style>

<script language="javascript">
	function check()
	{
		if(document.f1.username.value.length==0 && document.f1.password.value.length==0)
		{
			window.location.href = 'index1.jsp?no=1';
			return false
		}
		if(document.f1.username.value.length==0)
		{
			window.location.href = 'index1.jsp?no=2';
			return false
		}
		if(document.f1.password.value.length==0)
		{
			window.location.href = 'index1.jsp?no=3';
			return false
		}
	}
	
</script>
</head>

<%
	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Enter Username and Password !</p>
    		</div>	
    	 
<%
	}
	if(no==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Please,Enter Your Username.!</p>
    	</div>	
<%
	}
	if(no==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Please,Enter Your Password.!</p>
    	</div>	
<%
	}
%>
<%
	if(no==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:130px;left:530px">	
    			<p> Sorry,Invalid Username/Password!</p>
    	</div>	
<%
	}
%>
<%
	if(no==5)
	{
%>
		<div id="kumar">
			<p id="message">You have Loged out successfully...!</p>
		</div>
<%
	}
%>

<body onload="startTimer()">

<img src="<%=request.getContextPath() %>/Resources/Images/header.jpg"></img>

	<form name="f1" id="login" method="post" action="<%=request.getContextPath()%>/AdminLogin"> 
	    
	    <img src="<%=request.getContextPath() %>/Resources/Images/user_mail.jpg" width="75" height="50" align="center"></img>
	    <img src="<%=request.getContextPath() %>/Resources/Images/user_female.jpg" width="75" height="50" align="center"/>
	    <h1> 
	    	<font color="white" size="4"><strong>Admin Login</strong></font>
	   </h1>
	    
    	<div>
    		Username
    		<input type="text" name="username" id="login_username" class="field required" />
    	</div>			
	    <div>
    		Password
    		<input type="password" name="password" id="login_password" class="field required" />
    	</div>	
    	
  	
	<%--  	<a href="#">Forgot your password?</a><br></br> --%>
		<a href="<%=request.getContextPath() %>/index.jsp">Are you a User?</a>
    	<div class="submit">
        	<button type="submit" onclick="return check();">Log in</button><br>   
		    <%--  <label>
        		<input type="checkbox" name="remember" id="login_remember" value="yes" />
	            Remember my login on this computer  
        	</label>--%>
    	</div>
    	<br>
    	<img src="<%=request.getContextPath() %>/Resources/Images/login_lock2.jpg" width="75" height="50" align="center"></img>
</form>

<div style="position:absolute;top:150px;left:100px;font-size:50px;color:red;">
	Multi Cloud
</div>

<div style="position:absolute;top:200px;left:50px">
<img src="<%=request.getContextPath() %>/Resources/Images/DepSky copy.jpg" height="450" width="350"></img>
</div>
</body>
</html>