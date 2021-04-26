package com.ssy.restfuluser.bean;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReqPack {

    private static final Logger logger = LoggerFactory.getLogger(ReqPack.class);

    private String version;
    private JSONObject data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}