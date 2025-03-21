package com.bank.service.Impli;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountDao;
import com.bank.entity.Account;
import com.bank.mapper.AccountMapper;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDao createAccount(AccountDao accountDao) {
		// Convert AccountDao to Account entity
		Account account = AccountMapper.mapToAccount(accountDao);

		// Convert back to AccountDao and return
		return AccountMapper.mapToAccountDao(accountRepository.save(account));
	}

	@Override
	public List<AccountDao> getAllAccounts() {
		return accountRepository.findAll().stream().map(AccountMapper::mapToAccountDao).collect(Collectors.toList());
	}

	@Override
	public AccountDao getAccountById(Long id) {
		return accountRepository.findById(id).map(AccountMapper::mapToAccountDao).orElse(null);
	}

	@Override
	public AccountDao updateAccount(Long id, AccountDao accountDao) {
		return accountRepository.findById(id).map(existingAccount -> {
			existingAccount.setAccountHolderName(accountDao.getAccountHolderName());
			existingAccount.setBalance(accountDao.getBalance());
			return AccountMapper.mapToAccountDao(accountRepository.save(existingAccount));
		}).orElse(null);
	}

	@Override
	public void deleteAccount(Long id) {

		accountRepository.deleteById(id);
	}

	

}
