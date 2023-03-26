package com.account.service;

import com.account.dto.RequestObject;
import com.account.entity.Account;
import com.account.entity.User;
import com.account.repository.AccountRepository;
import com.account.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CreditService {
    UserRepository userRepository;
    AccountRepository accountRepository;
    @Autowired
    public CreditService(UserRepository userRepository,AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository=accountRepository;
    }

    public String credit(RequestObject request) {
        log.info("Indside CreditService::credit "+request);
        Account account = null;
        User user = null;
        user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return "User " + request.getUserId() + " not found";
        }
        account = user.getAccount();
        if (account.getBalance() + request.getAmount() >= 100_000_00) {
            return "You exceded beyond your limit";
        }
        account.setBalance(account.getBalance() + request.getAmount());
        accountRepository.save(account);
        return "Your account is Credited with Credit Amount" + request.getAmount();
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<User> getUsers() {
       return userRepository.findAll();
    }
}
