package com.ph3.tmp;

import java.util.*;

public class Test05 {
    public static void main(String[] args) {

        int[] a1 = null;
        int[] a2 = new int[2];

        a1 = new int[]{3, 4, 6};
        a2 = new int[]{3, 4};

        Arrays.sort(a1);
        Arrays.sort(a2);

        int encontrado = 0;
        int contador = 0;
        int[] temp = new int[a2.length];

        System.out.println("Buscando dentro del array 1 cada valor del array2");

        for (int i = 0; i < a2.length; i++) {
            encontrado = Arrays.binarySearch(a1, a2[i]);
            System.out.print(encontrado + " ");
            if (encontrado >= 0) {
                temp[i] = a2[i];
                contador++;
            }
        }

        if (contador == a2.length) {
            System.out.println("Estan todos");
        } else {
            System.out.println("Estan algunos o ninguno");
        }

        System.out.println("valores de temp:");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}