package com.example.android.murangacountytourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class TourAdapter extends ArrayAdapter<TourItem> {

    public TourAdapter(Context context, ArrayList<TourItem> tourItemArrayList) {
        super(context, 0, tourItemArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TourItem tourItem = getItem(position);
        //inflate the layout to display the tour item
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
       //find the views defined in the layout
        ImageView imageView = convertView.findViewById(R.id.list_item_image);
        TextView titleTextView = convertView.findViewById(R.id.list_item_title_text_view);
        TextView descTextView = convertView.findViewById(R.id.list_item_brief_desc_text_view);
        TextView locTextView = convertView.findViewById(R.id.location_text_view);

        // Check if an image is provided for this word or not
        if (tourItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(tourItem.getImage());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        //set text to different views in the layout
        titleTextView.setText(tourItem.getTitle());
        descTextView.setText(tourItem.getEventDesc());
        locTextView.setText(tourItem.getLocation());

        return convertView;
    }
}
