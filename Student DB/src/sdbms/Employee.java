package sdbms;

public class Employee {

	String id;
	String name;
	
	static int count=101;
	
	Employee(String name){
		this.id="JSP"+count;
		this.name=name;
		count++;
	}
	public static void main(String[] args) {
		Employee e1=new Employee("Tom");
		System.out.println(e1.id+" "+e1.name);
		
		Employee e2=new Employee("Jack");
		System.out.println(e2.id+" "+e2.name);
	}
}
