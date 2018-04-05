package com.alife.codechef.viltribe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/viltribe/input.txt";

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

			String str = scanner.nextLine();

			int acount = 0;
			int bcount = 0;

			char prevchar = 'x';
			int  dcount   = 0;

			for(char c: str.toCharArray() ){

				
				if(prevchar == c){

					if(c == 'A'){
						acount += dcount;
						dcount = 0;
					}else{
						bcount += dcount;
						dcount = 0;
					}
				}

				if(c=='A'){
					acount++;
					prevchar = 'A';
					dcount = 0;
				}

				if(c=='B'){
					bcount++;
					prevchar = 'B';
					dcount = 0;
				}

				if(c=='.'){
					dcount++;
				}
				
				
			}
			System.out.println(acount+" "+bcount);

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
