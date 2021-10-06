package com.codegym.model;

import java.util.Date;

public class User {
    private int id;
    private String username, password, first_name, last_name, address, telephone, email;
    private Date created_at, last_modified_at, delete_at;

    public User(int id, String username, String password, String first_name, String last_name, String address, String telephone, String email, Date created_at, Date last_modified_at, Date delete_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.created_at = created_at;
        this.last_modified_at = last_modified_at;
        this.delete_at = delete_at;
    }


    public User(String username, String password, String first_name, String last_name, String address, String telephone, String email,Date created_at) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.created_at=created_at;
    }

    public User(String password, String first_name, String last_name, String address, String telephone, String email, Date last_modified_at) {
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.last_modified_at = last_modified_at;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getCreated_at() {
        return (java.sql.Date) created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(Date last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

    public Date getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(Date delete_at) {
        this.delete_at = delete_at;
    }

}
