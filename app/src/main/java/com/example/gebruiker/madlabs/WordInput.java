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

        //Get Intent from Main Activity
        Intent activityThatCalled = getIntent();

        setContentView(R.layout.activity_word_input);

        //calls createStream and  editText methods
        createStory();
        editText();
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
    public void editText(){
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText)findViewById(R.id.user_input);
        hint.setHint( "<" + placeholder + ">");

    }

    //processes input from user to a string
    public String getUserInput()
    {
        EditText inputText = (EditText) findViewById((R.id.user_input));
        return String.valueOf(inputText.getText());
    }

    //method for what happens when button is clicked
    public void OnSendUserInput(View view) throws IOException {
        //sets placeholder, hints on ever new click and receives input from user of which word has been entered
        String placeholder = story.getNextPlaceholder();
        EditText hint = (EditText)findViewById(R.id.user_input);
        hint.setHint("<" + placeholder + ">");
        //gets new word from method getUserInput
        String newWord = getUserInput();

        //makes sure empty strings are not attached and gives feedback to user
        if("".equals(newWord))
        {
            hint.setHint("enter a <" + placeholder + ">");
            }
        //adds new word to story instance and changes the placeholder
        else{
            story.fillInPlaceholder(newWord);
            hint.setText("");
            String placeholderContinued = story.getNextPlaceholder();
            hint.setHint("<" + placeholderContinued + ">");
        }
        //shows the amount of words left to be entered
        int count = story.getPlaceholderRemainingCount();
        TextView firsttextview = (TextView) findViewById(R.id.remaining_words);
        firsttextview.setText(count + " word(s) remaining");
        //if there are no more words to be entered, new intent for final story is executed
        if (count==0){
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