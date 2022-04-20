package edu.missouriwestern.agrant4.bankingapplication.classes;

import com.opencsv.bean.CsvBindByName;
import javafx.scene.control.Alert;

public class Savings {
    @CsvBindByName(column = "account_id")
    private String accountId;

    @CsvBindByName(column = "account_balance")
    private double accountBalance;

    @CsvBindByName(column = "interest_rate")
    private double interestRate;

    @CsvBindByName(column = "account_open_date")
    private String accountOpenDate;

    @CsvBindByName(column = "due_date") private String dueDate;

    public Savings(String accountId, double account_balance, double interestRate, String accountOpenDate, String dueDate){
        this.accountId = accountId;
        this.accountBalance = account_balance;
        this.interestRate = interestRate;
        this.accountOpenDate = accountOpenDate;
        this.dueDate = dueDate;
    }
    public Savings(){
    }

    //___________Getters___________
    public String getAccountId() {
        return accountId;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public String getAccountOpenDate() {
        return accountOpenDate;
    }
    public String getDueDate() {
        return dueDate;
    }

    //___________Setters___________
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void deposit(double cashAmount) {
        this.accountBalance += cashAmount;
    }

    public Boolean withdraw(double cashAmount) {
        if(this.accountBalance >= cashAmount) {
            this.accountBalance -= cashAmount;
            return true;
        } else {
            // create an alert
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Not enough money.");
            a.setHeaderText("Withdraw not processed.");
            a.setContentText("Not enough money in account.");

            // show the dialog
            a.show();

            return false;
        }
    }

    @Override
    public String toString() {
    return "account ID='" + accountId + '\'' +
        ", account balance='" + accountBalance + '\'' +
        ", interest rate='" + interestRate + '\'' +
        ", account open date='" + accountOpenDate + '\'' +
        ", due date='" + dueDate;
  }
}
