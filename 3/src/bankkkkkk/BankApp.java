package bankkkkkk;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class BankApp {
	
	public static void main(String[] args) throws IOException {
		AccountDB db = new AccountDB();
		Scanner sc=new Scanner(System.in);
	    String inputAccount="y";
	    
		System.out.println(AccountDB.filename);
		HashMap<String,Account> accMap = db.getAllAccounts();
  
		// sc.nextInt();
		System.out.println("do u want to input account?(y/n)?");
		System.out.println("size before input = "+accMap.size());
		inputAccount=sc.nextLine();
		if (inputAccount.equals("y")) {
			inputAccount(accMap);
			db.saveAccountToFile(accMap);
		}
		//for test
		System.out.println("size after input = " + accMap.size());
		
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		System.out.println("pls enter the account# for transactions");
		String accNum = sc.next();
		sc.nextLine();
		processTransactions(accNum, accMap);

		
	}

	public static void inputAccount(HashMap<String,Account> accMap){
		
		
		Scanner sc=new Scanner(System.in);
		String accNum="woshigou";
		String jixu="y";
		while(jixu.equals("y")){
			
			Account acc=new Account();
			
			System.out.println("pls input the account number");
		    accNum=sc.nextLine();
		    if(accMap.containsKey(accNum)){
		    	System.out.println("the accountNum is already exist. Balance ="+accMap.get(accNum).getBalance());
		    }else{
		    	acc.setAcctNumber(accNum);
				System.out.println("pls input the account name");
				acc.setName(sc.nextLine());
				System.out.println("pls input the account balance");
				acc.setBalance(sc.nextDouble());
				System.out.println("do u want to enter another account(y/n))");
				jixu=sc.next();
				sc.nextLine();
//				System.out.println("account is closed or not (true for closed/false for not closed)");
//				acc.setClosed(sc.nextBoolean());
				accMap.put(accNum, acc);
		    }
		
		}
//		System.out.println("acctbalance of the accountNum"+accNum+"= "+accMap.get(accNum).getBalance());
		
	}
	
	private static void processTransactions(String accNum, HashMap<String, Account> accMap) {
		
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		
		while(!accMap.containsKey(accNum)){
			System.out.println("the account is not found, pls reenter");
			accNum=sc.next();
			sc.nextLine();
		}
		Account currAcc=accMap.get(accNum);
		
		if(currAcc.isClosed()){
			System.out.println("the account is closed");
		}else{
			System.out.println("the current balance is ="+currAcc.getBalance());
			System.out.print("Please Enter a transaction type (check, deposit, "
					+ "or close) or -1 to finish ");
			String tranType=sc.next();
			sc.nextLine();
			accMap = processOneTransaction(accMap,tranType,currAcc);
		}
		
	}


	private static HashMap<String, Account> processOneTransaction(HashMap<String, Account> accMap, String tranType, Account currAcc) {
		// TODO Auto-generated method stub
		if(tranType.equals("close")){
			if(currAcc.getBalance()==0){
				//close the account
				closeAcc(accMap,currAcc);
			}
			else{
				System.out.println("account number:"+currAcc.getAcctNumber()+" can't be closed");
			}
		}
		return null;
	}


	private static void closeAcc(HashMap<String,Account> accMap, Account currAcc) {
		// TODO Auto-generated method stub
		currAcc.setClosed(true);
		accMap.put(currAcc.getAcctNumber(), currAcc);
		AccountDB db = new AccountDB();
		db.saveAccountToFile(accMap);
		System.out.println(currAcc.getAcctNumber()+" has been closed");
	}
}









