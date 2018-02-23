package com.suresh.test;

import java.util.Scanner;

public class ArraySum {

	static int simpleArraySum(int n, int[] ar) {
        int sum =0;
        for(int i =0; i < ar.length; i++)
        {
            sum += ar[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        readArray();
    }

	private static void readArray() {
		System.out.println("How many Elements u want to sum");
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        System.out.println("Enter numric elemnts");
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = simpleArraySum(n, ar);
        System.out.println(result);
	}

}
