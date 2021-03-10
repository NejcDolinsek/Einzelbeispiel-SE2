package com.example.se2_einzelbeispiel;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Button - Task 1
        Button matNrToServer = (Button) findViewById(R.id.matToServerBTN);
        matNrToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    run();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        //Button - Task 2 - Prime numbers in Matrikelnummer
        Button primeNumbers = (Button) findViewById(R.id.primeNumbers);
        primeNumbers.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                EditText InputText = (EditText) findViewById(R.id.Input);
                TextView TextAnswer = (TextView) findViewById(R.id.Answer);

                // Get the Input from the EditText and change it to String
                String matrikelnummer = InputText.getText().toString();


                String primeNumbersString = PrimeNumber.matPrimeNumbers(matrikelnummer);



                //Display the Prime numbers in the textView
                TextAnswer.setText(primeNumbersString);
            }
        });
    }

    public void run() throws IOException {
        TextView TextAnswer = (TextView) findViewById(R.id.Answer);
        EditText InputText = (EditText) findViewById(R.id.Input);


            String sentence = InputText.getText().toString();

            Socket clientsocket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientsocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

            outToServer.writeBytes(sentence);

            TextAnswer.setText(inFromServer.readLine());

            clientsocket.close();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}