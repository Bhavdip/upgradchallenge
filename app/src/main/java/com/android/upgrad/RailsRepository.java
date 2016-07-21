package com.android.upgrad;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.upgrad.adapter.RailRepositoryAdapter;
import com.android.upgrad.databinding.RepositoryDataBinding;
import com.android.upgrad.rest.RestClient;
import com.android.upgrad.rest.response.Issue;
import com.android.upgrad.util.ConnectivityHelper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class RailsRepository extends AppCompatActivity implements RepositoryViewModel.RepositoryListener, RailRepositoryAdapter.OnLoadMoreListener {

    private RepositoryDataBinding repositoryDataBinding;
    private RailRepositoryAdapter railRepositoryAdapter;
    private int pageNumber = 1;
    private int visibleThreshold = 15;
    private boolean isOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repositoryDataBinding = DataBindingUtil.setContentView(this, R.layout.rails_repository);
        RepositoryViewModel repositoryViewModel = new RepositoryViewModel(this);
        repositoryDataBinding.setViewmodel(repositoryViewModel);
        repositoryViewModel.onCreate(this);
    }


    @Override
    public void setUpRepositoryList() {
        repositoryDataBinding.openIssuesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        repositoryDataBinding.openIssuesList.setHasFixedSize(true);
        railRepositoryAdapter = new RailRepositoryAdapter(repositoryDataBinding.openIssuesList);
        repositoryDataBinding.openIssuesList.setAdapter(railRepositoryAdapter);
        railRepositoryAdapter.setOnLoadMoreListener(this);
    }

    @Override
    public void loadRepository() {
        loadIssueList(pageNumber);
    }

    @Override
    public void onLoadMore() {
        loadData();
    }

    private void loadData() {
        if (!isOver) {
            if (pageNumber != 1) {
                checkViewType();
            }
            loadIssueList(pageNumber);
        }
    }

    public void checkViewType() {
        railRepositoryAdapter.addProgressBar();
    }

    private void loadIssueList(int pageIndex) {
        if (ConnectivityHelper.getInstance().isConnected(getApplicationContext())) {
            repositoryDataBinding.connectionProblem.setVisibility(View.GONE);
            callOpenIssueList(pageIndex);
        } else {
            repositoryDataBinding.progressBar.setVisibility(View.GONE);
            repositoryDataBinding.connectionProblem.setVisibility(View.VISIBLE);
        }
    }

    private void callOpenIssueList(int pageIndex) {
        showProgressBar();
        Map<String, String> params = new LinkedHashMap<>();
        params.put("state", "open");
        params.put("sort", "updated");
        params.put("page", String.valueOf(pageIndex));
        params.put("per_page", String.valueOf(visibleThreshold));
        Call<List<Issue>> listOfIssues = RestClient.getGitHubAPI().getOpenIssuesOfRail(params);
        listOfIssues.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                if (response.isSuccessful()) {
                    if (pageNumber != 1) {
                        railRepositoryAdapter.removeProgressBar();
                    }
                    List<Issue> responseIssuesList = response.body();
                    if (responseIssuesList != null && responseIssuesList.size() > 0) {
                        isOver = checkPackageSize(responseIssuesList.size());
                        railRepositoryAdapter.addIssueList(responseIssuesList);
                        railRepositoryAdapter.notifyDataSetChanged();
                        railRepositoryAdapter.setLoaded();
                        pageNumber = (pageNumber + 1);
                    }
                    hideProgressBar();
                }
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
                hideProgressBar();
            }
        });
    }

    public boolean checkPackageSize(int packageSize) {
        if (packageSize < visibleThreshold) {
            return true;
        } else {
            return false;
        }
    }

    private void showProgressBar() {
        if (pageNumber == 1) {
            repositoryDataBinding.progressBar.setVisibility(View.VISIBLE);
        }
    }

    private void hideProgressBar() {
        repositoryDataBinding.progressBar.setVisibility(View.GONE);
    }
}
