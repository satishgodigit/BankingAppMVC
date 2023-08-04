package com.digit.servlet.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.servlet.Model.BankApp;

@WebServlet("/Login")
public class Login extends HttpServlet{
private PreparedStatement prep;
private Connection con;


@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	BankApp b = new BankApp();
	b.setPin((Integer.parseInt(req.getParameter("pin"))));
	b.setCustumer_id(Integer.parseInt(req.getParameter("id")));
	
	HttpSession session = req.getSession(true);
	
	ResultSet x = b.login();
	
	if(x != null) {
		
		session.setAttribute("cust_id", b.getCustumer_id());
		System.out.println(session.getAttribute("cust_id"));
		session.setAttribute("pin", b.getPin());
		try {
			session.setAttribute("cust_name", x.getString("cust_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("/MVCBankApp/Home.jsp");
	}else {
		resp.sendRedirect("/MVCBankApp/LoginFail.html");
	}
	}
}
