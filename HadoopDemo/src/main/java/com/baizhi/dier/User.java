package com.baizhi.dier;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by ljf on 2017/7/6.
 */
public class User implements WritableComparable<User>{
    private String id;
    private String name;
    private boolean sex;
    private int age;

    public User() {
    }

    public User(String id, String name, boolean sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //定制比较规则
    public int compareTo(User o) {
        if(this.age!=o.getAge()){
            return this.age-o.getAge();
        }else if(this.name!=o.getName()){
            return this.name.compareTo(o.getName());
        }
        return this.id.compareTo(o.getId());
    }
    //实现序列化规则
    public void write(DataOutput out) throws IOException {
        out.writeUTF(id);
        out.writeUTF(name);
        out.writeBoolean(sex);
        out.writeInt(age);
    }
    //反序列化
    public void readFields(DataInput in) throws IOException {
        this.id=in.readUTF();
        this.name=in.readUTF();
        this.sex=in.readBoolean();
        this.age=in.readInt();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
