package com.example.se2_einzelbeispiel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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


        // Button - Task 1


        //Button - Task 2 - Prime numbers in Matrikelnummer
        Button primeNumbers = findViewById(R.id.primeNumbers);
        primeNumbers.setOnClickListener(v -> {
            EditText InputText = findViewById(R.id.Input);
            TextView TextAnswer = findViewById(R.id.Answer);

            // Get the Input from the EditText and change it to String
            String matrikelnummer = InputText.getText().toString();

            //Calculating the prime numbers in the Matrikelnummer
            String primeNumbersString = PrimeNumber.matPrimeNumbers(matrikelnummer);

            //Display the Prime numbers in the textView
            TextAnswer.setText("PRIME NUMBERS: " + primeNumbersString);
        });
    }



   /* public void run() throws IOException {
        TextView TextAnswer = findViewById(R.id.Answer);
        EditText InputText = findViewById(R.id.Input);


            String sentence = InputText.getText().toString();

            Socket clientsocket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientsocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

            outToServer.writeBytes(sentence);

            TextAnswer.setText(inFromServer.readLine());

            clientsocket.close();



    }*/

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

    public static String run(String matrikelnummerString) throws IOException {

        InputStream matrikelnummer = new ByteArrayInputStream(matrikelnummerString.getBytes());

        String sentence;
        String modifiedSentence;

        BufferedReader inFormUser = new BufferedReader(new InputStreamReader(matrikelnummer));

        Socket clientSocked = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());

        BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));

        sentence = inFormUser.readLine();

        outToServer.writeBytes(sentence + "\n");

        modifiedSentence = inFormServer.readLine();

        clientSocked.close();

        return "Server answer: "+modifiedSentence;


    }
}

