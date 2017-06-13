package com.baizhi.entity;

import java.util.List;

/**
 * Created by ljf on 2017/6/13.
 */
public class Menu {
    private String id;
    private String name;
    private String iconcls;
    private String href;
    private String level;
    private List<Menu> menu;

    public Menu() {
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

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public Menu(String id, String name, String iconcls, String href, String level, List<Menu> menu) {
        this.id = id;
        this.name = name;
        this.iconcls = iconcls;
        this.href = href;
        this.level = level;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", href='" + href + '\'' +
                ", level='" + level + '\'' +
                ", menu=" + menu +
                '}';
    }
}
