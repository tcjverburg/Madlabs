package com.example.gebruiker.madlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Gebruiker on 18-9-2016.
 */
public class FinalStory extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.final_story);

        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("finalStory");

        TextView storyTextview = (TextView) findViewById(R.id.story_textview);
        storyTextview.setText(previousActivity);

    }

}
