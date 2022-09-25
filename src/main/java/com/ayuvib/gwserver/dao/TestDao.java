package com.ayuvib.gwserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getData() {

        String query = "INSERT INTO public.test(value) VALUES(?);";
        int update = this.jdbcTemplate.update(query, 5432);
        return update;
    }

}
