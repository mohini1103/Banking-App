package com.bank.dao;

public class AccountDao {
	private Long id;
	private String accountHolderName;
	private Double balance;

	public AccountDao() {
	}

	public AccountDao(Long id, String accountHolderName, Double balance) {
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
