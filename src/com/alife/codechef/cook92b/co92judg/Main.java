package com.alife.codechef.cook92b.co92judg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook92b/co92judg/input.txt";

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

		while( tc -- > 0 ){

			int n = scanner.nextInt();
			
			int aMax = 0;
			int aSum = 0;
			
			for(int i=0;i<n;i++){
				int num = scanner.nextInt();
				aSum += num;
				if(aMax < num){
					aMax = num;
				}
			}
			
			int bMax = 0;
			int bSum = 0;
			
			for(int i=0;i<n;i++){
				int num = scanner.nextInt();
				bSum += num;
				if(bMax < num){
					bMax = num;
				}
			}
			
			
			int aTime = aSum - aMax;
			int bTime = bSum - bMax;
			
			if(aTime ==  bTime){
				System.out.println("Draw");
			}else if(aTime < bTime){
				System.out.println("Alice");
			}else{
				System.out.println("Bob");
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
