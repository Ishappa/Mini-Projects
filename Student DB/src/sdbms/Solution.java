package sdbms;

import java.util.Scanner;

import CustomeException.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome database Management System....");
		System.out.println("-----------------------------");
		Scanner ip=new Scanner(System.in);
		StudentManagementSystemImpl sms=new StudentManagementSystemImpl();


		while(true) {
			System.out.println("Enter the Options");
			System.out.println("1:Add Student\n2:Display Studnet\n3:Display All Student\n4:Remove Student\n5:Remove All Student");
			System.out.println("6:Update Student\n7:Count Student\n8:Sort Student\n9:Get Student With LowestMarks\n10:Get Student With HeighestMarks\n11:Exit..!");

			int choice=ip.nextInt();
			switch(choice) {

			case 1:
				sms.addStudent();
				break;

			case 2:
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudent();
				break;

			case 4:
				sms.removeStudent();
				break;

			case 5:
				sms.removeAllStudent();
				break;

			case 6:
				sms.updateStudent();
				break;

			case 7:
				sms.countStudent();
				break;

			case 8:
				sms.sortStudent();
				break;

			case 9:
				sms.getStudentWithLowestMarks();
				break;

			case 10:
				sms.getStudentWithHeighestMarks();
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

			}//end of switch

			System.out.println("--------------------------------");
		}
	}
}


