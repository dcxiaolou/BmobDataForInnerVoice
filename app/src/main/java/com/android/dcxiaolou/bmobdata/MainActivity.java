package com.android.dcxiaolou.bmobdata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.dcxiaolou.bmobdata.util.PushDataToBmob;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mPushDataToArticle, mPushIntroduceToCourse, mPushDetailToCourse,
            mPushDataToCommon, mPushFmToBmob, mPushQuestionToBmob, mPushAnswerToBmob;

    private List<String> articleTypes = new ArrayList<>();;
    private List<String> courseID = new ArrayList<>();
    private List<Integer> coursedetail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "35c39c93bd729b73efb27f9d8df9e72d");
        mPushDataToArticle = (Button) findViewById(R.id.btn_push_data_to_article);
        mPushIntroduceToCourse = (Button) findViewById(R.id.btn_push_introduce_to_course);
        mPushDetailToCourse = (Button) findViewById(R.id.btn_push_detail_to_course);
        mPushDataToCommon = (Button) findViewById(R.id.btn_push_data_to_common);
        mPushFmToBmob = (Button) findViewById(R.id.btn_push_FM_to_bmob);
        mPushQuestionToBmob = (Button) findViewById(R.id.btn_push_question_to_bmob);
        mPushAnswerToBmob = (Button) findViewById(R.id.btn_push_answer_to_bmob);

        mPushDataToArticle.setOnClickListener(this);
        mPushIntroduceToCourse.setOnClickListener(this);
        mPushDetailToCourse.setOnClickListener(this);
        mPushDataToCommon.setOnClickListener(this);
        mPushFmToBmob.setOnClickListener(this);
        mPushQuestionToBmob.setOnClickListener(this);
        mPushAnswerToBmob.setOnClickListener(this);

        articleTypes.add("792");
        articleTypes.add("876");
        articleTypes.add("660");
        articleTypes.add("2206");
        articleTypes.add("2199");
        articleTypes.add("862");
        articleTypes.add("823");
        articleTypes.add("844");

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
                String articlePath;
                for (String type : articleTypes) {
                    for (int i = 1; i <= 20; i++) {
                        // /mnt/sdcard/Download/Read/Article/2206_9.json
                        articlePath = "/mnt/sdcard/Download/Read/Article/" + type + "_" + i + ".json";
                        //PushDataToBmob.PushArticle(articlePath, type);
                    }
                }
                Log.d("TAG", "push data to article done");
                break;

            case R.id.btn_push_data_to_common:
                // upload common 876_5_4.json 8 往bmob上传大量文件一定要分开分段传，不然会失败
                String commonPath;
                for (int t = 7; t < 8; t++) {
                    String type = articleTypes.get(t);
                    for (int i = 1; i <= 20; i++) {
                        for (int j = 1; j <= 20; j++) {
                            // /sdcard/Download/Read/Common/2199_10_1.json
                            commonPath = "/sdcard/Download/Read/Common/" + type + "_" + i + "_" + j + ".json";
                            File file = new File(commonPath);
                            if (!file.exists()) {
                                continue;
                            }
                            //Log.d("TAG", commonPath);
                            //PushDataToBmob.PushCommon(type, "" + i, commonPath);
                        }
                    }
                }
                break;

            case R.id.btn_push_introduce_to_course:
                String courseIntroducePath;
                for (String id : courseID) {
                    courseIntroducePath = "/mnt/sdcard/Download/Course/introduce/" + id + ".json";
                    //PushDataToBmob.PushIntroduceToCourse(courseIntroducePath);
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
                        // /sdcard/Download/Course/detail/136_1.json
                        coursePath = "/mnt/sdcard/Download/Course/detail/" + course + "_" + i + ".json";
                        //Log.d("TAG", coursePath);
                        //PushDataToBmob.PushDetailToCourse(coursePath);
                    }
                    item++;
                }
                Log.d("TAG", "PushDetailToCourse done");
                break;

            case R.id.btn_push_FM_to_bmob:
                String fmPath;
                //一定要分开上传，亲测有效哦
                for (int i = 3; i <= 3; i++) {
                    for (int j = 7; j <= 9; j++) {
                        for (int k = 1; k <= 20; k++) {
                            // /sdcard/Download/FM/1_1_1.json
                            fmPath = "/sdcard/Download/FM/" + i + "_" + j + "_" + k + ".json";
                            //PushDataToBmob.PushFMToBmob("" + i, "" + j, fmPath);
                        }
                    }
                }
                break;

            case R.id.btn_push_question_to_bmob:
                // /sdcard/Download/QuestionAndAnswer/Question/1.json
                String questionPath;
                for (int i = 1; i <= 50; i++) {
                    questionPath = "/sdcard/Download/QuestionAndAnswer/Question/" + i + ".json";
                    Log.d("TAG", questionPath);
                    //PushDataToBmob.PushQuestionToBmob(questionPath);
                }
                break;

            case R.id.btn_push_answer_to_bmob:
                // /sdcard/Download/QuestionAndAnswer/Answer/10_1.json
                String answerPath;
                //分批次上传
                for (int i = 41; i <= 50; i++) {
                    for (int j = 1; j <= 10; j++) {
                        answerPath = "/sdcard/Download/QuestionAndAnswer/Answer/" + i + "_" + j + ".json";
                        File file = new File(answerPath);
                        if (file.exists()) {
                            Log.d("TAG", answerPath);
                            PushDataToBmob.PushAnswerToBmob("" + i, answerPath);
                        }
                    }
                }
                break;

            default:
                break;
        }
    }
}
