package com.bwie.android.week20190105.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.android.week20190105.R;
import com.bwie.android.week20190105.adapter.LeftAdapter;
import com.bwie.android.week20190105.adapter.RightAdapter;
import com.bwie.android.week20190105.bean.LeftBean;
import com.bwie.android.week20190105.bean.RightBean;
import com.bwie.android.week20190105.contract.ClassifyContract;
import com.bwie.android.week20190105.presenter.ClassifyPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClsFragmennt extends Fragment implements ClassifyContract.IClassifyView, LeftAdapter.ItemClickListener {
    @BindView(R.id.rv_left)
    RecyclerView rv_left;
    @BindView(R.id.rv_right)
    RecyclerView rv_right;
    private ClassifyPresenter classifyPresenter;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private String id =  "1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cls_fragmennt, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        classifyPresenter = new ClassifyPresenter(this);
        rv_left.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_right.setLayoutManager(new LinearLayoutManager(getActivity()));
        classifyPresenter.getLeftData(new HashMap<String, String>());
        getRight();
    }

    private void getRight() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cid",id);
        classifyPresenter.getRightData(hashMap);
    }

    @Override
    public void LeftSuccess(List<LeftBean.DataBean> dataBean) {
        if (leftAdapter == null) {
            leftAdapter = new LeftAdapter(getActivity(), dataBean);
            rv_left.setAdapter(leftAdapter);
            leftAdapter.setItemClickListener(this);
        } else {
            leftAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void RightSucess(List<RightBean.DatasBean> childData) {
            rightAdapter = new RightAdapter(getActivity(), childData);
            rv_right.setAdapter(rightAdapter);
    }

    @Override
    public void leftFailure(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightFailure(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void click(String cid) {
        id=cid;
        getRight();
    }
}
