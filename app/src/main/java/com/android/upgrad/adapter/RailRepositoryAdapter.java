package com.android.upgrad.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.upgrad.R;
import com.android.upgrad.databinding.ItemOpenIssue;
import com.android.upgrad.rest.response.Issue;
import com.android.upgrad.viewmodel.ItemIssueViewModel;

import java.util.ArrayList;
import java.util.List;

public class RailRepositoryAdapter extends RecyclerView.Adapter<RailRepositoryAdapter.IssueViewHolder> {

    private List<Issue> issueList = new ArrayList<>();

    public RailRepositoryAdapter() {
    }

    public void addIssueList(List<Issue> nwIssueList) {
        if (issueList.size() > 0) {
            issueList.clear();
        }
        issueList.addAll(nwIssueList);
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOpenIssue openIssueItem = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_issue, parent, false);
        return new IssueViewHolder(openIssueItem);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        holder.bindIssueContent(issueList.get(position));
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

    public static class IssueViewHolder extends RecyclerView.ViewHolder {

        private ItemOpenIssue mItemOpenIssue;

        public IssueViewHolder(ItemOpenIssue itemOpenIssue) {
            super(itemOpenIssue.getRoot());
            mItemOpenIssue = itemOpenIssue;
        }

        public void bindIssueContent(Issue issueData) {
            mItemOpenIssue.setViewmodel(new ItemIssueViewModel(issueData));
        }
    }
}
