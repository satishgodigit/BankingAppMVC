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

@WebServlet("/Loan")
public class Loan extends HttpServlet{
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	BankApp b = new BankApp();
	
	b.setLoan_id(Integer.parseInt(req.getParameter("id")));
	
		ResultSet r = b.loan();
		
		if(r != null) {
			
		try {
			session.setAttribute("loantype", r.getString("l_type"));
			session.setAttribute("tenure", r.getInt("tenure"));
			session.setAttribute("interest", r.getFloat("interest"));
			session.setAttribute("description", r.getString("description"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/MVCBankApp/LoanDetails.jsp");
		}
		else {
			resp.sendRedirect("/MVCBankApp/LoanDetailsFail.jsp");
		}
		
		
	
	
}
}
