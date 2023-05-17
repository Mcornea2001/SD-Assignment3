package com.example.Assignment3.controller;

import com.example.Assignment3.Service.AdminService;
import com.example.Assignment3.Service.CustomerService;
import com.example.Assignment3.model.Admin;
import com.example.Assignment3.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public List<Admin> getAdmin() {
        return adminService.getAdmin();
    }

    @PostMapping("/add")
    public void registerNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "/delete/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") Long adminId) {
        adminService.deleteAdmin(adminId);
    }

    @PutMapping(path = "/update/{adminId}")
    public void updateAdmin(
            @PathVariable("adminId") Long adminId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        adminService.updateAdmin(adminId, username, password);
    }
}
