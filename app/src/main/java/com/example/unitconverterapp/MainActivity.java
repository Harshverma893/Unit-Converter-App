package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
EditText editText;
Button button;
Spinner spinner;

float a  = 0;
String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.textView);
        editText = findViewById(R.id.editext);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num= String.valueOf(editText.getText());

                if (s=="Cm"){
                    a  = (Integer.valueOf(num)*100f);

                }
                else if (s=="Km"){
                    a  = Integer.valueOf(num)*0.001f;
                }else if (s=="feet"){
                     a  = Integer.valueOf(num)*3.37f;
                }else if (s=="Inch"){
                    a  = Integer.valueOf(num)*39.37f;
                }

               textView.setText(a+" "+s);
            }
        });

        //SPINNER TOOL

        spinner= findViewById(R.id.spinner2);


        //DECLARING DATA SOURCE

        String [] course = {"Cm","Km","feet", "Inch"};

        //Declaring Adapter

        ArrayAdapter ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,course);

        //Dropdown spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s= course[position];
                Toast.makeText(MainActivity.this, "Selected course "+course[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "No Selected course ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}