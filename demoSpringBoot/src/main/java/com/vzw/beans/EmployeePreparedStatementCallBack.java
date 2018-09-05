package com.vzw.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.vzw.vo.Employee;

public class EmployeePreparedStatementCallBack implements PreparedStatementCallback<Integer> {

	private Employee emp;
	
	public EmployeePreparedStatementCallBack(Employee emp) {
		super();
		this.emp = emp;
	}

	@Override
	public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		ps.setInt(1,emp.getId());  
        ps.setString(2,emp.getName());  
        ps.setString(3,emp.getJob());  
        int i =ps.executeUpdate();
        System.out.println(i+ "  rows added succesfully");
        return i;
	}

}
