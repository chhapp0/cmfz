package com.baizhi.test;

import com.baizhi.SnowflakeIdWorker;

/**
 * Created by ljf on 2017/6/12.
 */
public class Test1 {
    public static void main(String[] args) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long id = idWorker.nextId();
        String id2 = String.valueOf(id);
        System.out.println(id2);
    }
}
