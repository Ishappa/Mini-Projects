package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomeException.InvalidChoiceException;
import CustomeException.StudentNotFoundException;
import CustomeSorting.SortStudentByAge;
import CustomeSorting.SortStudentById;
import CustomeSorting.SortStudentByMarks;
import CustomeSorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner ip=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {
		System.out.println("enter the Age");
		int age=ip.nextInt();
		System.out.println("enter the Name");
		String name=ip.next();
		System.out.println("enter the Marks");
		int marks=ip.nextInt();

		Student std=new Student(age,name,marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is "+std.getId());

	}
	@Override
	public void displayStudent() {
		System.out.println("Enter the Student Id");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)==true) {
			Student std=db.get(id);
			System.out.println("Id: "+std.getId()+"Name: "+std.getName()+"Age: "+std.getAge()+"Marks: "+std.getMarks());
			//System.out.println(std);-->printing ref var as toString() is Override
		}
		else {
			try {
				String message="Student with the Id "+id+" is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			Set<String> keys=db.keySet();
			for(String key:keys) {
				Student value=db.get(key);
				System.out.println(value);	//System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="Students Records are Not Available to Display!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent() {

		System.out.println("enter the Id");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found..!!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Successfully..!");
		}
		else {
			try {
				String message="Student with the Id "+id+"is not Found!..";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent() {
		if(db.size()!=0)
		{

			System.out.println("Students Records Available:"+db.size());
			db.clear();
			System.out.println("All Students Records Deleted Successfully!!");
			System.out.println("Students Records Available: "+db.size());
		}
		else
		{
			try {
				String message="Student Database is Empty!!";


				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}



	@Override
	public void updateStudent() {

		System.out.println("Enter the Id");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Record Found..!");
			Student std=db.get(id);

			System.out.println("1.Update Age\n2.Update Name\n3.Update Marks");
			System.out.println("Enter Choice");
			int choice=ip.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=ip.nextInt();
				std.setAge(age);//std.setAge(ip.nextInt());
				break;

			case 2:
				System.out.println("Enter Name");
				String name=ip.next();
				std.setName(name);//std.setName(ip.next());
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=ip.nextInt();
				std.setMarks(marks);//std.setMarks(ip.nextInt());
				break;

			default:
				try {
					String msg1="Invalid Choice, Enter Valid Choice..!";
					throw new IllegalArgumentException(msg1);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String msg2="Student with the Id "+id+" is Not Found..!";
				throw new StudentNotFoundException(msg2);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countStudent() {

		System.out.println("No of Student Records: " +db.size());
	}
	@Override
	public void sortStudent() {
		
		if(db.size()>=2) {
			Set<String>keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			
			for(String key:keys) {
				list.add(db.get(key));
				System.out.println("1.Sort By Id\n2.Sort By Age\n3.Sort By Name");
				System.out.println("4.Sort By Marks\nEnter Choice");
				int choice=ip.nextInt();

				switch(choice) {
				case 1:

					Collections.sort(list,new SortStudentById());
					for(Student s:list) {
						System.out.println(s);
					}
					break;

				case 2:

					Collections.sort(list,new SortStudentByAge());
					for(Student s:list) {
						System.out.println(s);
					}
					break;

				case 3:

					Collections.sort(list,new SortStudentByName());
					for(Student s:list) {
						System.out.println(s);
					}
					break;

				case 4:

					Collections.sort(list,new SortStudentByMarks());
					for(Student s:list) {
						System.out.println(s);
					}
					break;

				default:
					try {
						String message="Invalid Choice, Enter Valid Choice";
						throw new InvalidChoiceException(message);

					}
					catch(Exception e) {

						System.out.println(e.getMessage());
					}

				}
			}

		}
		else {
			try {
				String message="No Sufficient Students Objects to Sort..!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2)
		{
			Set<String>keys=db.keySet();
			List<Student> list=new ArrayList<Student>();

			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(0));

		}
		else {
			try {
				String message="No Sufficient Student Objects to compare..!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void getStudentWithHeighestMarks() {
		if(db.size()>=2) {
			
			Set<String>keys=db.keySet();
			List<Student> list=new ArrayList<Student>();

			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="No Sufficient Student Objects to compare..!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
		
	}

}


