package com.example.android.murangacountytourguide.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.murangacountytourguide.R;
import com.example.android.murangacountytourguide.TourAdapter;
import com.example.android.murangacountytourguide.TourItem;

import java.util.ArrayList;

public class HotelFragment extends Fragment {

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        //Create an ArrayList of TourItem
        final ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.Blue_Post_Hotel_name), getString(R.string.blue_post_hotel_desc), getString(R.string.blue_post_hotel_addr), R.drawable.blue_post_hotel));
        tourItems.add(new TourItem(getString(R.string.golden_palm_breeze_name), getString(R.string.golden_palm_breeze_desc), getString(R.string.golden_palm_breeze_addr), R.drawable.golden_palm_breeze_hotel));
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list_view.xml file.
        ListView listView = rootView.findViewById(R.id.list);
        // Create an {@link TourAdapter}, whose data source is a list of {@link TourItem}s. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each TourItem in the list of tourItems.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link TourAdapter} with the variable name tourAdapter.
        listView.setAdapter(tourAdapter);

        // Set a click listener to show details of the location when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> tourAdapter, View view, int position, long l) {
                // Get the {@link TourItem} object at the given position the user clicked on
                TourItem item = tourItems.get(position);
                sendData(item);
            }
        });

        return rootView;
    }

    private void sendData(TourItem item) {
        //INTENT OBJ
        Intent i = new Intent(getActivity().getBaseContext(),
                SingleAttractionActivity.class);

        //PACK DATA
        i.putExtra("SENDER_KEY", "MyFragment");
        i.putExtra("title_key", item.getTitle());
        i.putExtra("Image_KEY", Integer.valueOf(item.getImage()));
        i.putExtra("Desc_KEY", item.getEventDesc());
        i.putExtra("location_KEY", item.getLocation());

        //START ACTIVITY
        getActivity().startActivity(i);
    }

}
