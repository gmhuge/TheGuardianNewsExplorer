package com.example.android.theguardiannewsexplorer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<NewsStory> {

    public NewsAdapter(Context context, List<NewsStory> earthquakes) {
        super(context, 0, earthquakes);
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
        sectionView.setText(String.valueOf(currentNewsStory.getSection()));

        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(String.valueOf(currentNewsStory.getAuthor()));

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(String.valueOf(currentNewsStory.getDate()));


        TextView urlView = (TextView) listItemView.findViewById(R.id.url);
        urlView.setText(String.valueOf(currentNewsStory.getUrl()));


        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

