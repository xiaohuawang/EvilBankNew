package bankkkkkk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AccountDB {

	public static final String filename = (System.getProperty("user.dir")
			+ File.separatorChar + "src" + File.separatorChar + "account.txt");
	private static final String delimiter = ",";


	public HashMap<String, Account> getAllAccounts() throws IOException {

		// String: acct number
		HashMap<String, Account> accMap = new HashMap<String, Account>();
		File acctFile = new File(filename);
		if (acctFile.exists()) {

			try {
				BufferedReader reader = new BufferedReader(new FileReader(
						acctFile));
				String line = reader.readLine();
				while (line != null) {
					System.out.println(line);
					String parts[] = line.split(",");

					Account curracc = new Account();
					curracc.setAcctNumber(parts[0]);
					curracc.setName(parts[1]);
					curracc.setBalance(Double.parseDouble(parts[2]));
					curracc.setClosed(Boolean.parseBoolean(parts[3]));

					accMap.put(curracc.getAcctNumber(), curracc);

					line = reader.readLine();
				}
            System.out.println();
            
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				// System.out.println(e);
			}
		}
		// else{
		//
		// }
		return accMap;
	}
	
	public void saveAccountToFile(HashMap<String, Account> accMap) {

		PrintWriter writer;

		try {
			writer = new PrintWriter(new File(filename));
			Iterator it = accMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Account currAcc = (Account) pair.getValue();
				// System.out.println("account number= "+currAcc.getAcctNumber());
				// System.out.println("account balance= "+currAcc.getBalance());
				// System.out.println("account name= "+currAcc.getName());
				writer.println(currAcc.getAcctNumber() + delimiter
						+ currAcc.getName() + delimiter + currAcc.getBalance()
						+ delimiter+currAcc.isClosed());
				 
			}
			writer.close();
		} catch (FileNotFoundException e) 
		{	
			e.printStackTrace();
		}
	}
}











































