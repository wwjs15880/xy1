package com.example.administrator.xy;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import io.reactivex.Observable;
import com.example.administrator.xy.entity.Translation;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl_first;
    private TextView tv_test;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_content);
        //tv_test = (TextView) findViewById(R.id.rv_content);
        mRecyclerView.setLayoutManager(mLayoutManager);


        tl_first = (TabLayout)findViewById(R.id.tl_first);
        tl_first.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        http.request("30690|30689|30691|30764|30688",0).subscribeOn(Schedulers.io())//请求数据的事件发生在io线程
                .observeOn(AndroidSchedulers.mainThread())//请求完成后在主线程更显UI
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("subs");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        System.out.println("next");
                        //tv_test.setText(translation.result.hotArticle.get(0).szTitle);

                        mAdapter = new MyAdapter(getData(translation));
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("err");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });;
    }

    private List<Map<String, Object>> getData(Translation translation) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0;i<translation.result.hotArticle.size();i++) {
            Translation.ResultBean.HotArticleBean hotArticleBean = translation.result.hotArticle.get(i);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", "0");
            map.put("iArticleID", hotArticleBean.iArticleID);
            map.put("iProductID", hotArticleBean.iProductID);
            map.put("szTitle", hotArticleBean.szTitle);
            list.add(map);
        }

        for(int j=0;j<translation.result.articleList.rows.size();j++){
            Translation.ResultBean.ArticleListBean.RowsBean rowsBean = translation.result.articleList.rows.get(j);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", "1");
            map.put("iArticleID", rowsBean.iArticleID);
            map.put("iProductID", rowsBean.iProductID);
            map.put("szTitle", rowsBean.szTitle);
            map.put("iReadCnt",rowsBean.iReadCnt);
            map.put("iCommentCnt",rowsBean.iCommentCnt);
            map.put("dtTime",rowsBean.dtTime);
            map.put("szNickName",rowsBean.author.baseInfo.szNickName);
            map.put("szHeaderUrl",rowsBean.author.baseInfo.szHeaderUrl);
            list.add(map);
        }
        return list;
    }

}
