package com.hexaware.cozyhaven.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.model.Admin;

@Repository
public class AdminDAO {

    @Autowired  
    JdbcTemplate jdbc;

    public String authenticate(String user, String pwd) {
        String cmd = "select count(*) cnt from Admin where username=? AND password=?";
        List<Integer> str = jdbc.query(cmd, new Object[] { user, pwd }, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("cnt");
            }
        });
        return str.get(0).toString();
    }

    public Admin searchByUser(String user) {
        String cmd = "select * from Admin where username=?";
        List<Admin> adminList = jdbc.query(cmd, new Object[] { user }, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin admin = new Admin();
                admin.setAdminid(rs.getInt("adminid"));
                admin.setAdminname(rs.getString("adminname"));
                admin.setCity(rs.getString("city"));
                admin.setEmail(rs.getString("email"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setMobile(rs.getLong("mobile"));
                return admin;
            }
        });
        return adminList.isEmpty() ? null : adminList.get(0);
    }
}
