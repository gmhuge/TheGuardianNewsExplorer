package com.example.android.theguardiannewsexplorer;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsStory>> {
    private static final String LOG_TAG = NewsLoader.class.getName();
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsStory> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<NewsStory> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }

}

