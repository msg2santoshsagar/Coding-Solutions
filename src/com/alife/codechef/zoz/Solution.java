package com.alife.codechef.zoz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/zoz/input.txt";

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

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();
		
		while(tc-- > 0){
			
			
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			
			long sum = 0;
			
			long array[] = new long[n];
			
			for(int i=0;i<n;i++){
				array[i] = scanner.nextLong();
				sum += array[i];
			}
			
			int meCount = 0;
			
			for(int i=0;i<n;i++){
				
				if( ( array[i] + k ) > sum - array[i] ){
					meCount++;
				}
				
			}
			
			System.out.println(meCount);
			
			
		}
		
		
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
