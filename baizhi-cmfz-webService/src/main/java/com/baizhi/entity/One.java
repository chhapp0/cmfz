package com.baizhi.entity;

/**
 * Created by ljf on 2017/6/16.
 */
public class One {
    private BannerDATA header;
    private All body;

    public One() {
    }

    public BannerDATA getHeader() {
        return header;
    }

    public All getBody() {
        return body;
    }

    public One(BannerDATA header, All body) {
        this.header = header;
        this.body = body;
    }

    public void setHeader(BannerDATA header) {
        this.header = header;
    }

    public void setBody(All body) {
        this.body = body;
    }
}
