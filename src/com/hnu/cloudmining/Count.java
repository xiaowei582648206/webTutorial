package com.hnu.cloudmining;

/**
 * Created by Administrator on 2019/3/11.
 */
public class Count {
    private int count = 0;

    public Count() {
    }

    public int getCount() {
        return ++this.count;
    }

    public void setCount(int var1) {
        this.count = var1;
    }
}
