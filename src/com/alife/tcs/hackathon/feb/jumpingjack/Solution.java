package com.alife.tcs.hackathon.feb.jumpingjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) throws FileNotFoundException{

		Scanner scanner = new Scanner(new File("src/com/alife/tcs/hackathon/feb/jumpingjack/input.txt"));

		int numberOfAction 		=	 scanner.nextInt() ;
		int stepNumberToAvoid   =    scanner.nextInt();	

		System.out.println(maxStep(numberOfAction, stepNumberToAvoid));
		scanner.close();

	}
	
	/*
     * Complete the function below.
     */
    public static int maxStep(int n, int k) {
    	
    	int maxStepPosition = ( n * (n + 1 ) ) / 2;
    
    	//System.out.println("Max Step Position -- "+maxStepPosition);
    	
    	for( ; maxStepPosition > 0 ; maxStepPosition -- ){
    		
    		int currentPos    = maxStepPosition;
    		
    		for(int step = n ; step > 0 ; step-- ){
    		//	System.out.println("Current pos - step "+currentPos+" , "+ step+" , "+(currentPos-step));
    			if(currentPos - step != k && (currentPos - step) >= 0){
    				currentPos = currentPos -step;
    			}
    			if(currentPos == 0){
    				//System.out.println("Current pos found 0 returning data "+maxStepPosition);
    				return maxStepPosition;
    			}
    		}
    		
    	}
    	
    	
    	return maxStepPosition;
    }



}
