package com.suresh.test;

public class ReverseString {

	public static void main(String[] args) {
		
		reverseInt(123);
		
		reverseString("123543");
		
		fibnaaci(10);
	}

	private static void reverseInt(int n)
	{
		int rev =0;
		while(n>0)
		{
			rev = rev*10 + n%10;
			n =n/10;
		}
		System.out.println(rev);
	}
	
	private static String reverseString(String str)
	{
		String rev ="";
		if(str == "") return str;
		
		for (int i = str.length()-1; i >= 0; i--) {
			
			rev += str.charAt(i);
		}
		System.out.println(rev);
		return rev;
	}
	
	static private void fibnaaci(int n)
	{
		int first =0, second =1, nextTerm = 0;
		for (int i = 1; i <= n; i++) {
			
			System.out.println(first);
			nextTerm = first+second;
			first = second;
			second =nextTerm;
			
		}
	}
}
