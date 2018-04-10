package com.jifang.spittr.model;

import java.util.Map;

/**
 * author: jifang
 * date: 18-4-9 下午3:27
 */

public class SpitterMapForm {
    private Map<Integer, Spitter> spitters;

    public Map<Integer, Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(Map<Integer, Spitter> spitters) {
        this.spitters = spitters;
    }

    @Override
    public String toString() {
        return "SpitterMapForm{" +
                "spitters=" + spitters +
                '}';
    }
}
