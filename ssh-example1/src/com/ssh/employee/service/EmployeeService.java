package com.ssh.employee.service;

import com.ssh.employee.domain.Employee;
import com.ssh.employee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 * @author 上山打野
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int currPage);

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
