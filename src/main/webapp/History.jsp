<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">
Transaction History
</h1>
<br><br>
<% 
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/bank";
	String user = "root";
	String pass = "1732";
	
	Connection con = DriverManager.getConnection(url, user,pass);
	PreparedStatement prep = con.prepareStatement("Select * from transferstatus");
	ResultSet r = prep.executeQuery();
	while(r.next()){
		out.println("<h3>"+"Custumer ID : "+r.getInt(1)+"\t"+"<br><br> </h3>");
		
		out.println("BankName : "+r.getString(2)+"\t");
		out.println("Sender IFSC code : "+r.getString(3)+"\t");
		out.println("Sender Account No : "+r.getInt(4)+"\t");
		out.println("Reciver IFSC code : "+r.getString(5)+"\t");
		out.println("Reciver Account : "+r.getInt(6)+"\t");
		out.println("Amount : "+r.getInt(7));
		out.println("<br><br>");
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<br><br>
<a href="Home.jsp">Redirect</a>
</body>
</html>