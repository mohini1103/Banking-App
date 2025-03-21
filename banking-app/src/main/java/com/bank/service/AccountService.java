package com.bank.service;

import java.util.List;

import com.bank.dao.AccountDao;
import com.bank.entity.Account;

public interface AccountService {

	AccountDao createAccount(AccountDao accountDao);
	List<AccountDao> getAllAccounts();
	AccountDao updateAccount(Long id, AccountDao accountDao);
	void deleteAccount(Long id);
	AccountDao getAccountById(Long id);
}
