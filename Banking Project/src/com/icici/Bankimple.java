package com.icici;

public class Bankimple implements Bank {

	int balance;
	
	 Bankimple(int balance)
	 {
		this.balance=balance;
	 }
	
	@Override
	public void deposit(int amount) 
	{
		System.out.println("Depositing Rs."+ amount);
		balance= balance+amount;
		System.out.println("Amount Deposit Successfully");
		
	}
	
	@Override
	public void withdraw(int amount) 
	{
		System.out.println("Withdrawn RS."+amount);
		if(amount<=balance) {
			
			balance =balance-amount;
			System.out.println("Amount withdrwan Successfully");
		}
		else {
			try
			{
				throw new InvalidBalanceException("Insufficient funds!!..");
			}
			catch(InvalidBalanceException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	@Override
	public int getBalance()
	{
		return balance;
	}
	
}
