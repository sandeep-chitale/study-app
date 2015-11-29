package com.admin.pharma.Util;


import com.admin.pharma.enums.UserType;
import com.admin.pharma.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private static final String ID = "id";
    private static final String PASSWORD = "password";

    private UserUtil() {
    }

    public static User createUser() {
        return new User(ID, PASSWORD, UserType.NORMAL_USER);
    }

    public static List<User> createUserList(int howMany) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            userList.add(new User(ID + "#" + i, PASSWORD,UserType.NORMAL_USER));
        }
        return userList;
    }

}
