package com.temp;

import java.util.Arrays;

public class Solution3 {
	
	public static void main(String args[]){
		
		long mainArr [] = new long[]{3, 1, 8, 9, 7, 5 , 12 , 34, 88, 121};
		
		int l = 2;
		int r = 7;
		
		int len = r - l + 1 ;
		
		long cArr[] = new long[len];
		
		for(int i=0; i < len /2 ; i++){
			cArr[i] 		= mainArr[l-1+i];
			cArr[len-i-1]	= mainArr[r-1-i];
		}
		
		if(len % 2 == 1){
			cArr[len/2] = mainArr[l+(len/2)-1];
		}
		
		Arrays.stream(cArr).forEach(a -> System.out.print(a+" "));
		System.out.println();
	}

}
