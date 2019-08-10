package com.example.nothing.testdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nothing.testdemo.R;
import com.example.nothing.testdemo.base.BaseActivity;
import com.joanzapata.pdfview.PDFView;

import butterknife.BindView;

public class PDFActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.pdf_view)
    PDFView pdfView;
    private String pdfTitle;
    private String pdfName;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_pdf;
    }

    @Override
    protected void initView() {
        titleBack.setVisibility(View.VISIBLE);
        titleName.setVisibility(View.VISIBLE);
        titleName.setText(pdfTitle);
        pdfView.fromAsset(pdfName)
                //.pages(0, 2, 1, 3, 3, 3)
                .defaultPage(1)
                .showMinimap(false)
                .enableSwipe(true)
                //.onDraw(onDrawListener)
                //.onLoad(onLoadCompleteListener)
                //.onPageChange(onPageChangeListener)
                .load();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent == null)return;
        pdfTitle = intent.getStringExtra("pdf_activity_title") == null ? "BisWit" : intent.getStringExtra("pdf_activity_title");
        pdfName = intent.getStringExtra("pdf_activity_pdfname");
    }

    @Override
    protected void setListener() {
        titleBack.setOnClickListener(this);
    }

    public static void trans(Context context , String titleStr , String pdfName){
        Intent intent = new Intent(context , PDFActivity.class);
        intent.putExtra("pdf_activity_title" , titleStr);
        intent.putExtra("pdf_activity_pdfname" , pdfName);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
