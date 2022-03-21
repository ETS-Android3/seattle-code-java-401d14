package com.edy.buymorestuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Step 1: Get UI component
      Button submitButton = (Button) findViewById(R.id.submitButton);

      // Step 2: Set OnClickListener
      submitButton.setOnClickListener(new View.OnClickListener()
      {
        // Step 3: Define the onClick() callback
        @Override
        public void onClick(View view)
        {
          // Step 4: Log some text
          System.out.println("Hello, we submitted!");
          Log.e(TAG, "Hello, we're logging this time!");

          ((TextView)findViewById(R.id.submittedTextTextView)).setText(R.string.submitted);
        }
      });
    }
}
