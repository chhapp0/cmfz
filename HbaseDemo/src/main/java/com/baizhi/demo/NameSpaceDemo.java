package com.baizhi.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ljf on 2017/7/9.
 */
public class NameSpaceDemo {
    private Admin admin;

    @Before
    public void before() throws IOException {
        Configuration conf = new Configuration();
        conf.set("hbase.zookeeper.quorum", "cent");
        Connection conn = ConnectionFactory.createConnection(conf);
        admin = conn.getAdmin();
    }

    @Test
    public void testListNameSpace() throws IOException {
        NamespaceDescriptor[] nds = admin.listNamespaceDescriptors();
        for (NamespaceDescriptor ns : nds
                ) {
            System.out.println(ns.getName());
        }
    }

    /**
     * 只能删除为空的数据
     */
    @Test
    public void testDelete() throws IOException {
        admin.deleteNamespace("baizhi");
        System.out.println("执行了吗");
    }
    @Test
    public void tesrCreate() throws IOException {
        NamespaceDescriptor build = NamespaceDescriptor.create("zpark").addConfiguration("user", "liujf").build();
        admin.createNamespace(build);
        System.out.println("执行了吧？");

    }
}
