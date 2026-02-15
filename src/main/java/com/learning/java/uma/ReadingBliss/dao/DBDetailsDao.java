package com.learning.java.uma.ReadingBliss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DBDetailsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getDBTables(){
        String tblQry = "SELECT tablename " +
                "FROM pg_tables " +
                "WHERE schemaname = 'public' " +
                "ORDER BY tablename";
        return jdbcTemplate.queryForList(tblQry, String.class);
    }
}
