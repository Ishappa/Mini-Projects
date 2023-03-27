package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee e1,Employee e2) {
		Integer x=e1.getAge();
		Integer y=e2.getAge();
		return x.compareTo(y);
		//return e1.getAge()-e2.getAge();
	}
	
}
