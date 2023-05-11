package com.group.libraryapp.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    public boolean isUserNotExist(JdbcTemplate jdbcTemplate, long id) {
        String readSql = "select * from user where id = ?";
        return  jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(JdbcTemplate jdbcTemplate, String name, String id) {
        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }
}
