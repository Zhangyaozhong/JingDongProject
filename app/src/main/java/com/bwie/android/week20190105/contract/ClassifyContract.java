package com.bwie.android.week20190105.contract;

import com.bwie.android.week20190105.bean.LeftBean;
import com.bwie.android.week20190105.bean.RightBean;
import com.bwie.android.week20190105.model.ClassifyModel;

import java.util.HashMap;
import java.util.List;

public interface ClassifyContract {
    abstract class ClassifyPresenter {
        public abstract void getLeftData(HashMap<String, String> params);

        public abstract void getRightData(HashMap<String, String> params);
    }

    interface IClassifyModel {
        void getListData(HashMap<String, String> params, ClassifyModel.ClassifyCallback classifyCallback);

        void getRightData(HashMap<String, String> params, ClassifyModel.ClassifyCallback classifyCallback);
    }
    interface IClassifyView{
        void LeftSuccess(List<LeftBean.DataBean> dataBean);
        void RightSucess(List<RightBean.DatasBean> childData);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
