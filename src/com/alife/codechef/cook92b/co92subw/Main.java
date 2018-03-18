package com.alife.codechef.cook92b.co92subw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook92b/co92subw/input.txt";

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

			int destination = scanner.nextInt();
			
			int src  		= 1;
			
			int nextStation = 3;
			int nextDiff    = 3;
			
			int timeTaken   = 1;
			
			while(src != destination){
				
				if(destination > nextStation){
					
					timeTaken ++;
					src = nextStation;
					nextStation = nextStation+nextDiff;
					nextDiff++;
					
					
				}else{
					
					int diffFromCurrent = destination - src;
					int diffFromNext	= nextStation - destination;
					
					if( diffFromNext < diffFromCurrent ){
						timeTaken = timeTaken+1+diffFromNext;
					}else{
						timeTaken = timeTaken+ diffFromCurrent;
					}
					
					src = destination;
					
				}
				
				
			}
			
			System.out.println(timeTaken);
			
			

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
