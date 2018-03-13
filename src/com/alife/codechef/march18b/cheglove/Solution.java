package com.alife.codechef.march18b.cheglove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/cheglove/input.txt";
	private static final boolean 	ONLINE_MODE		= true;

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
			
			int fingerCount = Integer.parseInt(br.readLine());
			
			String fingerLength [] = br.readLine().split(" ");
			String gloveLength  [] = br.readLine().split(" ");
			
			boolean isFrontPossible = true;
			boolean isBackPossible  = true;
			
			for(int i=0; i< fingerCount; i++){
				
				int fingerLen = Integer.parseInt(fingerLength[i]);
				
				//condition for front
				int frontGlovePositionLength = Integer.parseInt(gloveLength[i]);
				isFrontPossible &= (fingerLen <= frontGlovePositionLength);
				
				//condition for back
				int backGlovePositionLength = Integer.parseInt(gloveLength[fingerCount-i-1]);
				isBackPossible &= (fingerLen <= backGlovePositionLength);
				
			}
			
			if( isFrontPossible && isBackPossible ){
				System.out.println("both");
			}else if(isFrontPossible){
				System.out.println("front");
			}else if(isBackPossible){
				System.out.println("back");
			}else{
				System.out.println("none");
			}
			
		}
		

	}

}
