package com.example.demo.controller;

import com.example.demo.entity.Staff_details;
import com.example.demo.service.Staff_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class Staff_detailsController {

    @Autowired
    private Staff_detailsService staffService;

    // Test API
    @GetMapping("/welcome")
    public String welcome() {
        return "Staff Controller is working";
    }

    // Create staff
    @PostMapping("/create")
    public Staff_details createStaff(@RequestBody Staff_details staff) {
        return staffService.saveStaff(staff);
    }

    // Get all staff
    @GetMapping("/all")
    public List<Staff_details> getAllStaff() {
        return staffService.getAllStaff();
    }

    // Get staff by ID
    @GetMapping("/{id}")
    public Staff_details getStaffById(@PathVariable Integer id) {
        return staffService.getStaffById(id);
    }

    // Update staff
    @PutMapping("/update/{id}")
    public Staff_details updateStaff(
            @PathVariable Integer id,
            @RequestBody Staff_details staff) {
        return staffService.updateStaff(id, staff);
    }

    // Delete staff
    @DeleteMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Integer id) {
        staffService.deleteStaff(id);
        return "Staff deleted successfully with id " + id;
    }
}
