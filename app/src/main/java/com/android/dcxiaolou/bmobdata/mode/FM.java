package com.android.dcxiaolou.bmobdata.mode;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class FM extends BmobObject {

    private String type; //大类

    private String kind; //大类中的小类

    private BmobFile fm;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public BmobFile getFm() {
        return fm;
    }

    public void setFm(BmobFile fm) {
        this.fm = fm;
    }
}
