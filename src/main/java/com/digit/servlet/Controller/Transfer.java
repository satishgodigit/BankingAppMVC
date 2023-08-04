package com.digit.servlet.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.servlet.Model.BankApp;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet{
private Connection con;
private PreparedStatement prep;
private ResultSet resultset2;
private ResultSet r2;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BankApp b = new BankApp();
	
	b.setCustumer_id(Integer.parseInt(req.getParameter("id")));
	b.setBank_name(req.getParameter("bankname"));
	b.setSenderAcc(Integer.parseInt(req.getParameter("S_acc")));
	b.setSenderIFSC(req.getParameter("S_ifsc"));
	b.setReciverAcc(Integer.parseInt(req.getParameter("R_acc")));
	b.setReciverIFSC(req.getParameter("R_ifsc"));
	b.setAmount(Integer.parseInt(req.getParameter("amount")));
	b.setPin(Integer.parseInt(req.getParameter("pin")));
	
	HttpSession session = req.getSession();
	session.setAttribute("error", "Transaction Failed");
	session.setAttribute("amount", b.getAmount());
	
	Random r = new Random();
	String transaction_id = (100000 + r.nextInt(900000))+"";
	session.setAttribute("tid", transaction_id);
	
	
	
		
		boolean r1 = b.transfer();
		
		// validating sender id , ifsc , accno , pin
		if(r1) {
			resp.sendRedirect("/MVCBankApp/TransferSuccess.jsp");
		}
		else{
			resp.sendRedirect("/MVCBankApp/TransferFail.jsp");
		}
		
		
}
}
