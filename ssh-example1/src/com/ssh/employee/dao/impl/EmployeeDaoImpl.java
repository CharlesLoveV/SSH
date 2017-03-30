package com.ssh.employee.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.employee.dao.EmployeeDao;
import com.ssh.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {


	@Override
	//DAO中根据用户名和密码查询用户的方法
	public Employee findByUsernameAndPassword(Employee employee) {
		 
		String hql = "from Employee where username = ? and password = ?";			
		List <Employee> list =(List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());		
		System.out.println(employee.getUsername() + "/" + employee.getPassword());
		/*list = (List<Employee>) this.getHibernateTemplate().find(hql, "小薇薇","520");*/
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	//统计员工的个数
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if (list.size()>0) {
			return list.get(0).intValue();
			
		}
		
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		
		return list;
	}

	@Override
	//DAO的保存员工的方法
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	//DAO中根据员工Id查询员工的方法
	public Employee findById(int eid) {
		
		return this.getHibernateTemplate().get(Employee.class,eid);
	}

	@Override
	//DAO中修改员工的方法
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	//DAO层删除员工的方法
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}

}
