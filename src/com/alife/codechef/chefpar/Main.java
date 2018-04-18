package com.alife.codechef.chefpar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/chefpar/input.txt";

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

		int 	N 		= 	scanner.nextInt();
		int 	M 		= 	scanner.nextInt();
		long 	K 		= 	scanner.nextLong();

		long[] 	number 	= 	new long[N];
		long[] 	primes 	= 	new long[M];

		for(int i=0; i < N ;i++){
			number[i] = scanner.nextLong();
		}

		for(int i=0; i < M ;i++){
			primes[i] = scanner.nextLong();
		}

		Random rand = new Random();

		for(int i=0; i< N ; i++){
			int randomNumber =  rand.nextInt( (int) K % Integer.MAX_VALUE ) ;
			System.out.print(number[i]+( randomNumber == 0 ? 1 : randomNumber  ) );
			if(i<N-1)
				System.out.print(" ");
		}
		
		System.out.println();


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