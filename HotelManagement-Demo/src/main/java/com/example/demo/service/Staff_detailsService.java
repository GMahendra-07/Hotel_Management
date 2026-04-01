package com.example.demo.service;

import com.example.demo.entity.Staff_details;
import com.example.demo.repository.Staff_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Staff_detailsService {

    @Autowired
    private Staff_detailsRepository staffRepository;

    // Create or Update Staff
    public Staff_details saveStaff(Staff_details staff) {
        return staffRepository.save(staff);
    }

    // Get all staff
    public List<Staff_details> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get staff by ID
    public Staff_details getStaffById(Integer id) {
        Optional<Staff_details> optional = staffRepository.findById(id);
        return optional.orElse(null);
    }

    // Update staff
    public Staff_details updateStaff(Integer id, Staff_details staffDetails) {
        Staff_details staff = getStaffById(id);

        if (staff != null) {
            staff.setUserName(staffDetails.getUserName());
            staff.setPassword(staffDetails.getPassword());
            return staffRepository.save(staff);
        }
        return null;
    }

    // Delete staff
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }
}
