package com.baizhi.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/22.
 */
public class TestCreateIndex {
    public static void main(String[] args) throws IOException {
        test();

    }
        public static void  test() throws IOException {
        //指定索引目录
        Directory directory= FSDirectory.open(new File("index"));
        //创建IndexWriterConfig
        Analyzer analyzer=new StandardAnalyzer(Version.LUCENE_35);
        IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_35,analyzer);
        //创建IndexWriter
        IndexWriter indexWriter=new IndexWriter(directory,config);
        //创建Document
        Document document=new Document();
        //构建Field
        document.add(new Field("id","3", Store.YES, Index.NO));
        document.add(new Field("title","一双绣花鞋",Store.YES,Index.ANALYZED));
        document.add(new Field("author","贞子",Store.YES,Index.ANALYZED));
        document.add(new Field("content","送给陈远航",Store.NO,Index.ANALYZED));
        document.add(new Field("price","44.44",Store.YES,Index.NOT_ANALYZED));
        //添加document到索引库
            System.out.println("添加了吗？"+document);
        indexWriter.addDocument(document);
        //提交索引
        indexWriter.commit();  //提交索引，索引变更到磁盘
        //关闭资源
        indexWriter.close();
    }


}
