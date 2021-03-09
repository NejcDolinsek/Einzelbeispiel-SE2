package com.example.se2_einzelbeispiel;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeNumber extends MainActivity {
    public static String ArrayListToString (ArrayList<Integer> MatrikelnummerArray){

        StringBuilder listString = new StringBuilder();

        for (Object s : MatrikelnummerArray){
            listString.append(s).append("\t");
        }
        return listString.toString();
    }

    public static ArrayList<Integer> calcPrimeNumbers(String matrikelnummer){

        ArrayList<Integer> matrikelnummerArray = StringToArrayList(matrikelnummer);
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int i = 0; i < matrikelnummerArray.size() ; i++) {
            if (matrikelnummerArray.get(i) == 2){primeNumbers.add(i);}

            for (int j = 2; j <= matrikelnummerArray.get(i)/2; j++) {

                if (matrikelnummerArray.get(i) % j == 0){
                    primeNumbers.add(i);
                }
            }
        }
        return primeNumbers;
    }

    public static ArrayList<Integer> StringToArrayList (String matrikelnummer){

        int temp = Integer.parseInt(matrikelnummer);
        ArrayList<Integer> arrayListMatrikelnummer = new ArrayList<>();
        do{
            arrayListMatrikelnummer.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);

        Collections.reverse(arrayListMatrikelnummer);

        return arrayListMatrikelnummer;
    }
}
