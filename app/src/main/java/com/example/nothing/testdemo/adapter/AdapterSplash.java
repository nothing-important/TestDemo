package com.example.nothing.testdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.nothing.testdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterSplash extends PagerAdapter {

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public AdapterSplash(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.adapter_splash_view , container , false);
        ImageView imageView = view.findViewById(R.id.splash_item_img);
        Picasso.with(context).load(list.get(position)).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
