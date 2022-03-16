package com.example.iot1009_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    
    //define variables
    ListView lv ;
    Button button;
    EditText editText;
    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find xml attribute of buttons and edit text and listview
        lv = findViewById(R.id.movieVar);
        button = (Button) findViewById(R.id.but);
        editText = (EditText) findViewById(R.id.ed);

        //make dynamic array to store value in listview
        arrayList = new ArrayList<>();

        //array adapter converts all values turns to list of movies in listview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //get movies from edittext and store in movie names variable
                String movieNames = editText.getText().toString();
                arrayList.add(movieNames);
                lv.setAdapter(arrayAdapter);

                //clear edit after returning element
                editText.getText().clear();

                //make toast message when user enter movie name message will pop up with that movie name
                Toast.makeText(getApplicationContext(),movieNames,Toast.LENGTH_SHORT).show();

            }
        });



    }
}