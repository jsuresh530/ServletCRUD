package com.suresh.test;

public class PatternProgrammes {

	public static void main(String[] args) {
		//f = c * 9/5 + 32;
		pattern8();
	}

	public static void pattern1()
	{
	/*   1 
		 1 0 
		 1 0 1 
		 1 0 1 0 
		 1 0 1 0 1 */
		for (int i = 0; i <= 5; i++) {
			
			for (int j = 1; j <= i; j++) {
				
				if(j%2 == 0)
				{
					System.out.print(" "+0);
				}else
				{
					System.out.print(" "+1);
				}
			}
			System.out.println(" ");
		}
	}
	
	public static void pattern2()
	{
	/*  1 
		1 2 
		1 2 3 
		1 2 3 4 
		1 2 3 4 5 
		1 2 3 4 5 6 */
		
		for (int i = 0; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println( );
		}
	}
	
	public static void pattern3()
	{
		/*  1
			 2 1
			 3 2 1
			 4 3 2 1
			 5 4 3 2 1
			 6 5 4 3 2 1 */

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(" "+j);
			}
			System.out.println( );
		}
	}
	
	public static void pattern4()
	{
	/*  1  
		2 2  
		3 3 3  
		4 4 4 4  
		5 5 5 5 5  
		6 6 6 6 6 6*/
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static void pattern5()
	{
		/**  
		* *  
		* * *  
		* * * *  
		* * * * * */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
	
	public static void pattern6()
	{
		 /*	* 
	      * * 
	    * * * 
	  * * * * 
	* * * * * */
		
		/*if k =k-1 
		 	* 
	       * * 
	      * * * 
	     * * * * 
	    * * * * **/
		int i, j, k = 2*5-2;
		
		for (i = 0; i < 5; i++) {
			for (j = 0; j < k; j++) {
				System.out.print(" ");
			}
			k =k-2;
			for (j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void pattern7()
	{
		/*1 
		1 2 
		1 2 3 
		1 2 3 4 
		1 2 3 4 5 */
		int num =0;
		for (int i = 0; i < 5; i++) {
			num =1;
			for (int j = 0; j <= i; j++) {
				System.out.print(num+ " ");
				num++;
			}
			System.out.println( );
		}
	}
	
	public static void pattern8()
	{
		/*1 
		2 3 
		4 5 6 
		7 8 9 10 
		11 12 13 14 15 */
		
		int num =1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(num+ " ");
				num++;
			}
			System.out.println( );
		}
	}
}
