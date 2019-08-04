package com.example.nothing.testdemo.api;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BeanPhone;
import com.example.nothing.testdemo.bean.BeanIcon;
import com.example.nothing.testdemo.bean.BeanNews;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantsAPI {

    public static class Login{
        public static final String ACCOUNT = "15777777777";
        public static final String PASSWORD = "123456";
    }

    public static HashMap<String , Integer> getSliderData(){
        HashMap<String , Integer> sliderData = new HashMap<>();
        sliderData.put("one" , R.mipmap.banner_one);
        sliderData.put("two" , R.mipmap.banner_two);
        sliderData.put("three" , R.mipmap.banner_three);
        sliderData.put("four" , R.mipmap.banner_four);
        return sliderData;
    }

    public static ArrayList<BeanIcon> getIconData(){
        ArrayList<BeanIcon> dataList = new ArrayList<>();
        dataList.add(new BeanIcon(R.mipmap.icon_more_lock, "智慧门禁" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_packing, "智慧停车" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_holding, "考勤打卡" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_eat, "园区食堂" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_file, "文件管理" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_phone, "通讯录" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_home_more , "更多" , true , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_net , "一键上网" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_phone , "会议室预定" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_camera , "视频会议" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_company , "企业服务" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_eat, "会员充值" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_xiu, "物业报修" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_dang, "党群建设" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_service, "服务联盟" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_bill, "账单查询" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_mission, "任务管理" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_qiye, "入驻企业" , false , true , false));
        dataList.add(new BeanIcon(R.mipmap.icon_more_line, "服务热线" , false , true , false));
        return dataList;
    }

    public static ArrayList<BeanIcon> getIconSelectedData(){
        //ArrayList<BeanIcon> iconData = getIconData();
        ArrayList<BeanIcon> iconSelectedData = new ArrayList<>();
//        for (int i = 0; i < iconData.size(); i++) {
//            BeanIcon beanIcon = iconData.get(i);
//            if (beanIcon.isSelect()){
//                iconSelectedData.add(beanIcon);
//            }
//        }
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_lock, "智慧门禁" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_packing, "智慧停车" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_holding, "考勤打卡" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_eat, "园区食堂" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_file, "文件管理" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_more_phone, "通讯录" , true , true , false));
        iconSelectedData.add(new BeanIcon(R.mipmap.icon_home_more , "更多" , true , true , false));
        return iconSelectedData;
    }

    public static ArrayList<BeanNews> getNewsData(){
        ArrayList<BeanNews> dataList = new ArrayList<>();
        dataList.add(new BeanNews(R.mipmap.news_one , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews(R.mipmap.news_two , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews(R.mipmap.news_two , "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews(R.mipmap.news_one, "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        dataList.add(new BeanNews(R.mipmap.news_two, "园区运营管控一体化" , "典型围绕智慧园区提供智能化、智慧化、便捷化、流程化的智慧园区全新体验....." , "886" , "2019-6-27   11:00"));
        return dataList;
    }

    public static ArrayList<BeanPhone> getPhoneData(){
        ArrayList<BeanPhone> dataList = new ArrayList<>();
        dataList.add(new BeanPhone(true , "致远科技有限公司      156人" , ""));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(true , "技术部" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(true , "市场部" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        return dataList;
    }

    public static ArrayList<BeanPhone> getDepartmentData(){
        ArrayList<BeanPhone> dataList = new ArrayList<>();
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        dataList.add(new BeanPhone(false , "李忠志" , "15711111111"));
        return dataList;
    }

    public static ArrayList<String> getSplashData(){
        ArrayList<String> dataList = new ArrayList<>();
//        dataList.add(R.mipmap.splash_one_test);
//        dataList.add(R.mipmap.splash_two);
//        dataList.add(R.mipmap.splash_three);
//        dataList.add(R.mipmap.splash_four);
        dataList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564911158180&di=818a425f8712e66e06dddd31d90f313d&imgtype=0&src=http%3A%2F%2Fi3.download.fd.pchome.net%2Ft_600x1024%2Fg1%2FM00%2F0C%2F1A%2FooYBAFR33VqIUDoTACcYNEQFuCIAACHggJSLtgAJxhM242.jpg");
        dataList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564911087282&di=0b2cc33e03b8a923545cec0a26acea56&imgtype=0&src=http%3A%2F%2Fimg.jiaodong.net%2Fpic%2F0%2F11%2F34%2F17%2F11341750_888677.jpg");
        dataList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564911178043&di=4a4e41e249c4fcdc69769b9be4773050&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201608%2F26%2F20160826104840_cTREA.thumb.700_0.jpeg");
        dataList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564911087282&di=0b2cc33e03b8a923545cec0a26acea56&imgtype=0&src=http%3A%2F%2Fimg.jiaodong.net%2Fpic%2F0%2F11%2F34%2F17%2F11341750_888677.jpg");
        return dataList;
    }

    public static ArrayList<String> get12MonthsLaterData(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("2019年1月");
        arr.add("2019年2月");
        arr.add("2019年3月");
        arr.add("2019年4月");
        arr.add("2019年5月");
        arr.add("2019年7月");
        arr.add("2019年8月");
        arr.add("2019年9月");
        arr.add("2019年10月");
        arr.add("2019年11月");
        arr.add("2019年12月");
        return arr;
    }

}
