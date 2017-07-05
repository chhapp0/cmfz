package com.hyd.ssdb;

import com.hyd.ssdb.conf.Cluster;
import com.hyd.ssdb.conf.Server;
import com.hyd.ssdb.sharding.ConsistentHashSharding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ljf on 2017/6/30.
 */
public class TestCluter {
    public static void main(String[] args) {
        List<Cluster> clusters = new ArrayList<Cluster>();
        List<Server> servers1= Arrays.asList(
                new Server("192.168.239.132",8885,null,true),//主服务器
                new Server("192.168.239.132",8886,null,true)//主服务器
        );
        Cluster cluster1=new Cluster(servers1,100);
        List<Server> servers2=Arrays.asList(
                new Server("192.168.239.132",8887,null, true),//主服务器
                new Server("192.168.239.132",8888,null, true)//主服务器
        );
Cluster cluster2=new Cluster(servers2,100);
        //构建集群成员
        clusters.add(cluster1);
        clusters.add(cluster2);
        ConsistentHashSharding shards = new ConsistentHashSharding(clusters);
        SsdbClient ssdbClient = new SsdbClient(shards);

        for(int i=0;i<10;i++){
           ssdbClient.set("ok"+i,"va"+i);

            System.out.println(ssdbClient.get("jian"+i));
        }
        //ssdbClient.close();
    }
}
