package com.alife.codechef.march18b.pshtrg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SolutionD {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/pshtrg/input.txt";
	
	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		SolutionD solution = new SolutionD();
		solution.solve(scanner);
	}

	private void solve(FastScanner scanner){

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		int[]    	array	  	= new int[n];

		for(int i=0;i<n;i++){
			array[i] 	= scanner.nextInt();
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
				
				long maxPerimeter = 0;

				for( int i=l-1; i < r ;  i++){
					
					for(int j= i+1; j< r; j++ ){
						
						for(int k=j+1; k <r ;k++){
							
							if( isValidTriangle( array[i], array[j], array[k] ) && maxPerimeter < (array[i]+array[j]+array[k])){
								maxPerimeter = array[i]+array[j]+array[k];
							}
							
						}
						
					}
					
				}
				

				System.out.println(maxPerimeter);

			}


		} // while method


	}// solve method

	private boolean isValidTriangle(int i, int j, int k) {
		if( i+j > k && i+k > j && j+k > i){
			return true;
		}
		return false;
	}

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
