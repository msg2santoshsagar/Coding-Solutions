package com.alife.codechef.gqr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/gqr/input.txt";

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

		int N = scanner.nextInt();
		int Q = scanner.nextInt();

		int arr[] = new int[N+1];

	    Map<String, Integer> gcdMax = new HashMap<>();
		
		for(int i=1; i<= N ;i++){
			arr[i] = scanner.nextInt();
		}

		for(int i=1;i<N;i++){
			int max = 0;
			for(int j=i+1;j<=N;j++){
				max = Math.max(max, gcd(arr[i],arr[j]));
				gcdMax.put(i+"-"+j, max);
			}	

		}

		while(Q-->0){

			int l = scanner.nextInt();
			int r = scanner.nextInt();
			System.out.println(gcdMax.get(l+"-"+r));
		}


	}


	int gcd(int a, int b){

		if(a==b){
			return a;
		}

		while( b % a != 0){
			int temp = b % a;
			b=a;
			a = temp;
		}

		return a;
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
