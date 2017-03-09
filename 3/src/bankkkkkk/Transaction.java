package bankkkkkk;

import java.util.Date;

public class Transaction {

	private double amount;
	private Date date;
	private boolean isCheck;
	private boolean isOverdraft=false;
	private double beforeBalance;
	private double afterBalance;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public boolean isOverdraft() {
		return isOverdraft;
	}
	public void setOverdraft(boolean isOverdraft) {
		this.isOverdraft = isOverdraft;
	}
	public double getBeforeBalance() {
		return beforeBalance;
	}
	public void setBeforeBalance(double beforeBalance) {
		this.beforeBalance = beforeBalance;
	}
	public double getAfterBalance() {
		return afterBalance;
	}
	public void setAfterBalance(double afterBalance) {
		this.afterBalance = afterBalance;
	}

}
