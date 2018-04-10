package com.jifang.spittr.model;

/**
 * author: jifang
 * date: 18-4-6 下午3:44
 */

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;

    public Spittle(String message, Date time) {
        this(null, message, time);
    }

    public Spittle(Long id, String message, Date time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, new String[]{"id", "time"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"id", "time"});
    }
}

