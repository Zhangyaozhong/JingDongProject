package com.bwie.android.week20190105.presenter;

import com.bwie.android.week20190105.bean.LeftBean;
import com.bwie.android.week20190105.bean.RightBean;
import com.bwie.android.week20190105.contract.ClassifyContract;
import com.bwie.android.week20190105.model.ClassifyModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class ClassifyPresenter extends ClassifyContract.ClassifyPresenter {
    private ClassifyContract.IClassifyView iClassifyView;
    private ClassifyModel classifyModel;

    public ClassifyPresenter(ClassifyContract.IClassifyView iClassifyView) {
        this.iClassifyView = iClassifyView;
        classifyModel = new ClassifyModel();
    }

    @Override
    public void getLeftData(HashMap<String, String> params) {
        if (classifyModel != null) {
            classifyModel.getListData(params, new ClassifyModel.ClassifyCallback() {
                @Override
                public void leftSuccess(String result) {
                    Gson gson = new Gson();
                    LeftBean leftBean = gson.fromJson(result, LeftBean.class);
                    List<LeftBean.DataBean> data = leftBean.data;
                    if (iClassifyView != null) {
                        iClassifyView.LeftSuccess(data);
                    }
                }

                @Override
                public void rightSUccess(String result) {

                }


                @Override
                public void leftFailure(String error) {
                    if (iClassifyView != null) {
                        iClassifyView.leftFailure(error);
                    }
                }

                @Override
                public void rightFailure(String error) {

                }

            });
        }
    }

    @Override
    public void getRightData(HashMap<String, String> params) {
        if (classifyModel != null) {
            classifyModel.getRightData(params, new ClassifyModel.ClassifyCallback() {
                @Override
                public void leftSuccess(String result) {

                }

                @Override
                public void rightSUccess(String result) {
                    Gson gson = new Gson();
                    RightBean rightBean = gson.fromJson(result, RightBean.class);
                    List<RightBean.DatasBean> data = rightBean.data;
                    if (iClassifyView != null) {
                        iClassifyView.RightSucess(data);
                    }
                }


                @Override
                public void leftFailure(String error) {

                }

                @Override
                public void rightFailure(String error) {
                    if (iClassifyView != null) {
                        iClassifyView.rightFailure(error);
                    }
                }

            });
        }
    }
}
