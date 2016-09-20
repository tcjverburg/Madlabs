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
    private Story story;
    public int story_filledIn;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Intent from Main Activity
        Intent activityThatCalled = getIntent();
        setContentView(R.layout.activity_word_input);
        if (savedInstanceState != null){
            Story story_old = (Story)savedInstanceState.getSerializable("story");
            story = story_old;
        }
        if(savedInstanceState == null){
        createStory();
        }
        editText();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }


    //creates stream for parameter Story class from text file
    public InputStream input_stream()
    {
        InputStream stream = getResources().openRawResource(R.raw.madlib2_university);
        return stream;
    }
    //constructor for story class
    public Story createStory(){
        InputStream stream = input_stream();
        return story = new Story(stream);
    }




    //Edits the editText of activity_word_input.xml and sets the hint with what kind of word should be entered
    public String editText(){
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText)findViewById(R.id.user_input);
        hint.setHint( "<" + placeholder + ">");
        int count = story.getPlaceholderRemainingCount();
        TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
        firsttextview.setText(count + " word(s) remaining");
        return placeholder;

    }

    //processes input from user to a string
    public String getUserInput()
    {
        EditText inputText = (EditText) findViewById((R.id.user_input));
        return String.valueOf(inputText.getText());
    }

    //method for what happens when button is clicked
    public void OnSendUserInput(View view) throws IOException {
        //shows the amount of words left to be entered
        int count = story.getPlaceholderRemainingCount();
        //if there are no more words to be entered, new intent for final story is executed
        //sets placeholder, hints on ever new click and receives input from user of which word has been entered
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText) findViewById(R.id.user_input);

        //gets new word from method getUserInput
        String newWord = getUserInput();
        //makes sure empty strings are not attached and gives feedback to user
        if ("".equals(newWord)) {
            hint.setHint("enter a <" + placeholder + ">");
        }
        //adds new word to story instance and changes the placeholder
        else {
            story.fillInPlaceholder(newWord);
            if (count!=1){
            hint.setText("");
            String placeholderContinued = story.getNextPlaceholder();
            hint.setHint("<" + placeholderContinued + ">");
            int second_count = story.getPlaceholderRemainingCount();
            TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
            firsttextview.setText(second_count + " word(s) remaining");}

            else {
                //finishes story
                String story_end = story.toString();
                //intent to start new activity FinalStory
                Intent getNameScreen = new Intent(this, FinalStory.class);
                //passes extra data story_end
                getNameScreen.putExtra("finalStory", story_end);
                startActivity(getNameScreen);
                //finishes current activity
                finish();
            }
        }


    }
            }
