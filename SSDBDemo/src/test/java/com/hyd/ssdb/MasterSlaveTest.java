package com.hyd.ssdb;

import com.hyd.ssdb.conf.Server;

import java.util.Arrays;
import java.util.List;

/**
 * (description)
 * created at 15-12-4
 *
 * @author Yiding
 */
public class MasterSlaveTest {

    public static void main(String[] args) {

        List<Server> servers = Arrays.asList(
                new Server("192.168.239.132", 8888, null, true),  // 主服务器
                new Server("192.168.239.132", 8888, null, false)  // 从服务器
        );

        SsdbClient client = new SsdbClient(servers);
        client.set("name", "hydrogen-ssdb");
        System.out.println(client.get("name"));
    }
}
