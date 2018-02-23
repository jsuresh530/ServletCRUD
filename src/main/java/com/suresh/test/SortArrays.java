package com.suresh.test;

import java.util.Scanner;

public class SortArrays {

	public static void main(String[] args) {
		//sortAraay();
		//String s =" suresh 1 babu 2 j 2";
		
		String s =" suresh1babu2j2";
		sumNumbers(s);
	}
    public static int sumNumbers(String input)
    {
    	//suresh 12 babu 875 j 345
    	int sum = 0;
    		/*String[] split = input.split("\\s+");
    		for (int i = 0; i < split.length; i++) {
    			try
    			{
    				sum += Integer.parseInt(split[i]);
    			}
    			catch(Exception e)
    			{
    				//throw new RuntimeException("sdfs");
    			}
			}*/
    	for (int i = 0; i < input.length(); i++) {
    		
			if(Character.isDigit(input.charAt(i)))
			{
				 //sum = sum + Character.getNumericValue(input.charAt(i));
				sum += Integer.parseInt(input.charAt(i) + "");
			}
		}
    	System.out.println("SUM IS : "+sum);
    	return sum;
    }
	public static void sortAraay()
	{
		System.out.println("Enter how many elements you want to sort, ");
		Scanner sc = new Scanner(System.in);
		
		int no = sc.nextInt();
		
		System.out.println("Enter "+no+" elements...");
		
		int[] arr = new int[no];
		int i,j,temp=0;
		
		for (i = 0; i < no; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("\n Array elements are : \n");
		for (i = 0; i < no; i++) {
			System.out.print(" "+arr[i]);
		}
		
		//Arrange array in Ascending order
		
		for(i =0;i<no;i++)
		{
			for(j=i+1;j<no;j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] =temp;
				}
			}
		}
		
		System.out.println("\n Array After sort : \n");
		//Print array in ascending order
		for (i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
		if(sc != null)
			sc.close();
	}
}
