package com.bank.mapper;

import com.bank.dao.AccountDao;
import com.bank.entity.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public static Account mapToAccount(AccountDao accountDao) {
        if (accountDao == null) return null;
        return new Account(accountDao.getId(), accountDao.getAccountHolderName(), accountDao.getBalance());
    }

    public static AccountDao mapToAccountDao(Account account) {
        if (account == null) return null;
        return new AccountDao(account.getId(), account.getAccountHolderName(), account.getBalance());
    }
}
