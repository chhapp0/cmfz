package com.baizhi.controller;

import com.baizhi.entity.Iphone;
import com.baizhi.service.IphoneService;
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
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljf on 2017/6/22.
 */
@Controller
@RequestMapping("/lucene")
public class LuceneController {
    @Resource
    private IphoneService iphoneService;

    @RequestMapping("/add")
    public String insert(Iphone iphone) throws IOException {
        System.out.println(iphone+"+++++++++++++++++++++++++");
        iphone.setFlag(1);
        System.out.println(iphone);
        iphoneService.update(iphone);
        Directory directory = FSDirectory.open(new File("index"));
        //创建IndexWriterConfig
        //Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
        Analyzer analyzer=new IKAnalyzer(true);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35, analyzer);
        //创建IndexWriter
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //创建Document·
        Document document = new Document();
        document.add(new Field("id",iphone.getId(), Store.YES, Index.NO));
        document.add(new Field("name",iphone.getName(), Store.YES,Index.ANALYZED));
        String price = String.valueOf(iphone.getPrice());
        document.add(new Field("price",price,Store.YES, Index.NO));
        document.add(new Field("info",iphone.getInfo(),Store.YES,Index.ANALYZED));
        document.add(new Field("href",iphone.getHref(),Store.YES,Index.NOT_ANALYZED));
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();
        return "redirect:/iphone/selectAll";
        }

      @RequestMapping("/delete")
    public String delete(String href) throws IOException {
          System.out.println(href);
          Iphone iphone = iphoneService.selectHref(href);
          iphone.setFlag(0);
          System.out.println(iphone+"删除时的Iphone");
          iphoneService.update(iphone);
          FSDirectory directory = FSDirectory.open(new File("index"));
          //创建IndexWriterConfig
          StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
          IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35, analyzer);
          //创建IndexWriter
          IndexWriter indexWriter = new IndexWriter(directory, config);
          indexWriter.deleteDocuments(new Term("href",href));
          indexWriter.commit();
          indexWriter.close();
          return "redirect:/iphone/selectAll";
      }
      @RequestMapping("/update")
    public String update(String href) throws IOException {
          Iphone iphone = iphoneService.selectHref(href);
          //1.指定索引目录
          Directory directory=FSDirectory.open(new File("index"));
          //2.创建IndexWriteConfig
          //Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
          Analyzer analyzer=new IKAnalyzer(true);
          IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_35, analyzer);
          //3.创建IndexWriter
          IndexWriter indexWriter=new IndexWriter(directory, config);

          Document document=new Document();
          document.add(new Field("id",iphone.getId(), Store.YES, Index.NO));
          document.add(new Field("name",iphone.getName(), Store.YES,Index.ANALYZED));
          String price = String.valueOf(iphone.getPrice());
          document.add(new Field("price",price,Store.YES, Index.NO));
          document.add(new Field("info",iphone.getInfo(),Store.YES,Index.ANALYZED));
          document.add(new Field("href",iphone.getHref(),Store.YES,Index.NOT_ANALYZED));
          indexWriter.updateDocument(new Term("href",iphone.getHref()),document);

          //释放资源
          indexWriter.commit();
          indexWriter.close();
          return "redirect:/iphone/selectAll";
      }

      @RequestMapping("/selectOne")
    public String selectAll(HttpServletRequest request,String name) throws IOException, InvalidTokenOffsetsException {
          List<Iphone> list = new ArrayList<Iphone>();
          Analyzer analyzer=new IKAnalyzer(true);
          //1.指定目录
          Directory directory = FSDirectory.open(new File("index"));
          //2.读取索引库
          IndexReader indexReader = IndexReader.open(directory);
          //3.创建IndexSearcher
          IndexSearcher indexSearcher = new IndexSearcher(indexReader);
          //4.创建Query （FuzzyQuery、PhraseQuery、WildcardQuery、PrefixQuery、XxxQuery）TermQuery
          TermQuery query = new TermQuery(new Term("name", name));//  词项/元
          //5.查询结果TopDocs(索引区  不可能直接拿到Document)
          QueryScorer scorer=new QueryScorer(query);

          Formatter formatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
          Highlighter highlighter=new Highlighter(formatter,scorer);

          TopDocs topDocs = indexSearcher.search(query, Integer.MAX_VALUE);
          int totalHits = topDocs.totalHits;//实际返回的文档数目
          ScoreDoc[] scoreDocs = topDocs.scoreDocs;//返回的scoreDoc【score、docID】
          //6.遍历结果
          for (ScoreDoc scoreDoc : scoreDocs) {
              //设置高亮样式

              float score = scoreDoc.score;//文档得分，相似度越高 score越大 文档排名越靠前
              String score1 = String.valueOf(score);
              int docID = scoreDoc.doc;//文档的docID唯一标示数据区的Document
              //更具docID获取数据区的Document
              Document document = indexSearcher.doc(docID);
              String id = document.get("id");
              String name1 = document.get("name");
              String name2 = highlighter.getBestFragment(analyzer, "name", name1);
              String price = document.get("price");
              Double price1 = Double.valueOf(price);
              String info = document.get("info");
              String href=document.get("href");
              Iphone iphone = new Iphone(id, name2, null, info,href, price1,null,score1);
              list.add(iphone);
          }
          request.setAttribute("iphones",list);
          //7关闭资源
          indexSearcher.close();
          indexReader.close();
          return "forward:/iphone/SerachResult.jsp";
      }
}
