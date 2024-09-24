package com.hexaware.cozyhaven.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.model.Customer;

@Repository
public class CustomerDAO {

    @Autowired  
    JdbcTemplate jdbc;  

    public String authenticate(String user, String pwd) {
        String cmd = "select count(*) cnt from Customers where UserName=? AND Password=?";
        List<Integer> countList = jdbc.query(cmd, new Object[]{user, pwd}, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("cnt");
            }
        });
        return countList.isEmpty() ? "0" : countList.get(0).toString();
    }

    public Customer searchByCustomerUser(String user) {
        String cmd = "select * from Customers where UserName=?";
        List<Customer> customerList = jdbc.query(cmd, new Object[]{user}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setCustomerid(rs.getInt("customerid"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getLong("phone"));
                customer.setGender(rs.getString("gender"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                return customer;
            }
        });
        return customerList.isEmpty() ? null : customerList.get(0);
    }
}
