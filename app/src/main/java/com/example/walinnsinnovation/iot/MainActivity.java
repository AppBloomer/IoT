package com.example.walinnsinnovation.iot;

 import android.app.Dialog;

 import android.content.Intent;
 import android.graphics.drawable.AnimationDrawable;
 import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageView;

 import com.example.walinnsinnovation.iot.Activity.LoginActivity;
 import com.example.walinnsinnovation.iot.Activity.RegisterActivity;

 import com.example.walinnsinnovation.iot.Singleton.HttpManage;
 import com.example.walinnsinnovation.iot.Singleton.XHeader;
 import com.google.gson.Gson;
 import com.loopj.android.http.AsyncHttpClient;
 import com.loopj.android.http.AsyncHttpResponseHandler;
 import com.loopj.android.http.RequestParams;
 import com.loopj.android.http.ResponseHandlerInterface;
 import com.loopj.android.http.TextHttpResponseHandler;
 import com.viewpagerindicator.CirclePageIndicator;

 import org.apache.http.Header;
 import org.apache.http.HttpEntity;
 import org.apache.http.entity.StringEntity;
 import org.json.JSONException;
 import org.json.JSONObject;

 import java.io.UnsupportedEncodingException;
 import java.util.HashMap;
 import java.util.Map;

 import static com.example.walinnsinnovation.iot.Singleton.HttpAgent.MD5;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    ViewPager mPager;
    CirclePageIndicator mCirclePageIndicator;
    PagerAdapter adapter;
    Button btnsignup,btnsignin;
    View CurrView;
    private static final String X_ContentMD5 = "X-ContentMD5";
    public static String SECRET_KEY = "4b5d7675883440fa9c1fdb8264659ad2";
    private static final String X_Sign = "X-Sign";
    private static AsyncHttpClient client;
    private Header[] headers;
    public static String COMPANY_ID = "";
    private final String host = "http://api2.xlink.cn";
    //    private final String host="http://139.224.7.17";
    public final String registerUrl ="http://app.xlink.cn/v1/user/register"; //host + "/v2/user_register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        mPager=(ViewPager)findViewById(R.id.pager);

        mCirclePageIndicator=(CirclePageIndicator) findViewById(R.id.indicator);
        btnsignin=(Button)findViewById(R.id.btnsignin);
        btnsignup=(Button)findViewById(R.id.btnsignup);
        btnsignin.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
        adapter=new com.example.walinnsinnovation.iot.Adapter.PagerAdapter(this);
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(this);
        mCirclePageIndicator.setRadius(5);
        mCirclePageIndicator.setPadding(0,10,0,0);
        mCirclePageIndicator.setPageColor(this.getResources().getColor(R.color.inticator));
        mCirclePageIndicator.setFillColor(this.getResources().getColor(android.R.color.white));
        mCirclePageIndicator.setVisibility(View.VISIBLE);
        mCirclePageIndicator.setViewPager(mPager);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        System.out.println("OnPageSeletedteItem_scroll" + position);


    }

    @Override
    public void onPageSelected(int position) {

        System.out.println("ONVIEWSELECTEDITEM" + position);

//        if(position==0) {
//            CurrView = mPager.getChildAt(mPager.getCurrentItem());
//            if(CurrView!=null) {
//                ImageView image_view = (ImageView) CurrView.findViewById(R.id.image_view);
//                image_view.setBackgroundResource(R.drawable.anim_demo);
//                final AnimationDrawable anim = (AnimationDrawable) image_view.getBackground();
//                anim.start();
//            }
//        }else if(position==1){
//            CurrView = mPager.getChildAt(mPager.getCurrentItem());
//            if(CurrView!=null) {
//                ImageView image_view = (ImageView) CurrView.findViewById(R.id.image_view);
//                image_view.setBackgroundResource(R.drawable.anim_s);
//                final AnimationDrawable anim = (AnimationDrawable) image_view.getBackground();
//                anim.start();
//            }
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        System.out.println("OnPageSeletedteItem_STATE_****" + state);


    }

    @Override
    public void onClick(View v) {
        Dialog dialog = null;
        switch (v.getId()){
//            case R.id.txtReg:
//                dialog=new Dialog(this,android.R.style.Theme_Light_NoTitleBar_Fullscreen);
//                dialog.setContentView(R.layout.register_dialog);
//                setView(dialog);
//                dialog.show();
//                break;

            case R.id.btnsignin:
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
               // getAuth("8098823107", "Tintu4810", new C13984());

                break;
            case R.id.btnsignup:
                intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
//                 registerUserByMail("8098823107", "Rejoyline", "Tintu4810", new HttpManage.ResultCallback < String > () {
//                    @Override
//                    public void onError(Header[] headers, HttpManage.Error error) {
//                        System.out.println("RESPONSE_ERROR"+error.toString());
//                    }
//
//                    @Override
//                    public void onSuccess(int code, String response) {
//                        System.out.println("RESPONSE_SUCCESS"+response.toString());
//                    }
//                });
                break;

        }
    }
    class C13984 extends TextHttpResponseHandler {
        C13984() {
        }

        public void onSuccess(int arg0, Header[] header, String msg) {
            try {
                JSONObject object = new JSONObject(msg);
                int status = object.getInt("status");
                if (status == 200) {
                    JSONObject value = object.getJSONObject("user");
                    System.out.println("RESPONSE***"+status+"..."+value.toString());

                } else if (status == 403 || status == 404) {
                    System.out.println("RESPONSE_ELSE_IF***"+status);

                } else {
                    System.out.println("RESPONSE_ELSE***"+status);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
          
        }

        public void onFailure(int arg0, Header[] header, String msg, Throwable arg3) {
           
            
             
        }
    }
    public void getAuth(String user, String pwd, TextHttpResponseHandler handler) {
        Map<String, Object> map = new HashMap();
        map.put("uid", user);
        map.put("pwd", pwd);
        JSONObject data =getJsonObject(map);
        StringEntity entity = null;
        entity = new StringEntity(data.toString(), "UTF-8");
        headers = new Header[3];
        String contentMD5 = MD5(data.toString());
        headers[1] = new XHeader(X_ContentMD5, contentMD5, null);
        headers[2] = getSign(contentMD5);
        post("http://app.xlink.cn/v1/user/auth", headers, entity, handler);
    }
    public static JSONObject getJsonObject(Map<String, Object> map) {
        JSONObject jo = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jo.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jo;
    }
    private XHeader getSign(String contentmd5) {
        return new XHeader(X_Sign, MD5(SECRET_KEY + contentmd5), null);
    }
    public void post(String url, Header[] headers, HttpEntity entity, AsyncHttpResponseHandler handler) {
        client.post(getApplicationContext(), url, headers, entity, "text/html", (ResponseHandlerInterface) handler);
    }


    public void registerUserByMail(String uid, String name, String pwd, final HttpManage.ResultCallback callback) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("uid", uid);
        params.put("name", uid);
      //  params.put("corp_id", COMPANY_ID);
        params.put("password", pwd);
      //  params.put("source", "2");
        System.out.println("REQUEST_PARAMS"+new Gson().toJson(params));
        post(registerUrl, params, callback);
    }



    private void post(String url, Map<String, String> params, HttpManage.ResultCallback callback) {
        // 请求entity
        StringEntity entity = params2StringEntity(params);
        System.out.println("REQUEST_PARAMS_entity"+entity);

        client = new AsyncHttpClient();
        client.setTimeout(5000);
        client.setConnectTimeout(3000);
        client.post(getApplicationContext(), url, entity, "application/json", callback);
    }
    private StringEntity params2StringEntity(Map<String, String> params) {
        StringEntity entity = null;
        try {
            entity = new StringEntity(new Gson().toJson(params), "UTF-8");
        } catch (Exception e) {
        }
        return entity;
    }
}
