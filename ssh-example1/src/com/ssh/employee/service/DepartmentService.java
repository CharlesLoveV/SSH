package com.ssh.employee.service;


import java.util.List;

import com.ssh.employee.domain.Department;
import com.ssh.employee.domain.PageBean;

/**
 * 部门管理的业务层的接口
 * @author 上山打野
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(int currPage);

	void save(Department department);

	Department findById(int did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

	
	

}
