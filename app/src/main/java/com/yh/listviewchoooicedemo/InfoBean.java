package com.yh.listviewchoooicedemo;

/**
 * Created by YH on 2016/12/17.
 */

public class InfoBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
