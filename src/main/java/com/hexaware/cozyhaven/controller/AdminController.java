package com.hexaware.cozyhaven.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cozyhaven.model.Admin;
import com.hexaware.cozyhaven.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/showAdmin")
    public List<Admin> showAdmin() {
        return adminService.showAdmin();
    }

    @PostMapping(value = "/addAdmin")
    public void addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
    }

    @RequestMapping("/adminAuthenticate/{user}/{pwd}")
    public String authenticate(@PathVariable String user, @PathVariable String pwd) {
        return adminService.authenticate(user, pwd);
    }

    @RequestMapping("/searchByUser/{userName}")
    public ResponseEntity<Admin> searchByUserName(@PathVariable String userName) {
        try {
            Admin admin = adminService.searchByUserName(userName);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
