package com.digit.servlet.Controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.servlet.Model.BankApp;

@WebServlet("/checkBalance")
public class CheckBalance extends HttpServlet {
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	BankApp b = new BankApp();
	
	b.setCustumer_id((int)session.getAttribute("cust_id"));

		String r = b.checkbalance();
		if(r != null) {
			session.setAttribute("balance", r);
			resp.sendRedirect("/MVCBankApp/Balance.jsp");
		}
		else {
			resp.sendRedirect("/MVCBankApp/BalanceFail.jsp");
		}
		
	
}
}
