<%@page import="com.kumar.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.kumar.DAO.AdminDAO"%>
<%@page import="java.util.Random"%><html>
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
    <li><a href="<%=request.getContextPath()%>/ServerList?submit=get" title="Cloud Server Details" onclick=""><b>Servers</b></a></li>
    <li class="current"><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/fault_tolerance.jsp" title="Cloud Fault Tolerance"><b>Fault Tolerance</b></a></li>
    <li><a href="<%=request.getContextPath()%>/UserList?submit=get" title="Users Details"><b>Members</b></a></li>
    <li><a href="<%=request.getContextPath()%>/Resources/JSP/Admin/transactions.jsp" title="View All Users Transactio Details"><b>Transactions</b></a></li>
    <li><a href="<%=request.getContextPath()%>/" title="Admin Logout"><b>Sign Out</b></a></li>
  </ul>
</div>


<!-- Main Menu Development (Ends) -->

<%!

String prob="";
double probability=0.0;
double value = 0.0;
String formula = "";
int a=3;
int b=1;
double cloud_no = 0;
long cloudNo = 0;

public static String getRandomValue(final Random random,final int lowerBound,final int upperBound,final int decimalPlaces)
{

	    if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0)
	    {
	        throw new IllegalArgumentException("Put error message here");
	    }

	    final double dbl =
	        ((random == null ? new Random() : random).nextDouble() * (upperBound - lowerBound))+ lowerBound;
	    return String.format("%." + decimalPlaces + "f", dbl);
	    
}
%>

<%
	final Random rnd = new Random();
    int low = 0;
    int high = 1;
    int decimalPlace = 1;
    
    prob = getRandomValue(rnd, low, high, decimalPlace);
    
    probability = Double.parseDouble(prob);
    
    formula = a+"*"+probability+"+"+b;
    
    value = (a * probability) + b;
    
    cloud_no = Math.round(value);
    
    cloudNo = Math.round(cloud_no);
    
    
	System.out.println("Probabilities : " + probability);
%>

<div id="a2" align="right" style="position:absolute;top:200px;left:100px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/CalculateFaultTollerance" method="post">
					
					<tr>
							<td colspan="3" align="center">
							<font color="#000000" style="font-style: bold" size="5">Fault Tolerance Value Calculation</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Fault Probabilities</td>
							<td width="75px">:</td>
							<td width="200px"><input class="field" type="text" name="probability" value="<%=probability %>" required="yes"></input></td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Fault Probabilities Formula </td>
							<td >:</td>
							<td> 
								<input class="field" type="text" name="formula" value="<%=formula%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Fault Tolerance Value</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="value" value="<%=value%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Number Of Clouds</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="cloud_no" value="<%=cloudNo%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="3" align="center">
								<input class="button" type="submit" name="submit" value="Reset"></input>
								<input class="button" type="submit"  name="submit" value="Submit"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>

<%	
	if(Utility.parse(request.getParameter("no"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Fault Tolerance Details Added successfully ..!</p>
			</div>
		<%
	}

	if(Utility.parse(request.getParameter("no"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
				<p>Opps Somthing Went Wrong,Try It Again!</p>
			</div>
		<%
	}
%>

</body>
</html>


