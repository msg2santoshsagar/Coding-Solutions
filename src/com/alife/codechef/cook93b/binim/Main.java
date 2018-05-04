package com.alife.codechef.cook93b.binim;

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



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook93b/binim/input.txt";

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

		int t = scanner.nextInt();

		while(t-->0){


			int numberOfStack  = scanner.nextInt();

			String firstPlayer = scanner.nextToken(); 

			StringBuilder sb[] = new StringBuilder[numberOfStack];

			for(int i=0; i< numberOfStack; i++){
				sb[i] = new StringBuilder(scanner.nextLine());
			}

			char search = "Dee".equals(firstPlayer) ? '0' : '1';

			while(true){

				boolean searchFound = false;

				for(int i=0; i<numberOfStack;i++){

					if(sb[i] != null && ! "".equals(sb[i].toString())  && sb[i].toString().charAt(0) == search ){
			//			System.out.println("SB VLUE : "+sb[i]);
						sb[i].deleteCharAt(0);
						while(! "".equals(sb[i].toString()) && sb[i].toString().charAt(0) != search){
							sb[i].deleteCharAt(0);
						}
						search = search == '0' ? '1' : '0';
						searchFound = true;
						break;
					}

				}

				if(!searchFound){
					break;
				}

			}


			if(search == '0'){
				System.out.println("Dum");
			}else{
				System.out.println("Dee");
			}
			//System.out.println("SEARCH VALUE : "+search);


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