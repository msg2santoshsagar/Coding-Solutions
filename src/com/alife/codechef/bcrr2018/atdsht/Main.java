package com.alife.codechef.bcrr2018.atdsht;

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
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/bcrr2018/atdsht/input.txt";

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

		int students = scanner.nextInt();
		
		int[] freq   = new int[26];
		
		int   total  = 0;
		
		for(int i=0;i<students;i++){
			String str = scanner.nextLine();
			total += str.length();
			for(char c : str.toCharArray()){
				freq[c-'A']++;
			}
		}
		
		int[]  efreq   = new int[26];
		String line  = scanner.nextLine();
		for(char c : line.toCharArray()){
			efreq[c-'A']++;
		}
		
		
		if(total>line.length()){
			System.out.println(-1);
		}else{
			
			int change = 0;
			
			for(int i=0;i<26;i++){
				if(freq[i]>efreq[i]){
					change += freq[i]-efreq[i];
				}
				
			}
			
			System.out.println(change);
			
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