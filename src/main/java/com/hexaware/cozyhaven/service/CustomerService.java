package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dao.CustomerDAO;
import com.hexaware.cozyhaven.model.Customer;
import com.hexaware.cozyhaven.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private CustomerDAO dao;

    public String authenticate(String user, String pwd) {
        return dao.authenticate(user, pwd);
    }

    public Customer search(int customerId) {
        return repo.findById(customerId).orElse(null);
    }

    public List<Customer> showCustomer() {
        return repo.findAll();
    }

    public Customer searchByUserName(String user) {
        return dao.searchByCustomerUser(user);
    }

    public void customerUpdate(Customer customerNew) {
        repo.save(customerNew);
    }
}
