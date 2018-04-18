package com.temp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Solution4 {



	private static final String 	INPUT_FILE_PATH = "src/com/temp/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Solution4 solution = new Solution4();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) {

		int n = scanner.nextInt();

		System.out.println(magicalStrings(n));

	}

	/*
	 * Complete the magicalStrings function below.
	 */
	static int magicalStrings(int n) {
		return calculateMagicalTree(n, '0');
	}

	static int calculateMagicalTree(int n,char c){

		if(n==0){
			return 1;
		}

		int sum = 0;

		if(c == '0'){
			sum += calculateMagicalTree(n-1,'a');
			sum += calculateMagicalTree(n-1,'e');
			sum += calculateMagicalTree(n-1,'i');
			sum += calculateMagicalTree(n-1,'o');
			sum += calculateMagicalTree(n-1,'u');
		}

		if(c=='a'){
			sum += calculateMagicalTree(n-1,'e');
		}

		if(c=='e'){
			sum += calculateMagicalTree(n-1,'a');
			sum += calculateMagicalTree(n-1,'i');
		}

		if(c=='i'){
			sum += calculateMagicalTree(n-1,'a');
			sum += calculateMagicalTree(n-1,'e');
			sum += calculateMagicalTree(n-1,'o');
			sum += calculateMagicalTree(n-1,'u');
		}

		if(c=='o'){
			sum += calculateMagicalTree(n-1,'i');
			sum += calculateMagicalTree(n-1,'u');
		}

		if(c=='u'){
			sum += calculateMagicalTree(n-1,'a');
		}

		sum = sum % 1_000_007;
		
		return sum;

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