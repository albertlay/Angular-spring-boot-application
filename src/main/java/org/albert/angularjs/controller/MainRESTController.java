package org.albert.angularjs.controller;

import java.util.List;

import org.albert.angularjs.dao.EmployeeDAO;
import org.albert.angularjs.model.Employee;
import org.albert.angularjs.model.EmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<Employee> getEmployees(){
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}
	
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable("empId") Long empId) {
		return employeeDAO.getEmployee(empId);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee addEmployee(@RequestBody EmployeeForm empForm) {
		
		System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo()); 
		
		return employeeDAO.addEmployee(empForm);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee updateEmployee(@RequestBody EmployeeForm empForm) {
		
		System.out.println("(Server Side) Editing employee with id: " + empForm.getEmpId());
		
		return employeeDAO.updateEmployee(empForm);
	}
	
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public void deleteEmployee(@PathVariable("empId") Long empId) {
		
		System.out.println("(Server Side) Deletoing employee with id: " + empId);
		
		employeeDAO.deleteEmployee(empId);
	}
}
