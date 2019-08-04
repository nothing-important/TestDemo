package com.example.nothing.testdemo.bean;

public class BeanIcon {

    private int imgSrc;
    private String name;
    private boolean isSelect;
    private boolean isBootom;
    private boolean isShowIcon;

    public BeanIcon() {
    }

    public BeanIcon(int imgSrc, String name, boolean isSelect , boolean isBootom , boolean isShowIcon) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.isSelect = isSelect;
        this.isBootom = isBootom;
        this.isShowIcon = isShowIcon;
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

    public boolean isBootom() {
        return isBootom;
    }

    public void setBootom(boolean bootom) {
        isBootom = bootom;
    }

    public boolean isShowIcon() {
        return isShowIcon;
    }

    public void setShowIcon(boolean showIcon) {
        isShowIcon = showIcon;
    }
}
