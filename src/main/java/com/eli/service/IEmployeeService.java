package com.eli.service;

public interface IEmployeeService {
	
	public void registerEmployee();
	public void loginEmployee();
	public void logoutEmployee();
    public void updateEmployeeName();
    
    public void updateEmployeePhoneNumber();
    public void updateEmployeePassword();
    public void deleteEmployee();
    public void fetchOneEmployee();
    public void fetchAllEmployee();
}
