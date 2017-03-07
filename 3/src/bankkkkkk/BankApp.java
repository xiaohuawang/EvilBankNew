package bankkkkkk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BankApp {
	
	

	public static void main(String[] args) throws IOException {
		AccountDB db = new AccountDB();
	
		System.out.println(AccountDB.filename);
		HashMap<String, Account> accMap = db.getAllAccounts();
  
		// sc.nextInt();
		inputAccount(accMap);
		db.saveAccountToFile(accMap);
	}

	public static void inputAccount(HashMap<String,Account> accMap){
		
		
		Scanner sc=new Scanner(System.in);
		String accNum="woshigou";
		String jixu="y";
		while(jixu.equals("y")){
			
			Account acc=new Account();
			
			System.out.println("pls input the account number");
		    accNum=sc.next();
		    if(accMap.containsKey(accNum)){
		    	System.out.println("the accountNum is already exist. Balance ="+accMap.get(accNum).getBalance());
		    }else{
		    	acc.setAcctNumber(accNum);
				System.out.println("pls input the account name");
				acc.setName(sc.next());
				System.out.println("pls input the account balance");
				acc.setBalance(sc.nextDouble());
				System.out.println("do u want to enter another account(y/n))");
				jixu=sc.next();
//				System.out.println("account is closed or not (true for closed/false for not closed)");
//				acc.setClosed(sc.nextBoolean());
				accMap.put(accNum, acc);
		    }
		
		}
//		System.out.println("acctbalance of the accountNum"+accNum+"= "+accMap.get(accNum).getBalance());
		
	}
}









