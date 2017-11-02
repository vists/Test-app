package com.test.app.myapplication.ui.activity.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.app.myapplication.BR;
import com.test.app.myapplication.R;
import com.test.app.myapplication.pojo.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vist on 08.11.2016.
 */

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.BindingHolder> {
    private List<UserData> mUserDataList = new ArrayList<>();

    public UserDataAdapter() {
    }


    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        private BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {

        View
                v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_data, parent, false);

        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final UserData userData = mUserDataList.get(position);
        holder.getBinding().setVariable(BR.userData, userData);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mUserDataList.size();
    }

    public void setItems(List<UserData> caseNotesList) {
        if (mUserDataList.size() > 0)
            mUserDataList.clear();
        mUserDataList.addAll(caseNotesList);
        notifyDataSetChanged();
    }

    public UserData getItem(int position) {
        return mUserDataList.get(position);

    }

}

