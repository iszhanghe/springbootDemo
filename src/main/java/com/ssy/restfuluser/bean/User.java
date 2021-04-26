package com.ssy.restfuluser.bean;

public class User {

    private String id;

    /**
     *此处成员变量名称与数据库表中不同，方便查看mybatis resultmap的作用
     */
    private String name;

    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
