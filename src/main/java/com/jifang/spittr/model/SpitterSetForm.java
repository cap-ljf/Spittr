package com.jifang.spittr.model;

import java.util.HashSet;
import java.util.Set;

/**
 * author: jifang
 * date: 18-4-9 下午3:22
 */

public class SpitterSetForm {
    private Set<Spitter> spitters = new HashSet<Spitter>();

    public SpitterSetForm() {
        spitters.add(new Spitter());
        spitters.add(new Spitter());
        spitters.add(new Spitter());
    }

    @Override
    public String toString() {
        return "SpitterSetForm{" +
                "spitters=" + spitters +
                '}';
    }

    public Set<Spitter> getSpitters() {
        return spitters;
    }

    public void setSpitters(Set<Spitter> spitters) {
        this.spitters = spitters;
    }
}
