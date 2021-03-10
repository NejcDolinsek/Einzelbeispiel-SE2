package com.example.se2_einzelbeispiel;

public class PrimeNumber extends MainActivity {
    public static String matPrimeNumbers(String matrikelnummer ){

        int [] matrikelnummerArray = StringToArray(matrikelnummer);
        StringBuilder a = new StringBuilder();

        for (int j : matrikelnummerArray) {
            if (isPrime(j)) {
                a.append(j);
            }
        }
        return a.toString();
    }

    private static boolean isPrime(Integer integer) {
        boolean isPrime = false;
        int i = (int) Math.ceil(Math.sqrt(integer));
        if (i > 1) {
            do {
                if ((integer != i) && (integer % i == 0)) {
                    isPrime = false;
                    break;
                } else if (!isPrime)
                    isPrime = true;
                --i;
            } while (i > 1);
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
