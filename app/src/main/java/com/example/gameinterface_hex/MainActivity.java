package com.example.gameinterface_hex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TextView myFaveTextView = new TextView(this);
            myFaveTextView.setText("some text");
        }

        /**
         * changeMax
         *
         * is called whenever the taps the Update Count button.
         * It increments the max count by 1.
         */
//        public void changeMax(View v) {
//            //find the TextView that contains the max number
//            TextView maxTextView = findViewById(R.id.textViewMaxValue);
//
//            //retrieve it's value (String)
//            String txtVal = maxTextView.getText().toString();
//
//            //convert the String to an int
//            int intVal = Integer.parseInt(txtVal);
//
//            //increment the int
//            intVal++;
//
//            //convert it back to a String and put back in the TextView
//            maxTextView.setText("" + intVal);
//
//
//            Button wesButton = findViewById(R.id.buttonUpdate);
//            wesButton.setText("Wes was here");
//
//        }
    }