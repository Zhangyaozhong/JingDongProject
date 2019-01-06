package com.bwie.android.week20190105.net;

public interface OkCallback {
    void failure(String msg);

    void success(String result);
}
