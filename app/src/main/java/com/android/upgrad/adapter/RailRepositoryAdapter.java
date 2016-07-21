package com.android.upgrad.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.upgrad.R;
import com.android.upgrad.databinding.ItemOpenIssue;
import com.android.upgrad.rest.response.Issue;
import com.android.upgrad.viewmodel.ItemIssueViewModel;

import java.util.ArrayList;
import java.util.List;

public class RailRepositoryAdapter extends RecyclerView.Adapter {
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;
    private int visibleThreshold = 3;
    private List<Issue> issueList = new ArrayList<>();
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    public RailRepositoryAdapter(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager
                            .findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }
                }
            });
        }
    }

    public void setLoaded() {
        loading = false;
    }

    public void addIssueList(List<Issue> nwIssueList) {
        issueList.addAll(nwIssueList);
    }

    public void addProgressBar() {
        issueList.add(null);
        notifyItemInserted(issueList.size() - 1);
    }

    public void removeProgressBar() {
        issueList.remove(issueList.size() - 1);
        notifyItemRemoved(issueList.size());
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder rh;
        if (viewType == VIEW_ITEM) {
            ItemOpenIssue openIssueItem = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_issue, parent, false);
            rh = new IssueViewHolder(openIssueItem);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paginationprogress, parent, false);
            rh = new ProgressViewHolder(v);
        }
        return rh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IssueViewHolder) {
            ((IssueViewHolder) holder).bindIssueContent(issueList.get(position));
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return issueList.get(position) != null ? VIEW_ITEM : VIEW_PROG;
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

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
