package com.android.dcxiaolou.bmobdata.util;

import android.util.Log;

import com.android.dcxiaolou.bmobdata.mode.CourseDetail;
import com.android.dcxiaolou.bmobdata.mode.CourseIntroduce;
import com.android.dcxiaolou.bmobdata.mode.ReadArticle;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

public class PushDataToBmob {

    private final static String TAG = "PushDataToBmob";

    private String articlePath;

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    //将Read->Article->.json文件上传到Bmob素材中，然后存入bmob数据库中，不然会出错：invalid file: filename empty.
    public static void PushArticle(String articlePath, final String type) {
        final BmobFile bombFile = new BmobFile(new File(articlePath));
        bombFile.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    final String fileName = bombFile.getFilename();
                    Log.d(TAG, "upload article " + fileName);
                    final ReadArticle readArticle = new ReadArticle();
                    readArticle.setType(type);
                    readArticle.setBmobFile(bombFile);
                    readArticle.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add article " + fileName + " to db");
                            } else {
                                Log.d(TAG, e.getMessage());
                            }
                        }
                    });
                } else {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

    //将Course下的introduce文件上传到Bmob素材中，然后存入bmob数据库中
    public static void PushIntroduceToCourse(String coursePath) {
        final BmobFile file = new BmobFile(new File(coursePath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG, "upload courseIntroduce " + file.getFilename());
                    CourseIntroduce courseIntroduce = new CourseIntroduce();
                    courseIntroduce.setCourse(file);
                    courseIntroduce.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add courseIntroduce " + file.getFilename() + " to db");
                            } else {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    e.printStackTrace();
                }
            }
        });
    }

    //将Course下的detail文件上传到Bmob素材中，然后存入bmob数据库中
    public static void PushDetailToCourse(String coursePath) {
        final BmobFile file = new BmobFile(new File(coursePath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG, "upload courseIntroduce " + file.getFilename());
                    CourseDetail courseDetail = new CourseDetail();
                    courseDetail.setCourse(file);
                    courseDetail.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add courseIntroduce " + file.getFilename() + " to db");
                            } else {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    e.printStackTrace();
                }
            }
        });
    }

}