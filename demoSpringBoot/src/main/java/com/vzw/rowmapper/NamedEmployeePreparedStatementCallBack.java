package com.vzw.rowmapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.vzw.vo.Employee;

public class NamedEmployeePreparedStatementCallBack implements PreparedStatementCallback<Integer> {

	@Override
	public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		int count = ps.executeUpdate();
		System.out.println(count +"  employee Added Succesfully");
		return count;
	}

}
