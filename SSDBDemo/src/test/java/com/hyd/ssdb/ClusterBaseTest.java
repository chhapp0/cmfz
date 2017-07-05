package com.hyd.ssdb;

import com.hyd.ssdb.conf.Cluster;
import com.hyd.ssdb.sharding.ConsistentHashSharding;
import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

/**
 * (description)
 * created at 16/08/05
 *
 * @author yiding_he
 */
public class ClusterBaseTest {

    protected SsdbClient ssdbClient;

    @Before
    public void init() {
        this.ssdbClient = new SsdbClient(new ConsistentHashSharding(Arrays.asList(
                Cluster.fromSingleServer("192.168.239.132", 8888),
                Cluster.fromSingleServer("192.168.239.132", 8888)
        )));
    }

    @After
    public void finish() {
        this.ssdbClient.close();
    }

}
