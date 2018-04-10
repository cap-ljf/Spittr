package com.jifang.spittr.model;

import java.util.List;

/**
 * author: jifang
 * date: 18-4-9 下午3:11
 */

public class SpitterListForm {
    private List<Spitter> spitters;

    public List<Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(List<Spitter> spitters) {
        this.spitters = spitters;
    }

    @Override
    public String toString() {
        return "SpitterListForm{" +
                "spitters=" + spitters +
                '}';
    }
}
