package edbms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


import customexception.EmployeeNotFoundException;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem{

	Scanner ip=new Scanner(System.in);
	Map<String,Employee> db=new LinkedHashMap<String,Employee>();
	
	
	@Override
	public void addEmployee() {
		System.out.println("Enter Age");
		int age=ip.nextInt();
		System.out.println("Enter Name");
		String name=ip.next();
		System.out.println("Enter Salary");
		double Salary=ip.nextDouble();
		
		Employee e=new Employee(age, name, Salary);
		db.put(e.getId(),e);//storing inside map
		System.out.println("Employee Record Inserted Successfully");
		System.out.println("Employee Id is "+e.getId());

	}
	
	
	@Override
	public void displayEmployee() {
		System.out.println("Enter Employee Id");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)==true)
		{
			Employee e=db.get(id);
			System.out.println("Id: "+e.getId()+"Name: "+e.getName()+"Age: "+e.getAge()+"Salary: "+e.getSalary());
			//System.out.println(e);-->printing ref var as toString() is Override
		}
		else {
			try {
				String message="Employee with the Id "+id+" is not Found!";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	@Override
	public void displayAllEmployee() {
		
	}
	
	@Override
	public void removeEmployee() {
		
	}
	
	@Override
	public void removeAllEmployee() {
		
	}
	
	@Override
	public void updateEmployee() {
		
	}
	
	@Override
	public void countEmployee() {
		
	}
	
	@Override
	public void sortEmployee() {
		
	}
	
	@Override
	public void getEmployeeWithHeighestSalary() {
		
	}
	
	@Override
	public void getEmployeeWithLowestSalary() {
		
	}
}
