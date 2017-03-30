package com.ssh.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.employee.dao.DepartmentDao;
import com.ssh.employee.domain.Department;
import com.ssh.employee.domain.PageBean;
import com.ssh.employee.service.DepartmentService;
/**
 * 部门管理的业务层的实现类
 * @author 上山打野
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	//注入部门管理的DAO
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//分页查询部门的方法
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		//封装每页显示的记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存部门的方法
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	//业务层根据部门Id查询部门的方法
	public Department findById(int did) {
		
		return departmentDao.findById(did);
	}
	//业务层修改部门的方法
	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}
	//业务层删除部门的方法
	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}

	@Override
	//查询所有部门的方法
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}

	
		
	
}
