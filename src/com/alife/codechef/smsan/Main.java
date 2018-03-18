package com.alife.codechef.smsan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/smsan/input.txt";

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

		String message = scanner.nextLine();

		
		int totalWordCount 			=	 0;
		int flaggedWordCount		=    0;
		int min 					= 	 0;
		
		Set<String> flaggedWordList = new HashSet<>();
		flaggedWordList.add("love");
		flaggedWordList.add("babe");
		flaggedWordList.add("sweety");
		flaggedWordList.add("life");
		
		for(String msg : message.split(" ")){
			if( flaggedWordList.contains(msg) ){
				flaggedWordCount++;
			}
			totalWordCount++;
		}
		
		min = Math.min(totalWordCount, flaggedWordCount);

		for(int i=min; i > 1 ; i--){

			while( totalWordCount % i == 0 && flaggedWordCount % i == 0 ){
				totalWordCount /= i;
				flaggedWordCount /= i;
			}
		}

		System.out.println(flaggedWordCount+"/"+totalWordCount);

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
