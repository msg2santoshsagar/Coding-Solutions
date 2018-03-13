package com.alife.codechef.march18b.bigsale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/bigsale/input.txt";
	private static final boolean 	ONLINE_MODE		= false;

	public static void main(String args[]) throws NumberFormatException, IOException{

		File file = new File(INPUT_FILE_PATH);

		InputStreamReader in = null;

		if(ONLINE_MODE){
			in = new InputStreamReader(System.in);
		}else{
			in = new InputStreamReader(new FileInputStream(file));
		}

		BufferedReader br = new BufferedReader(in);

		Solution solution = new Solution();
		solution.solve(br);

	}

	private void solve(BufferedReader br) throws NumberFormatException, IOException {
		
		int testCaseCount = Integer.parseInt(br.readLine());
		
		while( testCaseCount --  > 0 ){
			
			int numberOfItem = Integer.parseInt(br.readLine());
			
			double loss = 0;
			
			while(numberOfItem -- > 0 ){
				
				String data [] = br.readLine().split(" ");
				
				double price 		= Double.parseDouble(data[0]);
				double quantity 	= Double.parseDouble(data[1]);
				double discount 	= Double.parseDouble(data[2]);
				
				double priceAfterIncrease = price + (price * (discount / 100) );
				double salingPrice 		  = priceAfterIncrease - (priceAfterIncrease * (discount / 100) );
				
				loss += (salingPrice - price) * quantity;
				
				
			}
			System.out.printf("%.7f\n",(0-loss));
			
			
		}// While loop
		
	}// solve method

}
