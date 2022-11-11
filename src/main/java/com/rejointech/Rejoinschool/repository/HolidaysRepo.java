package com.rejointech.Rejoinschool.repository;

import com.rejointech.Rejoinschool.model.Holidays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidaysRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Holidays> findAllHolidays(){
        String sql="SELECT * FROM HOLIDAYS";
        var rowMapper= BeanPropertyRowMapper.newInstance(Holidays.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
