package com.example.nothing.testdemo.api;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.bean.BeanIcon;
import com.example.nothing.testdemo.bean.BeanNews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static ArrayList<BeanIcon> getIconData(){
        ArrayList<BeanIcon> dataList = new ArrayList<>();
        dataList.add(new BeanIcon(R.mipmap.icon_home_lock, "智慧门禁" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_packing , "智慧停车" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_holding , "考勤打卡" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_eat , "园区食堂" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_file , "文件管理" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_phone , "通讯录" , true));
        dataList.add(new BeanIcon(R.mipmap.icon_home_more , "更多" , true));
        return dataList;
    }

    public static ArrayList<BeanIcon> getIconSelectedData(){
        ArrayList<BeanIcon> iconData = getIconData();
        ArrayList<BeanIcon> iconSelectedData = new ArrayList<>();
        for (int i = 0; i < iconData.size(); i++) {
            BeanIcon beanIcon = iconData.get(i);
            if (beanIcon.isSelect()){
                iconSelectedData.add(beanIcon);
            }
        }
        return iconSelectedData;
    }

    public static ArrayList<BeanNews> getNewsData(){
        ArrayList<BeanNews> dataList = new ArrayList<>();
        dataList.add(new BeanNews("http://pic13.nipic.com/20110425/668573_150157400119_2.jpg" , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews("http://pic13.nipic.com/20110425/668573_150157400119_2.jpg" , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews("http://pic13.nipic.com/20110425/668573_150157400119_2.jpg" , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews("http://pic13.nipic.com/20110425/668573_150157400119_2.jpg" , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews("http://pic13.nipic.com/20110425/668573_150157400119_2.jpg" , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        return dataList;
    }


}
