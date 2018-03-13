package com.alife.codechef.march18b.pshtrg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/pshtrg/input.txt";
	
	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Solution solution = new Solution();
		solution.solve(scanner);
	}

	private void solve(FastScanner scanner){

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		long[]    	array	  	= new long[n];

		for(int i=0;i<n;i++){
			array[i] 	= scanner.nextLong();
		}


		while( q -- > 0 ){

			int choice = scanner.nextInt();
			int pos    = scanner.nextInt();
			int value  = scanner.nextInt();

			if(choice == 1){
				array[pos-1]  = value;
			}else{

				int l 		= 	pos;
				int r 		=	value;

				int len     = r-l+1;

				long maxPerimeter = 0;

				long[]  cArr = Arrays.copyOfRange(array, l-1, r);

				Arrays.sort(cArr);

				for(int i =len-1; i >= 2 ; i-- ){

					if( cArr[i-1] + cArr[i-2] > cArr[i]  ){
						maxPerimeter = cArr[i]+cArr[i-1]+cArr[i-2];
						break;
					}
				}

				System.out.println(maxPerimeter);

			}


		} // while method


	}// solve method

	public static class FastScanner {

		BufferedReader 		br;
		StringTokenizer 	st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException	 e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		String nextLine(){
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}




}
