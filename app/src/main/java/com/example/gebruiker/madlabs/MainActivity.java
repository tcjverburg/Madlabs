package com.example.gebruiker.madlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//method for intent to new activity WordInput
    public void onClick(View view) {
        Intent getNameScreen = new Intent(this, WordInput.class);
        getNameScreen.putExtra("callingActivity", "MainActivity");
        startActivity(getNameScreen);
    }
}