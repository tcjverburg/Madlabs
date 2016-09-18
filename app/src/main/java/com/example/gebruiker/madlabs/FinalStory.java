package com.example.gebruiker.madlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Gebruiker on 18-9-2016.
 */

public class FinalStory extends Activity {
    private TextView storyTextview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_story);
        //intent and gets extra data from WordInput activity
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("finalStory");
        //enters entire story in textview
        TextView storyTextview = (TextView) findViewById(R.id.story_textview);
        storyTextview.setText(previousActivity);

    }


}
