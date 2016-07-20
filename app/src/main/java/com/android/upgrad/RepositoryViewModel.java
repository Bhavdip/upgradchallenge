package com.android.upgrad;

import android.app.Activity;
import android.content.Intent;

import com.android.upgrad.viewmodel.ActivityViewModel;

public class RepositoryViewModel implements ActivityViewModel {

    private RepositoryListener listener;

    public interface RepositoryListener {
        void setUpRepositoryList();
        void loadRepository();
    }

    public RepositoryViewModel(RepositoryListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Activity activity) {
        this.listener.setUpRepositoryList();
        this.listener.loadRepository();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onResumeActivity(Activity activity) {
    }

    @Override
    public void onPauseActivity(Activity activity) {
    }

    @Override
    public void onDestroy() {
    }
}
