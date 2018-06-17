package com.alife.codechef.cook94b.kmxor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook94b/kmxor/input.txt";

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

	int globalSum 		= 0;
	String globalStr	= "";
	List<String> list = new ArrayList<>();
	int  K;

	private void solve(FastScanner scanner) {

		int t = scanner.nextInt();

		while(t-->0){

			int N = scanner.nextInt();
			K = scanner.nextInt();

			globalSum = 0;
			globalStr = "";

			rec(N,globalSum,globalStr);

			System.out.println("\n===============================================\n");
			System.out.println("N : "+N+", K : "+K);
			System.out.println("SUM : "+globalSum);
			System.out.println("STR : "+globalStr);


		}


	}



	void rec(int N, int sum,  String str ){

		if(N==0){
			//System.out.println("N became 0 : sum : "+sum);
			if(globalSum<sum){
				globalSum = sum;
				globalStr = str;
			}
			return;
		}

		for(int i=1; i<K; i++){
			rec(N-1,sum^i,str+" "+i);
		}

	}



	/**
	 * 
	 * I have borrowed this code from GFG. 
	 * This is to take input.
	 * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	 */
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