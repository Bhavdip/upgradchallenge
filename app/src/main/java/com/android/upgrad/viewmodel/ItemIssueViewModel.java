package com.android.upgrad.viewmodel;

import android.databinding.ObservableField;

import com.android.upgrad.rest.response.Issue;

public class ItemIssueViewModel {
    private Issue issueRowData;
    public ObservableField<String> issueTitle = new ObservableField<>();
    public ObservableField<String> reporterName = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();

    public ItemIssueViewModel(Issue argumentData) {
        issueRowData = argumentData;
        issueTitle.set(issueRowData.getTitle());
        reporterName.set(issueRowData.getUser().getLogin());
        description.set(issueRowData.getBody());
    }
}
