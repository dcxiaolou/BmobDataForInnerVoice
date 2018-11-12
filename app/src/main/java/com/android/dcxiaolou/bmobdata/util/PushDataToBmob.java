package com.android.dcxiaolou.bmobdata.util;

import android.util.Log;

import com.android.dcxiaolou.bmobdata.mode.Answer;
import com.android.dcxiaolou.bmobdata.mode.CourseDetail;
import com.android.dcxiaolou.bmobdata.mode.CourseIntroduce;
import com.android.dcxiaolou.bmobdata.mode.FM;
import com.android.dcxiaolou.bmobdata.mode.Question;
import com.android.dcxiaolou.bmobdata.mode.ReadArticle;
import com.android.dcxiaolou.bmobdata.mode.ReadCommon;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

public class PushDataToBmob {

    private final static String TAG = "PushDataToBmob";

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

    //将Read->Common->.json文件上传到Bmob素材中，然后存入bmob数据库中
    public static void PushCommon(final String type, final String no, String commonPath) {
        final BmobFile file = new BmobFile(new File((commonPath)));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    final String fileName = file.getFilename();
                    final ReadCommon common = new ReadCommon();
                    Log.d(TAG, "upload common " + fileName);
                    common.setType(type);
                    common.setNo(no);
                    common.setCommon(file);
                    common.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add common " + fileName + "to db");
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

    //将Course下的introduce文件上传到Bmob素材中，然后存入bmob数据库中
    public static void PushIntroduceToCourse(String coursePath) {
        final BmobFile file = new BmobFile(new File(coursePath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG, "upload courseIntroduce " + file.getFilename());
                    CourseIntroduce courseIntroduce = new CourseIntroduce();
                    courseIntroduce.setIntroduce(file);
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
                    courseDetail.setDetail(file);
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


    //将FM下的文件上传到bmob素材中，然后存入到bmob数据库中
    public static void PushFMToBmob(final String type, final String kind, String fmPath) {
        final BmobFile file = new BmobFile(new File(fmPath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG, "upload fm " + file.getFilename());
                    FM fm = new FM();
                    fm.setType(type);
                    fm.setKind(kind);
                    fm.setFm(file);
                    fm.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add " + file.getFilename() + " to db");
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

    //将QuestionAndAnswer中的Question文件上传到bmob素材中， 然后在存入bmob数据库中
    public static void PushQuestionToBmob(String questionPath) {
        final BmobFile file = new BmobFile(new File(questionPath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG,"upload question " + file.getFilename());
                    Question question = new Question();
                    question.setQuestion(file);
                    question.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add " + file.getFilename() + " to db");
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

    //将QuestionAndAnswer中的Answer文件上传到bmob素材中， 然后在存入bmob数据库中
    public static void PushAnswerToBmob(final String type, String answerPath) {
        final BmobFile file = new BmobFile(new File(answerPath));
        file.uploadblock(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Log.d(TAG,"upload answer " + file.getFilename());
                    Answer answer = new Answer();
                    answer.setType(type);
                    answer.setAnswer(file);
                    answer.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                Log.d(TAG, "add " + file.getFilename() + " to db");
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