package com.rk.service;

import com.rk.bo.CoronaPatientBO;
import com.rk.dao.CoronaPatientDAO;
import com.rk.dao.CoronaPatientDAOImpl;
import com.rk.dto.CoronaPatientDTO;

public class Corona_Patient_ServiceImpl implements Corona_Patient_Service {

	private CoronaPatientDAO dao;
	
	//create a 0-param constructor
	public Corona_Patient_ServiceImpl() {
		
		//calling dao class
		dao= new CoronaPatientDAOImpl();
	}
	
	
	@Override
	public String corona_Register(CoronaPatientDTO dto) throws Exception {
		
		//read inputs
		float billamount=0.0f;
		CoronaPatientBO bo=null;
		int count=0;
		String hos_type=null;
		
		
		//write b.logic
		//hos_type=dto.getHospital_type();
		System.out.println("hos type;;; "+dto.getHospital_type());
		if(dto.getHospital_type().equalsIgnoreCase("GOVT"))
		{
			System.out.println("hos type;;; "+dto.getHospital_type());
			billamount=dto.getNumber_day()*1000;
		}
		
		else if(dto.getHospital_type().equalsIgnoreCase("PRIVATE"))
		{
			billamount=dto.getNumber_day()*3000;
		}
		else
		{
			return"Some problem";
		}
		//set BO class
		bo= new CoronaPatientBO();
		
		bo.setName(dto.getName());
		bo.setAdd(dto.getAdd());
		bo.setAge(dto.getAge());
		bo.setHospital_name(dto.getHospital_name());
		bo.setHospital_type(dto.getHospital_type());
		bo.setBillamt(billamount);
		
		//use dao
		count=dao.insert(bo);
		
		if(count==0)
			return"Corona Patient Registation faild";
		else
			return"Corona Patient Registation Succeded and Total BillAmount is"+billamount;
	}//method

}//class
