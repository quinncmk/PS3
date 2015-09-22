package MainPackage;
import java.util.Date;;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dataCreated;
	
	Account(){
	}
	
	Account(int specifiedId, double initialBalance){
		this.id = specifiedId;
		this.balance = initialBalance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDataCreated() {
		dataCreated = new Date();
		return dataCreated;
	}
	
	double getMonthlyInterestRate() {
		double monthlyInterestRate = this.getAnnualInterestRate() / 12;
		return monthlyInterestRate;
	}
	
	double withdraw(double amountOfWithdraw) 
		throws InsufficientFundsException {
		if (amountOfWithdraw < this.balance) {
			this.balance = this.getBalance() - amountOfWithdraw;
		}
		else {
			double needs = amountOfWithdraw - balance;
			throw new InsufficientFundsException(needs);
		}
		return this.balance;
	}
	
	double deposits(double amountOfDeposit) {
		this.balance = this.getBalance() + amountOfDeposit;
		return this.balance;
	}
	
}
