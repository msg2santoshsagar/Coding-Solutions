package com.temp;

/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

		String[] data = br.readLine().split(" ");
		int n = Integer.parseInt(data[0]);
		int k = Integer.parseInt(data[1]);
		
		final int MOD = 1000000007;

		int arr [] =new int[n+1];

		if( n <= k ){
			System.out.println(1);
		}else{
			
			for(int i=0;i<k;i++){
				arr[i] = 1;
			}
			
			for( int i=k ; i< n ; i++ ){
				
				int sum = 0;
				
				int sz = k;
				
				while(sz > 0){
					sum = (sum + arr[i-sz]) % MOD;
					sz--;
				}
				
				arr[i] = sum;
				
			}
			
			System.out.println(arr[n-1]);
			
		}
		
		
	}

	


}
