package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ljf on 2017/6/20.
 */
public class Role implements Serializable{
    private String id;
    private String role;
    private String userid;
    private List<Permission> permissions;
    public Role() {
    }

    public Role(String id, String role, String userid, List<Permission> permissions) {
        this.id = id;
        this.role = role;
        this.userid = userid;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", userid='" + userid + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
