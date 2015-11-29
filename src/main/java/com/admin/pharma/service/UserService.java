package com.admin.pharma.service;

import com.admin.pharma.model.User;

import java.util.List;

/**
 * Created by DELL on 11/29/2015.
 */
public interface UserService {

        boolean  save(User user);

        List<User> getList();

        boolean validateLogin(User user);

       boolean validateID(String id);

    User getUser(String id);
}
