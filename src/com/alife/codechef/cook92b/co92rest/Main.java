package com.alife.codechef.cook92b.co92rest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook92b/co92rest/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Main solution = new Main();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();

		final int MOD = (int) (Math.pow(10, 9) +7);

		while( tc -- > 0 ){

			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int K = scanner.nextInt();

			int[] arr = new int[N];

			for(int i=0; i< N ; i++){
				arr[i] = scanner.nextInt();
			}

			boolean isImpossible = false;
			int     possible     = 0;

			while(M -- > 0){

				char c = scanner.nextChar();

				int  l = scanner.nextInt();
				int  r = scanner.nextInt();

				if(c == 'I'){

					for(int i=l-1;i<r;i++){

						if(arr[i] == -1){
							if(i==0 && N > 1){
								arr[i] = arr[i+1] -1;
							}else if(i == N -1 && N > 1){
								arr[i] = arr[i-1]+1;
							}else{
								
							}
						}

					}

				}else{

				}

			}


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

		char nextChar() {
			return nextToken().charAt(0);
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
