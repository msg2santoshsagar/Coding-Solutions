package com.alife.gfg.carptun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * not solved yet
 * @author Santosh Sagar
 * https://www.codechef.com/FEB18/problems/CARPTUN
 *
 */
public class Solution {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt( br.readLine() );
		
		for(; tc > 0 ; tc -- ){
			
			int numberOfTunnels = Integer.parseInt( br.readLine() );
			
			String timeTakenStr [] = br.readLine().split(" ");
			
			int timeTaken [] = new int[timeTakenStr.length];
			
			for( int i = 0; i < timeTaken.length ; i++){
				timeTaken[i] = Integer.parseInt(timeTakenStr[i]);
			}
			
			String data[] = br.readLine().split(" ");
			
			int carCount  				= Integer.parseInt(data[0]);
			int distanceBetweenTunnels  = Integer.parseInt(data[1]);
			int velocity				= Integer.parseInt(data[2]);
			
			System.out.printf("%.9f\n", ( (float) ( (carCount-1) * timeTaken[0])));
			
		}
		
		
	}

}
