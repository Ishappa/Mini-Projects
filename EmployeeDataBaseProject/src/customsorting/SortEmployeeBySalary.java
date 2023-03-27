package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee e1,Employee e2) {
		Double x=e1.getSalary();
		Double y=e2.getSalary();
		return x.compareTo(y);
		//return e1.getSalary().compareTo(e2.getSalary());
	}
}
