package com.account.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;

    public User(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;
}
