package com.example.se2_einzelbeispiel;

import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerAnswer extends MainActivity {

    /*public void run() throws IOException {
        TextView TextAnswer = (TextView) findViewById(R.id.Answer);
        EditText InputText = (EditText) findViewById(R.id.Input);

        String sentence = InputText.getText().toString();

        Socket clientsocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientsocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

        outToServer.writeBytes(sentence);

        TextAnswer.setText(inFromServer.readLine());

        clientsocket.close();

    }*/
}
