package com.android.upgrad.viewmodel;

import android.app.Activity;
import android.content.Intent;

/**
 * Interface that every ViewModel must implement
 */
public interface ActivityViewModel {

    void onCreate(Activity activity);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onResumeActivity(Activity activity);

    void onPauseActivity(Activity activity);

    void onDestroy();
}
