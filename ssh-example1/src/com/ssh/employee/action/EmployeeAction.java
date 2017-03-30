package com.ssh.employee.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.employee.domain.Department;
import com.ssh.employee.domain.Employee;
import com.ssh.employee.domain.PageBean;
import com.ssh.employee.service.DepartmentService;
import com.ssh.employee.service.EmployeeService;

/**
 * 员工管理的Action类
 * @author 上山打野
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//接受当前页数
	private int currPage = 1;
	//模型驱动需要使用的对象
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	//分页查询员工的方法
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	public int getCurrPage() {
		return currPage;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Override
	public Employee getModel() {
		
		return employee;
	}
	//登陆执行的方法
	public String login() {
		System.out.println("login方法执行了");
		//调用业务层的类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			//登录失败
			this.addActionError("用户名或是密码错误");
			return INPUT;
		}else {
			System.out.println("登陆成功");
			//登陆成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;			
		}		
	}
	//跳转到添加员工页面执行的方法
	public String saveUI() {
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	//保存员工执行的方法
	public String save() {
		employeeService.save(employee);
		return"saveSuccess";
	}
	//编辑员工的执行的方法
	public String edit() {
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	//修改员工的执行的方法
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	//删除员工的执行的方法
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
