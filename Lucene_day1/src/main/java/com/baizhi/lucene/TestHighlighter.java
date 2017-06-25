package com.baizhi.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.highlight.*;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * Created by ljf on 2017/6/23.
 */
public class TestHighlighter {
    public static void main(String[] args) throws IOException, InvalidTokenOffsetsException {
       // lighter1();
        //lighter2();
        lighter3();
    }

    public static void lighter1() throws IOException, InvalidTokenOffsetsException{
        String msg="#这是啥玩意 book，下雨了,看不懂。";
        Analyzer analyzer=new SimpleAnalyzer();

        Query query=new TermQuery(new Term("content","book"));
        Scorer scorer=new QueryScorer(query);
        Highlighter highlighter=new Highlighter(scorer);

        //获取文本 摘要
        String bestFragment = highlighter.getBestFragment(analyzer, "content", msg);
        System.out.println(bestFragment);
    }


    public static void lighter2() throws IOException, InvalidTokenOffsetsException{
        String msg="#这是啥玩意 book，下雨了,看不懂。";
        Analyzer analyzer=new SimpleAnalyzer();

        Query query=new TermQuery(new Term("content","book"));
        Scorer scorer=new QueryScorer(query);
        Formatter formatter=new SimpleHTMLFormatter("<span class='highter'>","<span>");
        Highlighter highlighter=new Highlighter(formatter,scorer);

        //获取文本 摘要
        String bestFragment = highlighter.getBestFragment(analyzer, "content", msg);
        System.out.println(bestFragment);
    }

    public static void lighter3() throws IOException, InvalidTokenOffsetsException{
        String msg="#这是啥玩意 book，下雨了,看不懂。";
        Analyzer analyzer=new IKAnalyzer();

        Query query=new TermQuery(new Term("content","玩意"));
        QueryScorer scorer=new QueryScorer(query);
        //设置高亮样式
        Formatter formatter=new SimpleHTMLFormatter("<span class='highter'>","<span>");
        Highlighter highlighter=new Highlighter(formatter,scorer);

        //设置摘要长度
        SimpleSpanFragmenter simpleSpanFragmenter = new SimpleSpanFragmenter(scorer, 20);
        highlighter.setTextFragmenter(simpleSpanFragmenter);

        //获取文本 摘要
        String bestFragment = highlighter.getBestFragment(analyzer, "content", msg);
        System.out.println(bestFragment+"asdasd");
    }
}
