/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the View that shows the numbers category
        TextView numbers = (TextView)findViewById(R.id.members);

        //Set a clicklistener on that View
        numbers.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Members_Activity.class);
                startActivity(i);
                Toast.makeText(view.getContext(),"Open the list of numbers", Toast.LENGTH_SHORT).show();
            }
        });

        //Find the View that shows the family members category
        TextView family = (TextView)findViewById(R.id.birthdays);

        //Set a clicklistener on that View
        family.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Birthdays_Activity.class);
                startActivity(i);
                Toast.makeText(view.getContext(),"Family first", Toast.LENGTH_SHORT).show();
            }
        });

        //Find the View that shows the colors category
        TextView colors = (TextView)findViewById(R.id.colors);

        //Set a clicklistener on that View
        colors.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Colors_Activity.class);
                startActivity(i);
                Toast.makeText(view.getContext(),"Favourite colour?", Toast.LENGTH_SHORT).show();
            }
        });

        //Find the View that shows the phrases category
        TextView phrases = (TextView)findViewById(R.id.singles);

        //Set a clicklistener on that View
        phrases.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Singles_Activity.class);
                startActivity(i);
                Toast.makeText(view.getContext(),"밥 먹어싶어", Toast.LENGTH_SHORT).show();
            }
        });

        TextView fruits = (TextView)findViewById(R.id.fruits);

        //Set a clicklistener on that View
        fruits.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Fruits_Activity.class);
                startActivity(i);
                Toast.makeText(view.getContext(),"밥 먹어싶어", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*
    public void NumbersList(View view) {
        Intent i = new Intent(this, Members_Activity.class);
        startActivity(i);
    }
    */

    }



    /////////////////////////////////////////////////////////
