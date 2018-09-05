package com.vzw.rowmapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.vzw.vo.Employee;

public class NamedEmployeePreparedStatementCallBack implements PreparedStatementCallback<Integer> {

	@Override
	public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		System.out.println(ps.executeUpdate()+" Employee Added Succesfully");
		return ps.executeUpdate();
	}

}
