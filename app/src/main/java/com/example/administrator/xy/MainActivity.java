package com.example.administrator.xy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import io.reactivex.Observable;
import com.example.administrator.xy.entity.Translation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;


import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl_first;
    private ImageView tv_test;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_content);
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
        tv_test = (ImageView)findViewById(R.id.debug);










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
                });
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
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", "1");
            map.put("iArticleID", rowsBean.iArticleID);
            map.put("iProductID", rowsBean.iProductID);
            map.put("szTitle", rowsBean.szTitle);
            map.put("iReadCnt",rowsBean.iReadCnt);
            map.put("iCommentCnt",rowsBean.iCommentCnt);
            map.put("dtTime",rowsBean.dtTime);
            map.put("szNickName",rowsBean.author.baseInfo.szNickName);
            map.put("szHeaderUrl",rowsBean.author.baseInfo.szHeaderUrl);

            String json = rowsBean.szSummary;
            try {
                JSONObject content = new JSONObject(json);
                map.put("szSummary",content.get("szSummary").toString());

                http.requestHeader(rowsBean.author.baseInfo.szHeaderUrl).subscribeOn(Schedulers.io())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                System.out.println("subs");
                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {
                                System.out.println("next");
                                map.put("header",responseBody.byteStream());
                                //((ImageView)findViewById(R.id.ib_head_login)).setImageBitmap(BitmapFactory.decodeStream(responseBody.byteStream()));
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println("err");
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("complete");
                            }
                        });
                //if(j==0){
                    //map.put("header",http.requestHeader(rowsBean.author.baseInfo.szHeaderUrl));
                //}


                /*
                String temp = content.get("imgArr").toString();
                temp = temp.substring(1,temp.length()-1);
                String[] pic = temp.split(",");
                for(int i=0;i<pic.length;i++){
                    map.put("pic"+i,http.requestHeader(pic[i]).subscribeOn(Schedulers.io()));
                }*/
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //map.put("szSummary",rowsBean.szSummary);
            list.add(map);
        }
        return list;
    }

}
