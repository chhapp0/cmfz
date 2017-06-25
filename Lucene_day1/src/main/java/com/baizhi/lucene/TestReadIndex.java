package com.baizhi.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by ljf on 2017/6/22.
 */
public class TestReadIndex {
    public static void main(String[] args) throws IOException {
        select();
    }
    public static  void select() throws IOException {
        //指定目录
        Directory directory= FSDirectory.open(new File("index"));
        //读取索引库
        IndexReader indexReader=IndexReader.open(directory);
        //创建IndexReader
        IndexSearcher indexSearcher=new IndexSearcher(indexReader);
        //创建termQuery
        TermQuery query=new TermQuery(new Term("author","贞"));
        //查询结果TopDocs（这是索引区，不能直接拿到document）
        //查出相似度最高的前5条
        TopDocs topDocs = indexSearcher.search(query, 5);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//返回的scoreDoc[分数和docID]
        //遍历结果
        for (ScoreDoc scoreDoc:scoreDocs
             ) {
            int docID = scoreDoc.doc;
            Document document = indexSearcher.doc(docID);
            System.out.println("这个数据的内容是"+document);
        }
        //关闭资源
        indexSearcher.close();
        indexReader.close();
    }

    public static void delete() throws IOException {
        //指定索引目录
        FSDirectory directory = FSDirectory.open(new File("index"));
        //创建IndexWriterConfig
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35, analyzer);
        //创建IndexWriter
        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.deleteDocuments(new Term("author","贞"));
        //释放资源
        indexWriter.commit();
        indexWriter.close();
    }
    public static void testinfo() throws IOException {
        //指定索引目录
        FSDirectory directory = FSDirectory.open(new File("index"));
        IndexReader indexReader = IndexReader.open(directory);
        //含有.del数据
        int deletedDocs = indexReader.numDeletedDocs();
        System.out.println(deletedDocs);
    }
}
