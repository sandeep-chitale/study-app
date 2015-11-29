package com.admin.pharma.repository;

import com.admin.pharma.model.User;

import java.util.List;

/**
 * Created by DELL on 11/29/2015.
 */
//Not being use
public interface IUserRepo {
    boolean saveUser(User user);
    User getUser(String userID,String password);
    List<User> getAllUsers();

}
