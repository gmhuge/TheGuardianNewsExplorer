package com.example.android.theguardiannewsexplorer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class NewsAdapter extends ArrayAdapter<NewsStory> {

    public NewsAdapter(Context context, List<NewsStory> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_news_item, parent, false);
        }

        NewsStory currentNewsStory = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(String.valueOf(currentNewsStory.getTitle()));

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(String.valueOf(currentNewsStory.getSection().concat(":")));

        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(String.valueOf(currentNewsStory.getAuthor()));

        String result = "";

        try {
            String oldDateString = currentNewsStory.getDate().substring(0, 10);
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

            Date date = oldDateFormat.parse(oldDateString);
            result = newDateFormat.format(date);

        } catch (java.text.ParseException e) {
            Log.e("NewsAdapter", "Invalid date conversation", e);
        }
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(result);

        TextView urlView = (TextView) listItemView.findViewById(R.id.url);
        urlView.setText(String.valueOf(currentNewsStory.getUrl()));

        int color;
        if (position % 2 == 0) {
            color = ContextCompat.getColor(getContext(), R.color.color_even);
        } else {
            color = ContextCompat.getColor(getContext(), R.color.color_not_even);
        }
        LinearLayout container = listItemView.findViewById(R.id.item_container);
        container.setBackgroundColor(color);
        return listItemView;
    }

}

