package com.jifang.spittr.model;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * author: jifang
 * date: 18-4-6 下午3:46
 */

public class Spitter {
    @NotNull
    @Size(min = 5, max = 10)
    private String username;
    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
