package com.rk.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rk.dto.CoronaPatientDTO;
import com.rk.service.Corona_Patient_Service;
import com.rk.service.Corona_Patient_ServiceImpl;
import com.rk.vo.CoronaPatientVO;

@WebServlet("/coronabill")

public class CoronaPatientControl extends HttpServlet {
	
	private Corona_Patient_Service service;
	
   //init method
	public void init() throws ServletException {
		
		service= new Corona_Patient_ServiceImpl();
	}

	//destroy method
	public void destroy() {
		service=null;
	}

	//do get
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//read inputs
		PrintWriter pw=null;
		String result=null;
		String type=null;
		
		//load class
		CoronaPatientVO vo=null;
		CoronaPatientDTO dto=null;
		
	   //get PrintWriter
		pw=res.getWriter();
		
		//set response content type
		res.setContentType("text/html");
		
		//read form data ... and store VO class object
		vo=new CoronaPatientVO();
		
		vo.setName(req.getParameter("pname"));
		vo.setAdd(req.getParameter("padd"));
		vo.setAge(req.getParameter("page"));
		vo.setHospital_name(req.getParameter("phname"));
		vo.setNumber_day(req.getParameter("NODAY"));
		
		//type=req.getParameter("htype");
		vo.setHospital_type(req.getParameter("htype"));
		
		//convert vo to dto
		dto=new CoronaPatientDTO();
		
		dto.setName(vo.getName());
		dto.setAdd(vo.getAdd());
		dto.setAge(Integer.parseInt(vo.getAge()));
		dto.setHospital_name(vo.getHospital_name());
		dto.setHospital_type(vo.getHospital_type());
		dto.setNumber_day(Integer.parseInt(vo.getNumber_day()));
		System.out.println("in control class ="+vo.getNumber_day());
		
		//use service
				try {
					result=service.corona_Register(dto);
					pw.println("<h1 style='color:green;text-align:center'>"+result+"</h1>");
				}//try
				catch(Exception e) {
					e.printStackTrace();
					pw.println("<h1 style='color:red;text-align:center'>Internal Problem --Try Again </h1>");
				}
				//add hyperlink
				pw.println("<br><br><a href='Corona_Patient_Register.html'>home </a>");
				//close stream
				pw.close();
	
}//method doget

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//do post

}//class
