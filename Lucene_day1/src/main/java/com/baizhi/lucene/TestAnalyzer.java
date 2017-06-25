package com.baizhi.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by ljf on 2017/6/23.
 */
public class TestAnalyzer {
    public static void main(String[] args) throws IOException {
        Analyzer analyzer=new IKAnalyzer();
        String value="欢迎您来软件园学习JAVA, 奋斗吧!";

        StringReader reader=new StringReader(value);
        printToken(analyzer,reader);
    }

    public static void printToken(Analyzer analyzer, Reader reader) throws IOException {
        TokenStream tokenStream=analyzer.tokenStream("fieldName",reader);
        //注册查看分词, 词项
        CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()){
            System.out.println("["+termAttribute+"]");
        }
    }
}
