package com.android.upgrad.rest.services;

import com.android.upgrad.rest.response.Issue;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface GitHubAPI {
    @GET("repos/rails/rails/issues")
    Call<List<Issue>> getOpenIssuesOfRail(@QueryMap Map<String, String> options);
}
