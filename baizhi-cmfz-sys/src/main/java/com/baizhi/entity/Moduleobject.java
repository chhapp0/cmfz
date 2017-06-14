package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ljf on 2017/6/14.
 */
public class Moduleobject<T> implements Serializable{
    private long total;
    private List<T> rows;


    public Moduleobject() {
    }

    public Moduleobject(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Moduleobject{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
