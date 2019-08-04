package com.example.nothing.testdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BeanPhone;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPhone extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BeanPhone> list;
    private LayoutInflater inflater;
    private PhoneClick phoneClick;

    public AdapterPhone(Context context, List<BeanPhone> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 111){
            view = inflater.inflate(R.layout.adapter_phone_title , parent , false);
            return new AdapterPhoneTitle(view);
        }else {
            view = inflater.inflate(R.layout.adapter_phone_normal , parent , false);
            return new AdapterPhoneNormal(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BeanPhone beanPhone = list.get(position);
        boolean nextFlag = false;
        if (position + 1 < list.size()){
            nextFlag = list.get(position + 1).isTitle();
        }
        if (holder instanceof AdapterPhoneTitle){
            ((AdapterPhoneTitle) holder).phoneTitleName.setText(beanPhone.getName());
        }else {
            ((AdapterPhoneNormal)holder).phone_normal_line.setVisibility(View.VISIBLE);
            ((AdapterPhoneNormal)holder).phoneNormalName.setText(beanPhone.getName());
            if (nextFlag){
                ((AdapterPhoneNormal)holder).phone_normal_line.setVisibility(View.GONE);
            }else {
                ((AdapterPhoneNormal)holder).phone_normal_line.setVisibility(View.VISIBLE);
            }
            ((AdapterPhoneNormal)holder).phoneNormalContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (phoneClick == null)return;
                    phoneClick.onPhoneClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isTitle()){
            return 111;
        }else {
            return 222;
        }
    }

    static class AdapterPhoneTitle extends RecyclerView.ViewHolder{

        private LinearLayout phoneTitleContainer;
        private TextView phoneTitleName;

        public AdapterPhoneTitle(@NonNull View itemView) {
            super(itemView);
            phoneTitleContainer = itemView.findViewById(R.id.phone_title_container);
            phoneTitleName = itemView.findViewById(R.id.phone_title_name);
        }
    }

    static class AdapterPhoneNormal extends RecyclerView.ViewHolder{

        private LinearLayout phoneNormalContainer;
        private TextView phoneNormalName , phone_normal_line;

        public AdapterPhoneNormal(@NonNull View itemView) {
            super(itemView);
            phoneNormalContainer = itemView.findViewById(R.id.phone_normal_container);
            phoneNormalName = itemView.findViewById(R.id.phone_normal_name);
            phone_normal_line = itemView.findViewById(R.id.phone_normal_line);
        }
    }

    public interface PhoneClick{
        void onPhoneClick(int psn);
    }

    public void setOnPhoneClick(PhoneClick phoneClick){
        this.phoneClick = phoneClick;
    }
}
