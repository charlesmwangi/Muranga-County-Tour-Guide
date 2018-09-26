package com.example.android.murangacountytourguide.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.murangacountytourguide.R;

public class SingleAttractionActivity extends AppCompatActivity implements View.OnClickListener {
    //instance variables
    private TextView title, desc;
    private Button location;
    private ImageView image;
    private String Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_details);
        //REFERENCE VIEWS
        title = findViewById(R.id.title1);
        desc = findViewById(R.id.detail_long_desc_tv);
        image = findViewById(R.id.detail_image_view);
        location = findViewById(R.id.detail_show_in_map_button);

        //DETERMINE WHO STARTED THIS ACTIVITY
        final String sender = this.getIntent().getExtras().getString("SENDER_KEY");

        //IF ITS THE FRAGMENT THEN RECEIVE DATA
        if (sender != null) {
            // this.receiveData();
            //RECEIVE DATA VIA INTENT
            Intent i = getIntent();
            String name = i.getStringExtra("title_key");
            int Image = i.getIntExtra("Image_KEY", 0);
            String Desc = i.getStringExtra("Desc_KEY");
            Location = i.getStringExtra("location_KEY");
            //Display the data received
            title.setText(name);
            desc.setText(Desc);
            if (Image != -1) {
                image.setImageResource(Image);
            } else {
                image.setVisibility(View.GONE);
            }
            //set onclick listener on the show in map button
            location.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        // Perform action on click
        switch (v.getId()) {
            case R.id.detail_show_in_map_button:
                // Creates an Intent that will load a map
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(Location);
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
        }
    }
}
