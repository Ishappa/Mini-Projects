package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee> {

	@Override
	public int compare(Employee e1,Employee e2) {
		String x=e1.getName();
		String y=e2.getName();
		return x.compareTo(y);
		//return e1.getName().compareTo(e2.getName());
	}
}
