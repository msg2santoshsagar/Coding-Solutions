package com.alife.codechef.goodpref;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/APRIL18B/problems/GOODPREF
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/goodpref/input.txt";

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

		while(tc-->0){

			String str 			= scanner.nextToken();
			int    repeatation  = scanner.nextInt();

			long aoccurance = 0;
			long boccurance = 0;

			long result     = 0;

			long prevResult  = -1;

			for(int i=0; i<repeatation; i++){

				long localResult = 0;

				for(int j=0; j<str.length();j++){

					char c = str.charAt(j);

					if(c == 'a'){
						aoccurance++;
					}
					if(c == 'b'){
						boccurance++;
					}

					if(aoccurance > boccurance){
						localResult++;
					}

				}

				if(prevResult == localResult){
					localResult = localResult * (repeatation - i);
					result += localResult;
					break;
				}else{
					prevResult = localResult;
				}

				result += localResult;

			}

			System.out.println(result);

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