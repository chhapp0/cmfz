package com.baizhi.entity;

import java.util.List;

/**
 * 用户表
 *  id                   varchar(40)                    not null,
 nickname             varchar(80),
 farmington           varchar(80),
 gender               varchar(10),
 description          varchar(200),
 phone                varchar(20),
 salt                 varchar(10),
 pwd                  varchar(40),
 photo                varchar(200),
 tid                  varchar(40),
 province             varchar(40),
 city                 varchar(40),
 */
public class UserDATA {
    private String id;

    private String nickname;

    private String farmington;

    private String gender;

    private String description;

    private String phone;

    private String salt;

    private String pwd;

    private String photo;
    private GuruDATA guru;

    private Province  ppid;
    private String province;
    private City ccid;
    private String  city;
    private List<Work> work;
    private String location;
    public UserDATA() {
    }

    public UserDATA(String id, String nickname, String farmington, String gender, String description, String phone, String salt, String pwd, String photo, GuruDATA guru, Province ppid, String province, City ccid, String city, List<Work> work, String location) {
        this.id = id;
        this.nickname = nickname;
        this.farmington = farmington;
        this.gender = gender;
        this.description = description;
        this.phone = phone;
        this.salt = salt;
        this.pwd = pwd;
        this.photo = photo;
        this.guru = guru;
        this.ppid = ppid;
        this.province = province;
        this.ccid = ccid;
        this.city = city;
        this.work = work;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFarmington() {
        return farmington;
    }

    public void setFarmington(String farmington) {
        this.farmington = farmington;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public GuruDATA getGuru() {
        return guru;
    }

    public void setGuru(GuruDATA guru) {
        this.guru = guru;
    }

    public Province getPpid() {
        return ppid;
    }

    public void setPpid(Province ppid) {
        this.ppid = ppid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public City getCcid() {
        return ccid;
    }

    public void setCcid(City ccid) {
        this.ccid = ccid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Work> getWork() {
        return work;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserDATA{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", farmington='" + farmington + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                ", pwd='" + pwd + '\'' +
                ", photo='" + photo + '\'' +
                ", guru=" + guru +
                ", ppid=" + ppid +
                ", province='" + province + '\'' +
                ", ccid=" + ccid +
                ", city='" + city + '\'' +
                ", work=" + work +
                ", location='" + location + '\'' +
                '}';
    }
}