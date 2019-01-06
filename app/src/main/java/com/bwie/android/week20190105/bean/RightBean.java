package com.bwie.android.week20190105.bean;

import java.util.List;

public class RightBean {
    public String code;
    public String msg;
    public List<DatasBean> data;

    public class DatasBean {
        public List<ChildData> list;
        public String pcid;
        public String name;

        public class ChildData {
            public String name;
            public String icon;
        }
    }

}
