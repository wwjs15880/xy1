package com.example.administrator.xy;



import android.graphics.drawable.Drawable;

import com.example.administrator.xy.entity.Translation;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GetRequest_Interface {

    @GET
    Observable<ResponseBody> getHeader(@Url String fileUrl);

    @Headers({"Content-Type: application/json;charset=UTF-8",
              "x-csrf-token: l21dERmx47NdLfsUqPMB2GED",
              "Cookie:RK=KEix8MrkbS; ptcz=ce0c8332dc81cecf214e79583a74a771e88dd700ecd9d92f0352ecb1481732b7; pgv_pvid=6630281770; o_cookie=916202103; pgv_pvi=9018147840; csrfToken=l21dERmx47NdLfsUqPMB2GED; _pk_ses.5.94be=*; _pk_id.5.94be=1dea214e2686a27b.1536026108.6.1536111816.1536111475.; iUserAgent=s%3Aj%3A%7B%22value%22%3A%2261218e60-b0ad-11e8-a301-8313f4d4d791%22%7D.oOSa1yQClTDuk%2B3jq3m0Jx%2FYstES1Yg5YkqhqFLSei8"
    })
    @POST("http://m.gamer.qq.com/v2/graphql")
    Observable<Translation> postCall(@Body RequestBody info);

}
