package com.suresh.test;

import java.util.Scanner;

public class CalCallTimes {

/*	Write a program that computes the cost of a long distance call. The cost of the call is determined
	according to the following rate schedule:
	1. Any call started between 8:00 Am and 6:00 PM, Monday through Friday, is billed at a rate of
	4.50 per minute
	2. Any call starting before 8:00 AM or after 6:00 PM, Monday through Friday, is billed at a rate
	of 4.00 per minute
	3. Any call started on a Saturday or Sunday is charged at a rate of 2.25 per minute
	The input will consist the day of the week (Mo, Tu, We, Th, Fr, Sa, Su); the time the call started,
	including the AM/PM designation; and the length of the call in minutes. The output will be the cost of the
	call. Be sure to allow the user to use either uppercase or lowercase letters or a combination of both.*/
	public static void main(String[] args) {
		
		System.out.println("Please select day and enter time \n ");
		
		String selectDay = selectDay();
		
		computeBasedOnDay(selectDay);
	}

	private static int computeBasedOnDay(String selectDay) {
		System.out.println("Enter time in hours includes AM/PM");
		int total = 0;
		String next = null;
		Scanner sc = new Scanner(System.in);
		
		String i = sc.next();
		
		int nextInt = Integer.parseInt(i);
		
		int min = (int) Math.round(nextInt * 60);
		System.out.println("You have entered: "+nextInt);
		/*if(selectDay == "Mo" || selectDay == "Tu" || selectDay == "We" || selectDay == "Th" || selectDay == "Fr")
		{
			
		}
		else if(selectDay == "Mo" || selectDay == "Tu")
		{
			
		}*/
		
		//sc.close();
		return total;
	}

	public static String selectDay()
	{
		int [] arr = new int[2];
		for (int i = 0; i < arr.length-1; i++) {
			
		}
		System.out.print("SELECT ::: \n 1. MONDAY \n 2. Tuesday \n 3. Wednesday \n 4. Thrusday \n 5. Friday \n 6. Saturday \n 7. Sunday \n\n ");
		Scanner sc = new Scanner(System.in);
		String name = null;
		int i = sc.nextInt();
		
		if(i == 1)
		name = "Mo";
		if(i == 2)
			name = "Tu";
		if(i == 3)
			name = "We";
		if(i == 4)
			name = "Th";
		if(i == 5)
			name = "Fr";
		if(i == 6)
			name = "Sa";
		if(i == 7)
			name = "Su";
		
		//sc.close();
		
		System.out.println("Day selected: "+name);
		return name;
	}
}
