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
        EditText();
    }

    public Story runInitial(){
        InputStream stream = input_stream();
        return story = new Story(stream);
    }

    public void EditText(){
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText)findViewById(R.id.user_input);
        hint.setHint( "<" + placeholder + ">");

    }

    public void OnSendUserInput(View view) throws IOException {
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText)findViewById(R.id.user_input);
        hint.setHint("<" + placeholder + ">");
        String newWord = getUserInput();
        if("".equals(newWord))
        {
            hint.setHint("enter a <" + placeholder + ">");
            }
        else{
            story.fillInPlaceholder(newWord);
            hint.setText("");
            String placeholderContinued = story.getNextPlaceholder();
            hint.setHint("<" + placeholderContinued + ">");
        }
        int tel = story.getPlaceholderRemainingCount();
        TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
        firsttextview.setText(tel + " word(s) remaining");

        if (tel==0){
            String story_end = story.toString();
            Intent getNameScreen = new Intent(this, FinalStory.class);
            getNameScreen.putExtra("finalStory", story_end);
            startActivity(getNameScreen);
            finish();
        }

    }

    public InputStream input_stream()
    {
        InputStream stream = getResources().openRawResource(R.raw.madlib2_university);
        return stream;
    }

    public String getUserInput()
    {
        EditText inputText = (EditText) findViewById((R.id.user_input));
        return String.valueOf(inputText.getText());
    }

}