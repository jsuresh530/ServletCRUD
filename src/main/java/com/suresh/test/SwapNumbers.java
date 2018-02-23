package com.suresh.test;

public class SwapNumbers {
	static int data = 100;

	public static void main(String[] args) {
		// SwapNumbers sn =new SwapNumbers();
		// swapNumbers(10, 20);
		// SwapNumbers.callByValue(data, sn);

		//isPrime(100);
		
		//numberOfWords(123);
		
		//factorial(1);
		
		mTable(19);

	}

	public static void swapNumbers(int a, int b) {
		System.out.println("Before swap nos, " + a + " " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After swap nos, " + a + " " + b);
	}

	public static void callByValue(int data, SwapNumbers sn) {
		// There is only call by value in java, not call by reference. If we
		// call a method passing a value, it is known as call by value.
		// The changes being done in the called method, is not affected in the
		// calling method.

		System.out.println("before value " + SwapNumbers.data);
		// data =data+100;
		SwapNumbers.data = SwapNumbers.data + 100;
		System.out.println("After value " + SwapNumbers.data);
	}

	public static void isPrime(int no) {
		// No, static method cannot be overridden. It can be proved by runtime
		// polymorphism,
		// because static method is bound with class whereas instance method is
		// bound with object. Static belongs to class area and instance belongs
		// to heap area.
		// No, because main is a static method.

		int i;

		if (no == 1) {
			System.out.println("Smallest Prime number is 2");
		}
		for (i = 2; i < no; i++) {
			if (no % i == 0) {
				System.out.println("Not Prime");
				break;
			}
		}
		if (no == i) {
			System.out.println("Prime");
		}
		
		for (i = 2; i < no; i++) {
			for (int j = 2; j <= i; j++) {
				if( i == j) 
					System.out.print(i+",");
				else if(i%j == 0) break;
			}
		}
	}
	
	public static void numberOfWords(int n)
	{
		int count =0;
		if(n < 0) n = n *-1;
		else if(n == 1) n=1;
		while(n > 0)  //123/10 12/10 2/10
		{
			n = n/10;
			count++;
			System.out.println(" "+count+" "+n);
		}
		System.out.println("No of digits is: "+count);
	}
	
	public static int factorial(int n)
	{
		int result = 1;
		if(n == 1){
			System.out.println("result is "+n);
			return n;
		}
		/*result = factorial(n-1)*n;
		System.out.println("Factorial is : "+result);*/
		for (int i = 1; i <= n; i++) {
			result = result *i;
		}
		
		System.out.println("Factorial is : "+result);
		return result;
	}
	
	public static void mTable(int n)
	{
		int table =0;
		for (int i = 1; i <= 10; i++) {
			table = n*i;
			System.out.println(n+" * "+i+" ="+table);
		}
	}
}
