package com.ssh.employee.dao;

import java.util.List;

import com.ssh.employee.domain.Employee;

/**
 * 员工管理的DAO的接口
 * @author 上山打野
 *
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);
 
}
