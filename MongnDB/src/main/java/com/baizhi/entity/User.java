package com.baizhi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by ljf on 2017/7/1.
 */
@Document(collection = "t_user")
public class User implements Serializable
{
    @Id
    private String id;
    private String name;
    private String paw;

    public User() {
    }

    public User(String name, String paw) {
        this.name = name;
        this.paw = paw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", paw='" + paw + '\'' +
                '}';
    }
}
