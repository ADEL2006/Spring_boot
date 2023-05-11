package com.group.libraryapp.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id) {
        String readSql = "select * from user where id = ?";
        return  jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(JdbcTemplate jdbcTemplate, String name, long id) {
        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }
}
