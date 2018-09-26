package org.albert.angularjs.model;

public class Employee {
	
	private Long empId;
	private String empNo;
	private String empName;
	private String position;
	
	public Employee(EmployeeForm employeeForm) {
		this.empId = employeeForm.getEmpId();
		this.empNo = employeeForm.getEmpNo();
		this.empName = employeeForm.getEmpName();
		this.position = employeeForm.getPosition();
	}
	
	public Employee(Long empId, String empNo, String empName, String position) {
		super();
		this.empId = empId;
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
	}

	public Long getEmpId() {
		return empId;
	}
	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

}
