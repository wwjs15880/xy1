package com.example.administrator.xy;

import com.example.administrator.xy.entity.Translation;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class http {

    public static Observable<Translation> request(String classid ,int page) {

        String obj = "{\"query\":\"{\\n  articleList(iProductID:145, iClassID:\\\""+classid+"\\\", isContestants:1, iOrder:0, iPageNum:"+page+"){\\n    total,\\n    rows{\\n      iArticleID,\\n      iProductID,\\n      szTitle,\\n      iReadCnt,\\n      iCommentCnt,\\n      iHotType,\\n      iAttacheFlag,\\n      dtTime,\\n      szSummary,\\n      iQQ,\\n      author{\\n        iQQ,\\n        baseInfo {\\n          szNickName,\\n          szHeaderUrl,\\n          iWeekActive,\\n          newProfile{\\n            iProductID,\\n            szProfileDesc\\n          }\\n        }\\n      }\\n    }\\n  }\\n  hotArticle(iProductID:145, iClassID: \\\"30690\\\") {\\n    iArticleID,\\n    iProductID,\\n    szTitle\\n  }\\n  hotArticle2(iProductID:145, iClassID: \\\"30690\\\") {\\n    iArticleID,\\n    iProductID,\\n    szTitle\\n  }\\n}\",\"tk\":\"d7137fa37569ae41881623206892fcf9\"}";
        final RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), obj);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://m.gamer.qq.com/v2/graphql/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);
        Observable<Translation> observable = request.postCall(body);

        return observable;
    }
}
