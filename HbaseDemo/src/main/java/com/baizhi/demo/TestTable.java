package com.baizhi.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by ljf on 2017/7/9.
 */
public class TestTable {
    private Admin admin;
    private Connection conn;
    @Before
    public void before() throws IOException {
        Configuration conf=new Configuration();
        //设置ZK主机
        conf.set("hbase.zookeeper.quorum","cent");
        conf.addResource("hbase-site.xml");
        conn= ConnectionFactory.createConnection();
        admin=conn.getAdmin();
    }
    @Test
    public void testCreate() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        HTableDescriptor tableDescriptor=new HTableDescriptor(tableName);
        //构建列簇
        HColumnDescriptor hColumnDescriptor=new HColumnDescriptor("cf1");
        //最多保存三个cell的版本
        hColumnDescriptor.setMaxVersions(3);
      // hColumnDescriptor.setTimeToLive(100);
        HColumnDescriptor hColumnDescriptor1=new HColumnDescriptor("cf2");
        //最多保存三个cell的版本
        hColumnDescriptor1.setMaxVersions(3);
        //将列簇添加到列表中
        tableDescriptor.addFamily(hColumnDescriptor);
        tableDescriptor.addFamily(hColumnDescriptor1);

        admin.createTable(tableDescriptor);
    }
    @Test
    public void testInsert() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        Table table = conn.getTable(tableName);
        //put rowkey 。 列簇 , 值
        Put put=new Put(Bytes.toBytes("user:10001"));
        //构建数据
        put.addColumn(Bytes.toBytes("cf1"),Bytes.toBytes("name"),Bytes.toBytes("张三"));
        put.addColumn(Bytes.toBytes("cf2"),Bytes.toBytes("age"),Bytes.toBytes("13"));
        //插入数据
        table.put(put);
        //关闭连接和表
        table.close();
    }
    @Test
    public void testUpdate() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        Table table = conn.getTable(tableName);
        //put rowkey 。 列簇 , 值
        Put put=new Put(Bytes.toBytes("user:10001"));
        //构建数据
        put.addColumn(Bytes.toBytes("cf1"),Bytes.toBytes("name"),Bytes.toBytes("zhangs三"));
        put.addColumn(Bytes.toBytes("cf2"),Bytes.toBytes("age"),Bytes.toBytes("23"));
        //插入数据
        table.put(put);
        //关闭连接和表
        table.close();
    }
    @Test
    public void testQueryOne1() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        Table table = conn.getTable(tableName);
        //构建User
        Get get=new Get(Bytes.toBytes("user:10001"));
        get.setMaxVersions(3);//获取所有数据版本
        Result result = table.get(get);
        CellScanner cellScanner = result.cellScanner();
        while (cellScanner.advance()){
            Cell current = cellScanner.current();
            System.out.println(
                    Bytes.toString( CellUtil.cloneFamily(current))+
                            ":"+Bytes.toString(CellUtil.cloneQualifier(current))+
                            ":"+Bytes.toString(CellUtil.cloneValue(current)));
        }
    }

    @Test
    public void testQueryOne3() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        Table table = conn.getTable(tableName);
        //构建User
        Get get=new Get(Bytes.toBytes("user:10001"));
        get.addColumn(Bytes.toBytes("cf2"),Bytes.toBytes("age"));
        get.setMaxVersions();//获取所有数据版本
        Result result = table.get(get);

        //遍历结果
        List<Cell> columnCells = result.getColumnCells(Bytes.toBytes("cf2"), Bytes.toBytes("age"));
        for (Cell c:columnCells
             ) {
            System.out.println(Bytes.toString(CellUtil.cloneFamily(c))+":"+Bytes.toString(CellUtil.cloneQualifier(c))+":"+Bytes.toString(CellUtil.cloneValue(c)));
        }
        //关闭连接和表
        table.close();
    }
    @Test
    public void testQueryMany() throws IOException {
        TableName tableName = TableName.valueOf("zpark:t_user");
        Table table = conn.getTable(tableName);
        //构建scan
        Filter filter=new ColumnPrefixFilter(Bytes.toBytes("na"));
        Scan scan=new  Scan();
        scan.setFilter(filter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result r:scanner){
      /*      List<Cell> cells = r.getColumnCells(Bytes.toBytes("cf1"), Bytes.toBytes("name"));*/
            CellScanner cellScanner = r.cellScanner();
            while (cellScanner.advance()){
                Cell c = cellScanner.current();
                System.out.println(Bytes.toString(CellUtil.cloneFamily(c))+":"+Bytes.toString(CellUtil.cloneQualifier(c))+":"+Bytes.toString(CellUtil.cloneValue(c)));
            }
        }
        //关闭连接
        table.close();
    }



    @After
    public void after() throws IOException {
        conn.close();
        admin.close();
    }
}
