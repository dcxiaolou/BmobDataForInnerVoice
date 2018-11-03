package com.android.dcxiaolou.bmobdata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.dcxiaolou.bmobdata.util.PushDataToBmob;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mPushDataToArticle, mPushIntroduceToCourse, mPushDetailToCourse;
    private HtmlTextView htmlTextView;

    private List<String> articleTypes;
    private List<String> courseID = new ArrayList<>();
    private List<Integer> coursedetail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "35c39c93bd729b73efb27f9d8df9e72d");

        htmlTextView = (HtmlTextView) findViewById(R.id.html_text);
        mPushDataToArticle = (Button) findViewById(R.id.btn_push_data_to_article);
        mPushIntroduceToCourse = (Button) findViewById(R.id.btn_push_introduce_to_course);
        mPushDetailToCourse = (Button) findViewById(R.id.btn_push_detail_to_course);

        mPushDataToArticle.setOnClickListener(this);
        mPushIntroduceToCourse.setOnClickListener(this);
        mPushDetailToCourse.setOnClickListener(this);

        courseID.add("1");
        courseID.add("4");
        courseID.add("5");
        courseID.add("6");
        courseID.add("7");
        courseID.add("8");
        courseID.add("35");
        courseID.add("136");
        courseID.add("192");
        courseID.add("194");
        courseID.add("202");
        courseID.add("228");
        courseID.add("237");
        courseID.add("244");

        for (int i = 1; i <= 9; i++)
            coursedetail.add(1);
        coursedetail.add(189);
        coursedetail.add(1);
        coursedetail.add(1);
        coursedetail.add(1);
        coursedetail.add(1);


        //SD卡读写权限申请
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

        // 请求read下的article，并对返回的json文件进行解析，使用html_textview显示html
        /*BmobQuery<ReadArticle> query = new BmobQuery<>();
        query.getObject("9d1e0024e7", new QueryListener<ReadArticle>() {
            @Override
            public void done(ReadArticle readArticle, BmobException e) {
                if (e == null) {
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
        });*/

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_push_data_to_article:
                //将Read->Article->.json文件上传到Bmob素材中，然后存入bmob数据库中，不然会出错：invalid file: filename empty.
                // /mnt/sdcard/Download/Read/Article/2199_100.json
                articleTypes = new ArrayList<>();
                articleTypes.add("792");
                articleTypes.add("876");
                articleTypes.add("660");
                articleTypes.add("2206");
                articleTypes.add("2199");
                articleTypes.add("862");
                articleTypes.add("823");
                articleTypes.add("844");
                String articlePath;
                for (String type : articleTypes) {
                    for (int i = 1; i <= 20; i++) {
                        // /mnt/sdcard/Download/Read/Article/2206_9.json
                        articlePath = "/mnt/sdcard/Download/Read/Article/" + type + "_" + i + ".json";
                        PushDataToBmob.PushArticle(articlePath, type);
                    }
                }
                Log.d("TAG", "push data to article done");
                break;
            case R.id.btn_push_introduce_to_course:
                String courseIntroducePath;
                for (String id : courseID) {
                    courseIntroducePath = "/mnt/sdcard/Download/Course/introduce/" + id + ".json";
                    PushDataToBmob.PushIntroduceToCourse(courseIntroducePath);
                }
                Log.d("TAG", "PushIntroduceToCourse done");
                break;
            case R.id.btn_push_detail_to_course:
                String coursePath;
                int item = 0;
                Log.d("TAG", "courseID = " + courseID.size());
                for (String course : courseID) {
                    int sum = coursedetail.get(item);
                    if (sum > 100) sum = 100; // 防止上传的文件太多传不上去
                    for (int i = 1; i <= sum; i++) {
                        // /mnt/sdcard/Download/Course/136_1.json
                        coursePath = "/mnt/sdcard/Download/Course/" + course + "_" + i + ".json";
                        //Log.d("TAG", coursePath);
                        PushDataToBmob.PushDetailToCourse(coursePath);
                    }
                    item++;
                }
                Log.d("TAG", "PushDetailToCourse done");
                break;
            default:
                break;
        }
    }
}
