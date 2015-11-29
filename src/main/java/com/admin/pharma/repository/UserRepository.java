package com.admin.pharma.repository;

import com.admin.pharma.Util.UserUtil;
import com.admin.pharma.enums.UserType;
import com.admin.pharma.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by DELL on 11/29/2015.
 */
@Repository
@Getter
public class UserRepository implements IUserRepo{
    String saveUser = "INSERT INTO ADMIN " +
            "(id, password, userType) VALUES (?, ?, ?)";

    String validateID = "SELECT ID FROM  ADMIN WHERE ID = ?";

    String getUser = "SELECT * FROM  ADMIN WHERE ID = ?";
    @Autowired
    private DataAccessLayer dbAccess;

    public UserRepository(){
    }
    @Override
    public boolean saveUser(User user) {
        JdbcTemplate template = dbAccess.getJDBCTemplate();
        //to add many users
//        for(User user1:UserUtil.createUserList(500)){
//            template.update(saveUser,new Object[]{user1.getId(),user1.getPassword(),user1.getType().name()});
//        }

        template.update(saveUser,new Object[]{user.getId(),user.getPassword(),user.getType().name()});
        return true;
    }

    @Override
    public User getUser(String userID, String password) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    public boolean validateID(String id) {
        JdbcTemplate template = dbAccess.getJDBCTemplate();
        // (query, QueryParam,RowMapper (returns the result set)

        List<String> ids = template.query(validateID, new Object[]{id}, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return  resultSet.getString("ID");
            }
        });

        return (ids.size() > 0) ? false : true;
    }

    public User getUserDetail(String id) {
        JdbcTemplate template = dbAccess.getJDBCTemplate();
        // (query, QueryParam,RowMapper (returns the result set)

        List<User> ids = template.query(getUser, new Object[]{id}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return  new User(resultSet.getString("ID"),resultSet.getString("PASSWORD"), UserType.valueOf(resultSet.getString("userType")));
            }
        });
        return ids.get(0);
    }
}
