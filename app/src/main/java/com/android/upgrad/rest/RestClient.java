package com.android.upgrad.rest;

import com.android.upgrad.rest.services.GitHubAPI;
import com.android.upgrad.util.AppBuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RestClient {

    private static Retrofit restAdapter;
    private static GitHubAPI githubAPI;

    static {
        setupRestClient();
    }

    private static void setupRestClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .addInterceptor(new LoggingInterceptor())
                .build();
        restAdapter = new Retrofit.Builder()
                .baseUrl(AppBuildConfig.getBaseURL())
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static GitHubAPI getGitHubAPI() {
        if (githubAPI == null) {
            githubAPI = restAdapter.create(GitHubAPI.class);
        }
        return githubAPI;
    }
}
