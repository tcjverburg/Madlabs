package com.example.gebruiker.madlabs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gebruiker on 14-9-2016.
 */


public class WordInput extends Activity {
    public Story story;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityThatCalled = getIntent();
        String previousActivity = (String) activityThatCalled.getExtras().get("callingActivity");
        setContentView(R.layout.activity_word_input);
        runInitial();
    }

    public String getUserInput()
    {
        EditText inputText = (EditText) findViewById((R.id.user_input));
        return String.valueOf(inputText.getText());
    }

    public Story runInitial(){
        InputStream stream = main();
        return story = new Story(stream);
    }

    public void OnSendUserInput(View view) throws IOException {

        String placeholder = story.getNextPlaceholder();
        String newWord = getUserInput();
        story.fillInPlaceholder(newWord);
        int tel = story.getPlaceholderRemainingCount();
        TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
        firsttextview.setText(tel + " words remaining");
        if (tel==0){
            Intent getNameScreen = new Intent(this, FinalStory.class);
            getNameScreen.putExtra("finalStory", story);
            startActivity(getNameScreen);
        }



    }

    public InputStream main()
    {
            InputStream stream = getResources().openRawResource(R.raw.madlib0_simple);
            return stream;
    }

}
