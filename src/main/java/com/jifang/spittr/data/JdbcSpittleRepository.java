package com.jifang.spittr.data;

import com.jifang.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * author: jifang
 * date: 18-4-8 上午9:43
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcSpittleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query(
                "select id, message, create_at " +
                        "from Spittle " +
                        "where id < ? " +
                        "order by create_at desc limit 20",
                new SpittleRowMapper(), max
        );
    }

    public Spittle findOne(long spittleId) {
        return jdbc.queryForObject(
                "select id, message, create_at " +
                        "from Spittle " +
                        "where id = ?",
                new SpittleRowMapper(), spittleId
        );
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {

        public Spittle mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spittle(
                    resultSet.getLong("id"),
                    resultSet.getString("message"),
                    resultSet.getDate("create_at")
            );
        }
    }
}
