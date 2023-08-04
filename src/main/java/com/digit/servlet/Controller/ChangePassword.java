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

import com.digit.servlet.Model.BankApp;

@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet{
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BankApp b = new BankApp();
	b.setOldPassword(Integer.parseInt(req.getParameter("old")));
	b.setNewPassword(Integer.parseInt(req.getParameter("new")));
	b.setConfirmPassword(Integer.parseInt(req.getParameter("conf")));
	
		
		
		boolean r = b.changePass();
		if(r) {
			resp.sendRedirect("/MVCBankApp/passwordChangeSuccess.html");
		}
		else {
			resp.sendRedirect("/MVCBankApp/passwordChangeFail.html");
		}
		
	
}
}

