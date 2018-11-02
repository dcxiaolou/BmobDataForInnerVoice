package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Course extends BmobObject {

    private BmobFile course;

    public BmobFile getCourse() {
        return course;
    }

    public void setCourse(BmobFile course) {
        this.course = course;
    }
}
