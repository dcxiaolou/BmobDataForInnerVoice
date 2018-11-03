package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class CourseIntroduce extends BmobObject {

    private BmobFile introduce;

    public BmobFile getCourse() {
        return introduce;
    }

    public void setCourse(BmobFile introduce) {
        this.introduce = introduce;
    }
}
