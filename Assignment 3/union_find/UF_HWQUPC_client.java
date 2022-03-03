package edu.neu.coe.info6205.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class UF_HWQUPC_client {
    public static void main(String args[]) throws IOException {
        int input=0;
        System.out.println("*****please enter -1 to exit or positive integer to continue*****");
        while(input!=-1) {
            int initial=100; //number of times to test to take average
            System.out.print("Input : Number of objects/sites (n): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(reader.readLine());
            if (input == -1) {
                System.exit(1);
            }
            int totalrandomconnections=0; // total of all connection and take there average
            for (int i = 0; i < initial; i++) {
                totalrandomconnections += count(input);
            }
            System.out.println(totalrandomconnections/initial + " Random Pairs (m) generated for " + input + " objects (n). ");
        }
    }

    private static int count(int input) {
        int randomPair=0;

        UF_HWQUPC uf_hwqupc = new UF_HWQUPC(input,true);
        Random randObj = new Random();

        while(uf_hwqupc.components() > 1) {
            int p = randObj.nextInt(input);
            int q = randObj.nextInt(input);
            if(!uf_hwqupc.connected(p,q)) {
                uf_hwqupc.union(p, q);
            }
            randomPair++;
        }
        return randomPair;
    }
}
