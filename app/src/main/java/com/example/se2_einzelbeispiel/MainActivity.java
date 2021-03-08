package com.example.se2_einzelbeispiel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // BUtton - Task 1
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

            }
        });
    }



    //Method for the TCP Client call
    public void run() throws IOException {
        TextView TextAnswer = (TextView) findViewById(R.id.Answer);
        EditText InputText = (EditText) findViewById(R.id.Input);


            String serverInput = InputText.getText().toString();

            Socket clientSocked = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());

            BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));

            outToServer.writeBytes(serverInput);

            TextAnswer.setText(inFormServer.readLine());

            clientSocked.close();

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