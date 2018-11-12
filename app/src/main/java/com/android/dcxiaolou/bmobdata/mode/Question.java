package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Question extends BmobObject {

    private BmobFile question;

    public BmobFile getQuestion() {
        return question;
    }

    public void setQuestion(BmobFile question) {
        this.question = question;
    }
}
