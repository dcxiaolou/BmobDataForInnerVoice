package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class ReadArticle extends BmobObject {

    private String id;
    private BmobFile bmobFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BmobFile getBmobFile() {
        return bmobFile;
    }

    public void setBmobFile(BmobFile bmobFile) {
        this.bmobFile = bmobFile;
    }
}
