package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "staff_details")
public class Staff_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    @Column(nullable = false, length = 45)
    private String password;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Customer_details> customers;

    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}