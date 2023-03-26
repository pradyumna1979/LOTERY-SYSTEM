package com.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
