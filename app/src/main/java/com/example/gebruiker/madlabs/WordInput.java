package com.example.gebruiker.madlabs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gebruiker on 14-9-2016.
 */


public class WordInput extends Activity {

    private TextView firsttextview;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityThatCalled = getIntent();
        String previousActivity = (String) activityThatCalled.getExtras().get("callingActivity");
        setContentView(R.layout.activity_word_input);


    }

    public void OnSendUserInput(View view) throws IOException {
        InputStream scan = main();

    }

    public InputStream main() throws IOException
    {
        try {
            InputStream stream = new FileInputStream(new File("res.raw.madlib1_tarzan"));
            TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
            firsttextview.setText("Gelukt");
            return stream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
            firsttextview.setText("Niet Gelukt");
        }
        return null;
    }



}
