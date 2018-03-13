package com.alife.codechef.march18b.mixcolor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/mixcolor/input.txt";

	public static void main(String[] args) throws IOException{

		String homePc = System.getenv("HOME_PC");

		File file = new File(INPUT_FILE_PATH);

		InputStreamReader in = null;

		if(homePc == null){
			in = new InputStreamReader(System.in);
		}else{
			in = new InputStreamReader(new FileInputStream(file));
		}

		BufferedReader br = new BufferedReader(in);

		Solution solution = new Solution();
		solution.solve(br);

	}

	private void solve(BufferedReader br) throws IOException {

		int testCaseCount = Integer.parseInt(br.readLine());

		while( testCaseCount --  > 0 ){

			int colorCount = Integer.parseInt(br.readLine());

			String[] colorStrArr = br.readLine().split(" ");

			int [] colorArr 					= new int[colorCount];
			Map<Integer, Integer> colorCountMap	= new HashMap<>();
			

			int mixingRequired  = 0;
			
			for(int i=0; i< colorCount ; i++){

				int color = Integer.parseInt(colorStrArr[i]);
				colorArr[i] 	= color;
				Integer count = colorCountMap.get(color);
				if(count == null){
					count = 0;
				}
				count++;
				colorCountMap.put(color, count);
				if(count > 1){
					mixingRequired++;

				}

			}

			System.out.println(mixingRequired);


		}// While loop

	}// solve method



}
