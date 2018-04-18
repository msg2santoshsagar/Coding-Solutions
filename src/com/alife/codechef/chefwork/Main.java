package com.alife.codechef.chefwork;

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



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/chefwork/input.txt";

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
		 
		int N = scanner.nextInt();
		
		int author = 100_005;
		int translator = 100_005;
		int authorTranslator = 100_005;
		int type,price;
		
		int[] coinArray = new int[N];
		
		for(int i=0;i<N;i++){
			coinArray[i] = scanner.nextInt();
		}
		
		
		for(int i=0;i<N;i++){
			
			 type  = scanner.nextInt();
			 price = coinArray[i];
			
			if(type == 1 && price < translator){
				translator =price;
			}
			
			if(type == 2 && price < author){
				author =price;
			}
			
			if(type == 3 && price < authorTranslator){
				authorTranslator =price;
			}
			
		}
		
		System.out.println(Math.min(author+translator, authorTranslator));
		
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