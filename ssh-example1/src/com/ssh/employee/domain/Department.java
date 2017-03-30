package com.ssh.employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 *部门的实体
 * @author 上山打野
 *
 */
public class Department {
	private int did;
	private String dname;
	private String ddesc;
	//员工的集合
	private Set<Employee> employees = new HashSet<Employee>();
	
	public int getDid() {
		return did;
	}
	
	

	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}



	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
}
