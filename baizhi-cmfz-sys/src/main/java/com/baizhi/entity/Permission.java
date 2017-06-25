package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by ljf on 2017/6/20.
 */
public class Permission implements Serializable {
    private String id;
    private String permission;
    private String roleid;

    public Permission() {
    }

    public Permission(String id, String permission, String roleid) {
        this.id = id;
        this.permission = permission;
        this.roleid = roleid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permission='" + permission + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }
}
