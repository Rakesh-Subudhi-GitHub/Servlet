package com.rk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryApp extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		PrintWriter pw=null;
		int code=0;
		String capital[]= {"newdelhi","asm","bse","cse","it"};
		//get PrintWriter
		pw=resp.getWriter();
		
		//set response content type
		resp.setContentType("text/html");
		
		//get content type code
		code=Integer.parseInt(req.getParameter("counry"));
		
		//disply contry capital
		pw.println("<h1 style='color:blue;test-align:center'>capital is::"+capital[code]+"</h1>");
		
		//add hyperlink 
		pw.println("<br><a href='form.html'>home</a>");
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	doGet(req,resp);	
	}
}
