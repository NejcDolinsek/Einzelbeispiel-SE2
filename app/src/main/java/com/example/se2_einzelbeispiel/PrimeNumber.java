package com.example.se2_einzelbeispiel;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.stream;

public class PrimeNumber extends MainActivity {
   /* public static String ArrayListToString (ArrayList<Integer> MatrikelnummerArray){

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
    }*/


    public static String matPrimeNumbers(String matrikelnummer ){

        int [] matrikelnummerArray = StringToArray(matrikelnummer);
        String a = "";

        for (int i = 0; i < matrikelnummerArray.length; i++) {
            if (isPrime(matrikelnummerArray[i])) {
                a =a+ String.valueOf(matrikelnummerArray[i]);
            }
        }
        return a;
    }

    private static boolean isPrime(Integer integer) {
        boolean isPrime = false;
        int i = (int) Math.ceil(Math.sqrt(integer));
        while (i > 1) {
            if ((integer != i) && (integer % i == 0)) {
                isPrime = false;
                break;
            } else if (!isPrime)
                isPrime = true;
            --i;
        }
        return isPrime;
    }

    private static int[] StringToArray(String x){
        String[] arr = x.split("");

        int [] arrayint = new int[arr.length];

        for (int i = 0; i < arrayint.length; i++) {
            arrayint[i] = Integer.parseInt(arr[i]);
        }

        return arrayint;
    }
}
