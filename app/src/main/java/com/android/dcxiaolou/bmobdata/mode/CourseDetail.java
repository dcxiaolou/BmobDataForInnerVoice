package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class CourseDetail extends BmobObject {

    private BmobFile detail;

    public BmobFile getCourse() {
        return detail;
    }

    public void setCourse(BmobFile detail) {
        this.detail = detail;
    }
}
