package com.digit.servlet.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.servlet.Model.BankApp;


@WebServlet("/Register")
public class Register extends HttpServlet {
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BankApp b = new BankApp();	
	b.setBank_id(Integer.parseInt(req.getParameter("id")));
	b.setBank_name(req.getParameter("bankname"));
	b.setIfsc(req.getParameter("ifsc"));
	b.setAccno(Integer.parseInt(req.getParameter("acc")));
	b.setPin(Integer.parseInt(req.getParameter("pin")));
	b.setCustumer_id(Integer.parseInt(req.getParameter("custid")));
	b.setCustname(req.getParameter("custname"));
	b.setBalance(Integer.parseInt(req.getParameter("balance")));
	b.setEmail(req.getParameter("email"));
	b.setPhone(Long.parseLong(req.getParameter("phoneno")));
		
		boolean x = b.register();
		
		if(x) {
			resp.sendRedirect("/MVCBankApp/success.html");
		}
		else {
			resp.sendRedirect("/MVCBankApp/fail.html");
		}
		
}
}
