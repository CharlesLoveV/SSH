package com.ssh.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.employee.dao.DepartmentDao;
import com.ssh.employee.dao.EmployeeDao;
import com.ssh.employee.domain.Employee;
import com.ssh.employee.domain.PageBean;
import com.ssh.employee.service.EmployeeService;
/**
 * 员工管理业务层的实现类
 * @author 上山打野
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	//业务层完成登陆的方法
	@Override
	public Employee login(Employee employee) {
		
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	//业务层分页查询员工的方法
	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的页数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存员工的方法
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	//业务层根据员工Id查询员工的方法
	public Employee findById(int eid) {
		
		return employeeDao.findById(eid);
	}

	@Override
	//业务层修改员工的方法
	public void update(Employee employee) {
		employeeDao.update(employee);
		
		
	}

	@Override
	//业务层删除员工的方法
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}
}
