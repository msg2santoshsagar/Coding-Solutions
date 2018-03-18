package com.alife.codechef.maxsc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Solution {
 
 
 
	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/maxsc/input.txt";
 
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
 
		while( tc -- > 0 ){
 
			int n = scanner.nextInt();
 
			long globalMax = 0;
			
			for(int i=0; i < n; i++){
				
				long localMax = Long.MIN_VALUE;
				
				for(int j=0;j<n;j++){
					long num = scanner.nextLong();
					
					if(localMax < num ) {
						localMax = num;
					}
				
				}
				globalMax += localMax;
			}
			
			System.out.println(globalMax );
 
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
 