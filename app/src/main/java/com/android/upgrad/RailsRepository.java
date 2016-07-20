package com.android.upgrad;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.android.upgrad.adapter.RailRepositoryAdapter;
import com.android.upgrad.databinding.RepositoryDataBinding;
import com.android.upgrad.rest.RestClient;
import com.android.upgrad.rest.response.Issue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.QueryMap;

/**
 *
 */
public class RailsRepository extends AppCompatActivity implements RepositoryViewModel.RepositoryListener {

    private RepositoryDataBinding repositoryDataBinding;
    private RepositoryViewModel repositoryViewModel;
    private RailRepositoryAdapter railRepositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repositoryDataBinding = DataBindingUtil.setContentView(this, R.layout.rails_repository);
        repositoryViewModel = new RepositoryViewModel(this);
        repositoryDataBinding.setViewmodel(repositoryViewModel);
        repositoryViewModel.onCreate(this);
    }


    @Override
    public void setUpRepositoryList() {
        railRepositoryAdapter = new RailRepositoryAdapter();
        repositoryDataBinding.openIssuesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        repositoryDataBinding.openIssuesList.setHasFixedSize(true);
        repositoryDataBinding.openIssuesList.setAdapter(railRepositoryAdapter);
    }

    @Override
    public void loadRepository() {
        Map<String,String> params = new HashMap<>();
        params.put("page", "1");
        params.put("pageSize", "2");
        params.put("sort", "updated");
        Call<List<Issue>> listOfIssues = RestClient.getGitHubAPI().getOpenIssuesOfRail(params);
        listOfIssues.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                if (response.isSuccessful()) {
                    List<Issue> responseIssuesList = response.body();
                    if (responseIssuesList != null && responseIssuesList.size() > 0) {
                        railRepositoryAdapter.addIssueList(responseIssuesList);
                        railRepositoryAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
            }
        });
    }
}
