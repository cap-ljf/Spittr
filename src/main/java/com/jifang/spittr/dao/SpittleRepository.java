package com.jifang.spittr.dao;

import com.jifang.spittr.model.Spittle;

import java.util.List;

/**
 * author: jifang
 * date: 18-4-6 下午3:43
 */

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
