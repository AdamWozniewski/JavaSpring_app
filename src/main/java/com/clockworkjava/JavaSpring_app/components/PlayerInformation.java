package com.clockworkjava.JavaSpring_app.components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlayerInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private boolean enabled;

    public PlayerInformation(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public PlayerInformation() {

    }

    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
