package com.example.nothing.testdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.bean.BeanIcon;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.RecyclerHome_VH> {

    private List<BeanIcon> list;
    private Context context;
    private LayoutInflater inflater;
    private HomeItemClick homeItemClick;

    public AdapterHome(List<BeanIcon> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerHome_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.adapter_home , viewGroup , false);
        return new RecyclerHome_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHome_VH holder, int i) {
        BeanIcon beanIcon = list.get(i);
        holder.homeRecyclerImg.setImageResource(beanIcon.getImgSrc());
        holder.homeRecyclerText.setText(beanIcon.getName());
        holder.homeRecyclerContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeItemClick == null)return;
                homeItemClick.onHomeItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class RecyclerHome_VH extends RecyclerView.ViewHolder{

        private ImageView homeRecyclerImg;
        private TextView homeRecyclerText;
        private LinearLayout homeRecyclerContainer;

        public RecyclerHome_VH(@NonNull View itemView) {
            super(itemView);
            homeRecyclerImg = itemView.findViewById(R.id.home_reycler_img);
            homeRecyclerText = itemView.findViewById(R.id.home_recycler_text);
            homeRecyclerContainer = itemView.findViewById(R.id.home_recycler_container);
        }
    }

    public interface HomeItemClick{
        void onHomeItemClick(int psn);
    }

    public void setOnHomeItemClickListener(HomeItemClick homeItemClickListener){
        homeItemClick = homeItemClickListener;
    }
}