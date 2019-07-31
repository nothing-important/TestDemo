package com.example.nothing.testdemo.bean;

public class BeanIcon {

    private int imgSrc;
    private String name;
    private boolean isSelect;

    public BeanIcon() {
    }

    public BeanIcon(int imgSrc, String name, boolean isSelect) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.isSelect = isSelect;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
