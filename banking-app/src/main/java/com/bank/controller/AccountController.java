package com.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.bank.dao.AccountDao;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDao> addAccount(@RequestBody AccountDao accountDao) {
        return ResponseEntity.ok(accountService.createAccount(accountDao));
    }

    @GetMapping
    public ResponseEntity<List<AccountDao>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDao> getAccountById(@PathVariable Long id) {

        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDao> updateAccount(@PathVariable Long id, @RequestBody AccountDao accountDao) {
        return ResponseEntity.ok(accountService.updateAccount(id, accountDao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }
}
