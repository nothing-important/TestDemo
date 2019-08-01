package com.example.nothing.testdemo.base;

public class BeanPhone {

    private boolean isTitle;
    private String name;
    private String phone;

    public BeanPhone() {
    }

    public BeanPhone(boolean isTitle, String name, String phone) {
        this.isTitle = isTitle;
        this.name = name;
        this.phone = phone;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
