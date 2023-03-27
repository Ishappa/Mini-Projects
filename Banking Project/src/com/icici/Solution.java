package com.icici;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("Welcome to ICICI Bank");
		System.out.println("------------------------");
		Scanner ip=new Scanner(System.in);
		Bank b=new Bankimple(10000);
		
		while(true) {
			System.out.println("Enter 1 for Deposit\nEnter 2 for Withdrawn\nEnter 3 for Check the Balance\nEnter 4 for Exit");
			int Option=ip.nextInt();
			switch(Option)
			{
			
			case 1:
				System.out.println("Enter the Deposite Amount");
				int amount=ip.nextInt();
				b.deposit(amount);//b.deposite(ip.nextInt());
				break;
				
			case 2:
				System.out.println("Enter the Withdrawn Amount ");
				int amount1=ip.nextInt();//b.Withdrwan(ip.nextInt));
				b.withdraw(amount1);
				break;
				
			case 3:
				System.out.println("Balanced Amount"+b.getBalance());
				break;
				
			case 4:
				System.out.println("Thank You!! Visit Again");
				System.exit(0);
				
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(InvalidChoiceException e) 
				{
					System.out.println(e.getMessage());
				}
				 
			}
		}
	}
}
