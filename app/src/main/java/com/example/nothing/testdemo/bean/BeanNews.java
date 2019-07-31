package com.example.nothing.testdemo.bean;

public class BeanNews {

    private String imgSrc;
    private String title;
    private String desc;
    private String seeCount;
    private String time;

    public BeanNews() {
    }

    public BeanNews(String imgSrc, String title, String desc, String seeCount, String time) {
        this.imgSrc = imgSrc;
        this.title = title;
        this.desc = desc;
        this.seeCount = seeCount;
        this.time = time;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(String seeCount) {
        this.seeCount = seeCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
