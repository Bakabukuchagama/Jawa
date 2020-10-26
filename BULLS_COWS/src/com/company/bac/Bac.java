package com.company.bac;

import java.util.Random;

public class Bac {
    public int[] genArray;
    public static Random random = new Random();
    public Bac (int size) {
        genArray=genArray(size);
    }
    protected int[] genArray(int size)
    {
        int[] arr = new int[size];
        int tunic = 0;
        while (tunic != arr.length){

            arr[tunic]= random.nextInt(10);
        boolean isunic = true;
        for (int i = 0; i < tunic; i++)
        {
            if (arr[tunic] == arr[i])
            {
                isunic = false;
                break;
            }
        }
            if(isunic)
            {
                tunic++;
            }
        }
        return arr;
    }
}
