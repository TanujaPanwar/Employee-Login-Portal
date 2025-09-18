package com.eli.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eli.dao.AttendenceDao;
import com.eli.dao.EmployeeDao;
import com.eli.entity.Attendence;
import com.eli.entity.Employee;
@Component
public class EmployeeServiceImple implements IEmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	Scanner scanner;
	@Autowired
	Employee employee;
	@Autowired
	Attendence attendence;
	@Autowired
	AttendenceDao attendenceDao;
	
	public void registerEmployee() {
		System.out.println("Enter Name");
		employee.setName(scanner.next());
		System.out.println("Enter PhoneNumber");
		employee.setPhoneNumber(scanner.nextLong());
		System.out.println("Enter Password");
		employee.setPassword(scanner.next());
		
		employeeDao.saveEmployee(employee);
	}
	
	
	public void loginEmployee() {
		//ask user for phno and pwd
		System.out.println("Enter PhoneNumber");
		long phono=scanner.nextLong();
		System.out.println("Enter Password");
		String password=scanner.next();
		Employee dbEmployee = employeeDao.findEmployeeByEmailAndPassword(phono , password);
		if(dbEmployee!=null) {
			attendenceDao.saveAttendence(attendence);
			
			List<Attendence> listAttendence = employeeDao.fetchAttendenceByUserId(dbEmployee.getEmployeeId());
			if(listAttendence==null) {
				listAttendence=new ArrayList<Attendence>();
				
			}
			listAttendence.add(attendence);
			dbEmployee.setAttendences(listAttendence);
			employeeDao.updateEmployee(dbEmployee);
		}
		else {
			System.out.println("INVALID PHONE NUMBER OR PASSWORD...");
		}
	}
	public void logoutEmployee() {
		System.out.println("ENTER ATTENDENCE ID : ");
		int aId=scanner.nextInt();
		
		Attendence dbAttendence = attendenceDao.findById(aId);
		dbAttendence.setLogoutTime(LocalDateTime.now());
		
		attendenceDao.updateAttendence(dbAttendence);
	}
	
	
	
	public void updateEmployeeName() {
		System.out.println("Enter Id");
		int Id=scanner.nextInt();
		Employee dbEmployee = employeeDao.findEmployeeById(Id);
		 if (dbEmployee != null) {
		        System.out.println("Enter New Name");
		        String newName = scanner.next();
		        dbEmployee.setName(newName);  // set new name on fetched employee
		        employeeDao.updateEmployee(dbEmployee);  // update dbEmployee
		        System.out.println("Name updated successfully!");
		    } else {
		        System.out.println("Employee not found with id: " + Id);
		    }
		
	}
		public void updateEmployeePhoneNumber() {
			System.out.println("Enter Id");
			int Id=scanner.nextInt();
			Employee dbEmployee = employeeDao.findEmployeeById(Id);
			 if (dbEmployee != null) {

					System.out.println("Enter New PhoneNumber");
					long newPhoneNumber = scanner.nextLong();
					
					 dbEmployee.setPhoneNumber(newPhoneNumber);  // set new phone number on fetched employee
				        employeeDao.updateEmployee(dbEmployee);  //update dbEmployee
				        System.out.println("Phone Number updated successfully!");
				    } else {
				        System.out.println("Employee not found with id: " + Id);
				    }
			 }
		
		public void updateEmployeePassword() {
			System.out.println("Enter Id");
			int Id=scanner.nextInt();
			Employee dbEmployee = employeeDao.findEmployeeById(Id);
			 if (dbEmployee != null) {

					System.out.println("Enter New Password");
					 String newPassword = scanner.next();
					
					 dbEmployee.setPassword(newPassword);  // set new password on fetched employee
				        employeeDao.updateEmployee(dbEmployee);  //update dbEmployee
				        System.out.println("Password updated successfully!");
				    } else {
				        System.out.println("Employee not found with id: " + Id);
				    }
			 }


		
		public void deleteEmployee() {
		    System.out.println("Enter Id");
		    int id = scanner.nextInt();
		    Employee dbEmployee = employeeDao.findEmployeeById(id);

		    if (dbEmployee != null) {
		        employeeDao.deleteEmployee(dbEmployee);  // delete the fetched employee
		        System.out.println("Deleted successfully!");
		    } else {
		        System.out.println("Employee not found with id: " + id);
		    }
		}
		public void fetchOneEmployee() {
			System.out.println("Enter Id");
		    int id = scanner.nextInt();
		    Employee dbEmployee = employeeDao.findEmployeeById(id);
		    if (dbEmployee != null) {
		        System.out.println("----- Employee Details -----");
		        System.out.println("ID: " + dbEmployee.getEmployeeId());
		        System.out.println("Name: " + dbEmployee.getName());
		        System.out.println("Phone: " + dbEmployee.getPhoneNumber());
		        System.out.println("Password: " + dbEmployee.getPassword());
		       
		    } 
		    else {
		        System.out.println("Employee not found with id: " + id);
		    }
		}
			
			public void fetchAllEmployee() {
				List<Employee> employees = employeeDao.findAllEmployee();
				if (employees.isEmpty()) {
			        System.out.println("No employees found.");
			    } 
				else {
			        for (Employee emp : employees) {
			            System.out.println(emp.getEmployeeId() + " | " 
			                             + emp.getName() + " | " 
			                             + emp.getPhoneNumber() + " | " 
			                             + emp.getPassword());
			        }
			}
			
			}
}
		
		
		
		
	


