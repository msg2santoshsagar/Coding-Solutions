package com.hackerearth.ninjakart;



import java.io.FileNotFoundException;
import java.util.Scanner;

class SolutionElevator {

	public static void main(String[] args) throws FileNotFoundException{

		Scanner scanner = new Scanner(System.in);;

		int n = scanner.nextInt();

		Long[] array = new Long[n];

		for(int i =0; i<n ; i++){
			array[i] = scanner.nextLong();
		}

		long 	max = 0;
		long 	prevMax = 0;

		for(int i=0; i< n; i++){
			
			prevMax = prevMax + array[i];
			
			if( max < prevMax ){
				max = prevMax;
			}
			
			if(prevMax < 0){
				prevMax = 0;
			}
			
		}

		System.out.println(max);
		scanner.close();
	}

}