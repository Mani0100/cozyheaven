package com.hexaware.cozyhaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cozyhaven.dao.AdminDAO;
import com.hexaware.cozyhaven.model.Admin;
import com.hexaware.cozyhaven.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private AdminDAO dao;

    public String authenticate(String user, String pwd) {
        return dao.authenticate(user, pwd);
    }

    public List<Admin> showAdmin() {
        return adminRepo.findAll();
    }

    public void addAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public Admin searchByUserName(String user) {
        return dao.searchByUser(user);
    }
}
