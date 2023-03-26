package com.account.service;

import com.account.dto.DebitRequestObject;
import com.account.entity.Account;
import com.account.entity.User;
import com.account.repository.AccountRepository;
import com.account.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class DebitService {
    UserRepository userRepository;
    AccountRepository accountRepository;
    @Autowired
    public DebitService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository=accountRepository;
    }

    public String debit(DebitRequestObject request) {
        log.info("Inside DebitService::debit" +request);
        Account account = null;
        User user = null;
        user = userRepository.findByUserId(request.getUserId());
        if (user == null) {
            return "User " + request.getUserId() + " not found";
        }
        account = user.getAccount();
        if (account.getBalance() - request.getAmount() < 0) {
            return "You exceded beyond your limit";
        }
        account.setBalance(account.getBalance() - request.getAmount());
        accountRepository.save(account);
        return "Your account is Debited with Credit Amount" + request.getAmount();
    }
}
