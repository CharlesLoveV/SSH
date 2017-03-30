package com.ssh.employee.dao;

import java.util.List;

import com.ssh.employee.domain.Department;

/**
 * 部门管理的DAO层的接口
 * @author 上山打野
 *
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(int did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
