package com.vzw.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.vzw.rowmapper.EmployeeRowMapper;
import com.vzw.rowmapper.NamedEmployeePreparedStatementCallBack;
import com.vzw.vo.Employee;

@Component
public class JDBCBean {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParametreJdbcTemplate;

	public List<Employee> getEmpDetails() {

		String sql="select * from employee";
		List<Employee> empList = jdbcTemplate.query(sql, new EmployeeRowMapper());
		return empList;
	}
	
	public List<Employee> addEmpDetails(Employee emp) {
		String sql="insert into employee values(?,?,?)"; 
		jdbcTemplate.execute(sql, new EmployeePreparedStatementCallBack(emp));
		return getEmpDetails();
	}

	public List<Employee> addNamedEmpDetails(Employee e) {
	    String sql="insert into employee values(:id,:name,:job)"; 
	    Map<String,Object> map=new HashMap<String,Object>();  
	    map.put("id",e.getId());  
	    map.put("name",e.getName());  
	    map.put("job",e.getJob()); 
	    namedParametreJdbcTemplate.execute(sql, map, new NamedEmployeePreparedStatementCallBack());
		return getEmpDetails();
	}

	
}
