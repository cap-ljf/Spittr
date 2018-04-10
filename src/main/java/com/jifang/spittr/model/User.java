package com.jifang.spittr.model;

import com.jifang.spittr.annotation.IntegerRange;

import javax.validation.constraints.NotNull;

/**
 * author: jifang
 * date: 18-4-9 下午2:09
 */

public class User {

    @NotNull
    @IntegerRange(min = 18, max = 100)
    private int age;
    private Spitter spitter;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", spitter=" + spitter +
                '}';
    }
}
