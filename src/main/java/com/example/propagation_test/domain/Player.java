package com.example.propagation_test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private long playerId;

    private String nickName;

    protected Player() {}

    public static Player of () {
        return new Player();
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
