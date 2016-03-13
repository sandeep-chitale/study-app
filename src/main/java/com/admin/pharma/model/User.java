package com.admin.pharma.model;


import com.admin.pharma.enums.UserType;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;

import java.io.Serializable;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 * Created by DELL on 11/29/2015.
 */
@Getter
@Setter
//@Entity
@EnableCaching
public class User implements Serializable{
//    @Id
//    @NotNull
//    @Size(max = 64)
//    @Column(name = "id", nullable = false, updatable = false)
    private String id;

//    @NotNull
//    @Size(max = 64)
//    @Column(name = "password", nullable = false)
    private String password;

    private UserType type = UserType.NORMAL_USER;

    public User() {
    }
    public User(String id,String password,UserType type) {
        this.id = id;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("password", password)
                .toString();
    }
}
