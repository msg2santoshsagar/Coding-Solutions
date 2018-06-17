package com.alife.codechef.qoc2018.frieza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/qoc2018/frieza/input.txt";

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

	private void solve(FastScanner sc) {

		int tc = sc.nextInt();

		while(tc-->0){

			String str = sc.nextLine();
			
			StringBuilder sb = new StringBuilder();
			
			boolean goodTurn = isGood(str.charAt(0));
			int count =0;
			
			for(int i=0; i<str.length(); i++){
				
				boolean currentGood = isGood(str.charAt(i));
				
				//System.out.print("INDEX : "+i+", "+currentGood+" : "+count);
				
				if(goodTurn == currentGood){
					count++;
				}else{
					sb.append(count);
					count=1;
					goodTurn = currentGood;
				}
				
				//System.out.println(" : "+count+" ");
				
			}
			
			sb.append(count);
			
			System.out.println(sb.toString());
		
		}

	}

	boolean isGood(char c){
		if(c=='f'||c=='r'||c=='i'||c=='e'||c=='z'||c=='a'){
			return true;
		}
		return false;
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