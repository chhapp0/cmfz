package com.hyd.ssdb.file;

import com.hyd.ssdb.SsdbClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * (description)
 * created at 16/04/12
 *
 * @author yidin
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        SsdbClient client = new SsdbClient("192.168.239.132", 8888);
        String key = "D:\\aa\\Hadoop_linux.pdf";
        byte[] bytes = client.getBytes(key);

        File outputFile = new File("C:\\Users\\Administrator\\Desktop/a.pdf");
        FileUtils.writeByteArrayToFile(outputFile, bytes);

        System.out.println("File saved.");
        client.close();
    }
}
