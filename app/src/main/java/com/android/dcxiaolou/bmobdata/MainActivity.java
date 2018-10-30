package com.android.dcxiaolou.bmobdata;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewStructure;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.dcxiaolou.bmobdata.mode.ReadArticle;
import com.android.dcxiaolou.bmobdata.mode.ReadArticleResult;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Okio;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private WebView webView;
    private HtmlTextView htmlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "7da0ead2c6b46b967b9d218b171e42e7");

        //SD卡读写权限申请
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

        //将Read->Article->.json文件上传到Bmob素材中，然后存入bmob数据库中，不然会出错：invalid file: filename empty.
        // sdcard/Download/Read/Article
        /*for (int i = 1; i <=142; i++) {
            String path = "/mnt/sdcard/Download/Read/Article/" + i + ".json";

            final BmobFile bombFile = new BmobFile(new File(path));
            final int finalI = i;
            bombFile.uploadblock(new UploadFileListener() {
                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        Log.d("TAG",   "upload " + bombFile.getFilename());
                        final ReadArticle readArticle = new ReadArticle();
                        readArticle.setId(String.valueOf(finalI));
                        readArticle.setBmobFile(bombFile);
                        readArticle.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if (e == null) {
                                    Log.d("TAG", "add " + finalI + ".json to db");
                                } else {
                                    Log.d("TAG", e.getMessage());
                                }
                            }
                        });
                    } else {
                        Log.d("TAG", e.getMessage());
                    }
                }
            });
        }*/


        imageView = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.text_view);
        webView = (WebView) findViewById(R.id.web_view);
        htmlTextView = (HtmlTextView) findViewById(R.id.html_text);


        BmobQuery<ReadArticle> query = new BmobQuery<>();
        query.getObject("9d1e0024e7", new QueryListener<ReadArticle>() {
            @Override
            public void done(ReadArticle readArticle, BmobException e) {
                if (e == null) {
                    String id = readArticle.getId();
                    Log.d("TAG", id);
                    BmobFile file = readArticle.getBmobFile();
                    String fileUrl = file.getFileUrl();
                    Log.d("TAG", file.getFilename() + "  " + fileUrl);

                    //使用OkHttp获取fileUrl的具体内容
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(fileUrl).build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String result = response.body().string();
                            Log.d("TAG", result);

                            Gson gson = new Gson();
                            ReadArticleResult articleResult = gson.fromJson(result, ReadArticleResult.class);
                            final String imageUrl = articleResult.getImage();
                            final String textUrl = articleResult.getArticle_url();
                            final String text = articleResult.getArticle_detail().get(0);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    //使用html_text外部库显示html，图片显示效果不错，需要导入org.sufficientlysecure.htmltextview
                                    htmlTextView.setHtml(text, new HtmlHttpImageGetter(htmlTextView));

                                }
                            });

                        }
                    });

                } else {
                    Log.d("TAG", e.getMessage());
                }
            }
        });

    }

    //SD卡读写权限申请响应
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "read permission");
                } else {
                    Log.d("TAG", "filed read permission");
                }
                break;
            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "write permission");
                } else {
                    Log.d("TAG", "filed write permission");
                }
                break;
            default:
                break;
        }

    }

}
