package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by ljf on 2017/6/13.
 */
public class Choose implements Serializable{
    private boolean temp;

    public Choose(boolean temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Choose{" +
                "temp=" + temp +
                '}';
    }

    public Choose() {
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }
}
