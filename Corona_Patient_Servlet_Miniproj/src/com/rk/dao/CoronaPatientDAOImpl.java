package com.rk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rk.bo.CoronaPatientBO;

public class CoronaPatientDAOImpl implements CoronaPatientDAO {

	//pooled connection link
	private static final String DSJNDI_NAME="java:/comp/env/Dsjndi";
	
	//SQL_QUERY
	private static final String INSERT_CORONA_PATIENT_QUERY="INSERT INTO CORONA_SERVLET VALUES(CORONA_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	@Override
	public int insert(CoronaPatientBO bo) throws Exception {

		//read inputs
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get pooled connection
		con=getPooledConnection(DSJNDI_NAME);
		
		//create prepared statement
		ps=con.prepareStatement(INSERT_CORONA_PATIENT_QUERY);
		
		//set query param values
		ps.setString(1,bo.getName());
		ps.setString(2,bo.getAdd());
		ps.setInt(3,bo.getAge());
		ps.setString(4,bo.getHospital_name());
		ps.setString(5,bo.getHospital_type());
		ps.setFloat(6,bo.getBillamt());
		
		//execute prepared statement
		count=ps.executeUpdate();
		
		return count;
	}
	
	
	//create a helper method 
	private Connection getPooledConnection(String jndi)throws Exception
	{
		//read input
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		
		//create InitialContext object
		ic= new InitialContext();
		
		//get datasourse object from jndi
		ds=(DataSource)ic.lookup(jndi);
		
		//get pooled connection
		con=ds.getConnection();
		
		return con;
	}//method

}
