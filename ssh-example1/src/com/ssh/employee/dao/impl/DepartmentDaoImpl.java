package com.ssh.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.employee.dao.DepartmentDao;
import com.ssh.employee.domain.Department;
/**
 * 部门管理的DAO层的实现类
 * @author 上山打野
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
		//获得部门总记录
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println(list.get(0).intValue());
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/**
	 * 分页查询部门
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	//DAO中保存部门的方法
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
		
		
	}

	@Override
	//DAO中根据部门Id查询部门的方法
	public Department findById(int did) {
		
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO中修改部门的方法
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}
	//DAO中删除部门的方法
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}

	@Override
	//DAO中查询部门的方法
	public List<Department> findAll() {
		
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
