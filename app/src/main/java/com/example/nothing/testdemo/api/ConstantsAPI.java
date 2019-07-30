package com.example.nothing.testdemo.api;

import java.util.HashMap;
import java.util.Map;

public class ConstantsAPI {

    public static class Login{
        public static final String ACCOUNT = "15777777777";
        public static final String PASSWORD = "123456";
    }

    public static HashMap<String , String> getSliderData(){
        HashMap<String , String> sliderData = new HashMap<>();
        sliderData.put("one" , "http://pic13.nipic.com/20110425/668573_150157400119_2.jpg");
        sliderData.put("two" , "http://pic163.nipic.com/file/20180421/7092831_140036752037_2.jpg");
        sliderData.put("three" , "http://pic31.nipic.com/20130724/3822951_160056763000_2.jpg");
        sliderData.put("four" , "http://pic.rmb.bdstatic.com/f54083119edfb83c4cfe9ce2eeebc076.jpeg");
        return sliderData;
    }

}
