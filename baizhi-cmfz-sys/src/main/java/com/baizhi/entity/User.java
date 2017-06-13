package com.baizhi.entity;

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
public class User {
    private String id;

    private String nickname;

    private String farmington;

    private String gender;

    private String description;

    private String phone;

    private String salt;

    private String pwd;

    private String photo;
    private Guru guru;

    private Province province;

    private City city;

    private Work work;

    public User() {
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

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "User{" +
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
                ", province=" + province +
                ", city=" + city +
                ", work=" + work +
                '}';
    }

    public User(String id, String nickname, String farmington, String gender, String description, String phone, String salt, String pwd, String photo, Guru guru, Province province, City city, Work work) {
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
        this.province = province;
        this.city = city;
        this.work = work;
    }
}