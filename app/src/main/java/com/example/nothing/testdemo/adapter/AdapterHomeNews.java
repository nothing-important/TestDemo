package com.example.nothing.testdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.bean.BeanNews;
import com.example.nothing.testdemo.view.RoundImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterHomeNews extends RecyclerView.Adapter<AdapterHomeNews.AdapterHomeNews_VH> {

    private List<BeanNews> list;
    private Context context;
    private LayoutInflater inflater;

    public AdapterHomeNews(List<BeanNews> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterHomeNews_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.adapter_news , viewGroup , false);
        return new AdapterHomeNews_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHomeNews_VH holder, int i) {

        BeanNews beanNews = list.get(i);
        Picasso.with(context).load(beanNews.getImgSrc()).into(holder.homeNewsImg);
        holder.homeNewsName.setText(beanNews.getTitle());
        holder.homeNewsDesc.setText(beanNews.getDesc());
        holder.homeNewsSee.setText(beanNews.getSeeCount());
        holder.homeNewsTime.setText(beanNews.getTime());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class AdapterHomeNews_VH extends RecyclerView.ViewHolder{

        private RoundImageView homeNewsImg;
        private TextView homeNewsName , homeNewsDesc , homeNewsSee , homeNewsTime;

        public AdapterHomeNews_VH(@NonNull View itemView) {
            super(itemView);
            homeNewsImg = itemView.findViewById(R.id.home_news_img);
            homeNewsName = itemView.findViewById(R.id.home_news_name);
            homeNewsDesc = itemView.findViewById(R.id.home_news_desc);
            homeNewsSee = itemView.findViewById(R.id.home_news_see);
            homeNewsTime = itemView.findViewById(R.id.home_news_time);
        }
    }
}
