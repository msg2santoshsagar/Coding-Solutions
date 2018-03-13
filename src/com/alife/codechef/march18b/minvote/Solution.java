package com.alife.codechef.march18b.minvote;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/minvote/input.txt";

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

		int tc  = scanner.nextInt();
		int ctr = 0;

		while(ctr != tc){

			ctr++;

			int n     		= scanner.nextInt();
			int[] arr 	 	= new int[n];
			long[] sumArr 	= new long[n];

			long sum   = 0;

			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
				sum += arr[i];
				sumArr[i] = sum;
			}

			//System.out.println("\n\n========================== "+ctr+" ======================\n");
			
			int result[] = new int[n];

			for( int i=0; i<n; i++){

				// left side calculation
				if(i != 0){
					for(int j=i-1; j>=0; j--){
						
						long influenceDiff = sumArr[i-1] - sumArr[j];
						 
						 
						if( influenceDiff <= arr[i] ){
							result[j]++;
						}else{
							break;
						}
					}
				}
				
				
				// right side calculation
				if(i != n-1){
					for(int j=i+1; j<n; j++){
						
						long influenceDiff = sumArr[j-1] - sumArr[i];
						 
						 
						if( influenceDiff <= arr[i] ){
							result[j]++;
						}else{
							break;
						}
					}
				}
				
				
			}

			for(int i=0;i<n;i++){
				System.out.print(result[i]+" ");
			}
			System.out.println();

		} // While loop

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