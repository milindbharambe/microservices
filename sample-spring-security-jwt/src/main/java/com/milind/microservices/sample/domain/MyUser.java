package com.milind.microservices.sample.domain;

import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public MyUser() {
        // TODO Auto-generated constructor stub
    }

    public MyUser(int id, String userName, String password, String role) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmpUser [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public List<String> getAllRoles() {
        List<String> roleList = null;
        if (role != null) {
            String[] arr = role.split(",");
            roleList = Arrays.asList(arr);
        }
        return roleList;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
