package com.account;

import com.account.entity.Account;
import com.account.entity.User;
import com.account.repository.AccountRepository;
import com.account.repository.UserRepository;
import com.account.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class AccountCreditApplication implements CommandLineRunner {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(AccountCreditApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account();
		account.setAccountId(1);
		account.setBalance(5000);
		accountRepository.save(account);
		User user1 = new User(1,"Mohit",account);
		userRepository.save(user1);
	}

}
