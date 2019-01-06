package com.bwie.android.week20190105.model;

import com.bwie.android.week20190105.api.ClassifyApi;
import com.bwie.android.week20190105.contract.ClassifyContract;
import com.bwie.android.week20190105.net.OkCallback;
import com.bwie.android.week20190105.net.OkhttpUtil;

import java.util.HashMap;

public class ClassifyModel implements ClassifyContract.IClassifyModel {
    @Override
    public void getListData(HashMap<String, String> params, final ClassifyCallback classifyCallback) {
        OkhttpUtil.getInstance().doPost(ClassifyApi.LEFT_URL, params, new OkCallback() {
            @Override
            public void failure(String msg) {
                if (classifyCallback!=null){
                    classifyCallback.leftFailure(msg);
                }
            }

            @Override
            public void success(String result) {
                if (classifyCallback!=null){
                    classifyCallback.leftSuccess(result);
                }
            }
        });
    }

    @Override
    public void getRightData(HashMap<String, String> params, final ClassifyCallback classifyCallback) {
        OkhttpUtil.getInstance().doPost(ClassifyApi.RIGHT_URL, params, new OkCallback() {
            @Override
            public void failure(String msg) {
                if (classifyCallback!=null){
                    classifyCallback.rightFailure(msg);
                }
            }

            @Override
            public void success(String result) {
                if (classifyCallback!=null){
                    classifyCallback.rightSUccess(result);
                }
            }
        });
    }

    public interface ClassifyCallback {
        void leftSuccess(String result);

        void rightSUccess(String result);

        void leftFailure(String error);

        void rightFailure(String error);
    }
    private ClassifyCallback classifyCallback;

    public void setClassifyCallback(ClassifyCallback classifyCallback) {
        this.classifyCallback = classifyCallback;
    }
}
