package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;


 

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to DataBase Management System...!");
		System.out.println("-------------------------------");
		Scanner ip=new Scanner(System.in);
		EmployeeManagementSystemImpl ems=new EmployeeManagementSystemImpl();
		
		while(true) {
			
			System.out.println("Enter options..!");
			System.out.println("1:Add Employee\n2:Display Employee\n3:Display All Employee\n4:Remove Employee\n5:Remove All Employee");
			System.out.println("6:Update Employee\n7:Count Employee\n8:Sort Employee\n9:Get Employee With LowestSalary\n10:Get Employee With HeightSalary\n11:Exit..!");
			
			int choice=ip.nextInt();
			switch(choice) {

			case 1:
				ems.addEmployee();
				break;

			case 2:
				ems.displayEmployee();
				break;

			case 3:
				ems.displayAllEmployee();
				break;

			case 4:
				ems.removeEmployee();
				break;

			case 5:
				ems.removeAllEmployee();
				break;

			case 6:
				ems.updateEmployee();
				break;

			case 7:
				ems.countEmployee();
				break;

			case 8:
				ems.sortEmployee();
				break;

			case 9:
				ems.getEmployeeWithLowestSalary();
				break;

			case 10:
				ems.getEmployeeWithHeighestSalary();
				break;

			case 11:
				System.out.println("Thank you...!");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid choice, Enter the Valid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
