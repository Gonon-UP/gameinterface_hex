package com.example.gameinterface_hex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//            TextView myFaveTextView = new TextView(this);
//            myFaveTextView.setText("some text");

        /***************************************************************************************
         *    Title: How to Implement Spinner
         *    Author: Codes Easy
         *    Date: 2023
         *    Availability: https://www.youtube.com/watch?v=4ogzfAipGS8
         *
         ***************************************************************************************/
        Spinner spinner = findViewById(R.id.settings);

        // Use setOnItemSelectedListener instead of setOnItemClickListener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                // The selected item is selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle the case where nothing is selected
            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("How to Play");
        arrayList.add("Change Color");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
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