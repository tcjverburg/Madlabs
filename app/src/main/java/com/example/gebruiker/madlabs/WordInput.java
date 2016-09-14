package com.example.gebruiker.madlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Gebruiker on 14-9-2016.
 */
public class WordInput extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_input);
        Intent activityThatCalled = getIntent();
        String previousActivity = (String) activityThatCalled.getExtras().get("callingActivity");
    }
}
