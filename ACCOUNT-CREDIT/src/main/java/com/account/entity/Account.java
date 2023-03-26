package com.account.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private  double balance;

    public Account(long accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> users;
}
