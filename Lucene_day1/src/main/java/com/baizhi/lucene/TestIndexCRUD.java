package com.baizhi.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

public class TestIndexCRUD {
	public static void main(String[] args) throws IOException {
		//testUpdate();
		//testInfo();
		//testUnDelete();
	}
	/**
	 * 更新
	 * @throws IOException
	 */
	public static void testUpdate() throws IOException{
		//1.指定索引目录
		Directory directory=FSDirectory.open(new File("index"));
		//2.创建IndexWriteConfig
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_35, analyzer);
		//3.创建IndexWriter
		IndexWriter indexWriter=new IndexWriter(directory, config);
		
		Document document=new Document();
		document.add(new Field("id", "1", Store.YES, Index.NO));
		document.add(new Field("title", "Corejava 21 day", Store.YES, Index.ANALYZED));// corejava | 21 | day
		document.add(new Field("author", "huxz", Store.YES, Index.ANALYZED));// 胡鑫喆
		document.add(new Field("content", "这是一本好书，奋斗吧骚年！加油", Store.NO, Index.ANALYZED));//这 |是|一|本|好|书|奋|斗|吧|骚|年
		document.add(new Field("path", "hdfs://CentOS/9000/books/芝麻开门.pdf", Store.YES, Index.NO));
		
		indexWriter.updateDocument(new Term("author","胡鑫喆"), document);
		
		//释放资源
		indexWriter.commit();
		indexWriter.close();
	}
	/**
	 * 查看索引库信息
	 * @throws IOException
	 */
	public static void testInfo() throws IOException{
		//1.指定索引目录
		Directory directory=FSDirectory.open(new File("index"));
		IndexReader indexReader=IndexReader.open(directory);
		//含有.del 数据
		int numDeletedDocs = indexReader.numDeletedDocs();
		int numDocs = indexReader.numDocs(); //有效的文档数目 
		int maxDoc = indexReader.maxDoc();//总共的数据包含删除的doc
		
		System.out.println(numDeletedDocs+","+numDocs+","+maxDoc);
		
		indexReader.close();
	}
	/**
	 * 撤销删除的文档
	 * @throws IOException
	 */
	public static void testUnDelete() throws IOException{
		//1.指定索引目录
		Directory directory=FSDirectory.open(new File("index"));
		IndexReader indexReader=IndexReader.open(directory, false);
		//恢复删除数据 前提 含有.del文件
		indexReader.undeleteAll();
		
		indexReader.close();
	}
	/**
	 * 如果一个段Segments中还有可用的document，那么删除的document是可以恢复的
	 * @throws IOException
	 */
	public static void testDelete() throws IOException{
		//1.指定索引目录
		Directory directory=FSDirectory.open(new File("index"));
		//2.创建IndexWriteConfig
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_35, analyzer);
		//3.创建IndexWriter
		IndexWriter indexWriter=new IndexWriter(directory, config);
		
		indexWriter.deleteDocuments(new Term("author","胡鑫喆"));
		
		//提交关闭资源
		indexWriter.commit();
		indexWriter.close();
	}
	/**
	 * 索引段优化 合并索引段 ，每一次开启关闭indexWriter都会产生新的Segments
	 * */
	public static void testOptimized() throws IOException{
		//1.指定索引目录
		Directory directory=FSDirectory.open(new File("index"));
		//2.创建IndexWriteConfig
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_35, analyzer);
		//3.创建IndexWriter
		IndexWriter indexWriter=new IndexWriter(directory, config);
		
		//indexWriter.forceMerge(1);
	    indexWriter.forceMergeDeletes();//  删除 已经被删除过的document 
		indexWriter.commit();
		indexWriter.close();
	}
}
