package com.admin.pharma.serviceImpl;

import com.admin.pharma.model.User;
import com.admin.pharma.repository.UserRepository;
import com.admin.pharma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/29/2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean save(User user) {
        return userRepo.saveUser(user);
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public boolean validateLogin(User user) {
        return false;
    }

    @Override
    public boolean validateID(String id) {
        return userRepo.validateID(id);
    }

    @Override
    public User getUser(String id) {
        return userRepo.getUserDetail(id);
    }
}
