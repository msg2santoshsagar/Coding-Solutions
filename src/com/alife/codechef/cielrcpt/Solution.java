package com.alife.codechef.cielrcpt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/problems/CIELRCPT
 * @notSolvedYet
 *
 */
public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cielrcpt/input.txt";

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

			int menuCount = getMinMenu(n);

			System.out.println(menuCount);

		}


	}

	private int getMinMenu(int n) {
		
		
		if(n == 1){
			return 1;
		}
		
		
		int ctr = 0;
		
		while(n!= 0){
		
			double p = Math.floor((     Math.log(n) / Math.log(2) ) );
			if(p > 11){
				p = 11;
			}
			//System.out.println("P : "+p);
			n = (int) (n - Math.pow(2, p));
			ctr++;
			
		}
		
		//System.out.println("CTR :: "+ctr);
		
		return ctr;
		 
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
