package com.eli.view;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.eli.service.IEmployeeService;
import com.eli.util.MyConfig;
public class Driver {
	
	@Autowired
	IEmployeeService employeeService;
	public static void main(String[] args)
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
		Scanner scanner=(Scanner)context.getBean("scanner");
		IEmployeeService employeeService = (IEmployeeService)context.getBean("employeeServiceImple");
		
		while(true)
		{
			System.out.println("WELCOME TO EMPLOYEE LOGIN INFO...");
			System.out.println("1.REGISTER\n2.LOGIN\n3.LOGOUT"
					+"\n4.UPDATE\n5.DELETE\n6.FETCH 1 EMPLOYEE\n7.FETCHALL"
					+"\n8.EXIT");
			System.out.println("PLEASE CHOOSE 1 OPTION");
			int choice=scanner.nextInt();
			//char ch=scanner.next().charAt(0);
			switch(choice)
			{
			case 1:
				employeeService.registerEmployee();
				break;
			case 2:
				//for login:
				//create a abstract method in IEmployeeService as loginEmployee
				//override this method in EmployeeServiceImpl in which
				//ask user for phno and password
				//check user is present or not using phno and password
				//create Attendence reference variable and autowire it
				//save attendence (no need to set any data for now)
				//create arraylist object , put attendence in list
				// and set employee.setAttendences(list)
				//finally update employee
				employeeService.loginEmployee();
				break;
			case 3:
				//ask attendence id and set logout time
				employeeService.logoutEmployee();
				break;
			case 4:
				//give options use another switch case
				//a.update name
				//b.update pwd
				//c.update phone number
				System.out.println("PLEASE CHOOSE 1 OPTION AGAIN");
				System.out.println("a.UPDATE NAME\nb.UPDATE PHONE NUMBER\nc.UPDATE PASSWORD");
				char ch=scanner.next().charAt(0);
				switch(ch)
				{
				case 'a':
					employeeService.updateEmployeeName();
					break;
				case 'b':employeeService.updateEmployeePhoneNumber();
					break;
				case 'c':employeeService.updateEmployeePassword();
					break;
					default:
						 System.out.println("Invalid option");
						break;
				}
				break;
			case 5:employeeService.deleteEmployee();
				break;
			case 6:employeeService.fetchOneEmployee();
				break;
			case 7:employeeService.fetchAllEmployee();
				break;
			case 8:
				System.out.println("THANK YOU..");
				System.exit(0);
				break;
				default:
					//create InvaildChoiceException custom unchecked exception throw it an handle it
				
			}
		}
	}

}
