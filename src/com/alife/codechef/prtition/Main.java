package com.alife.codechef.prtition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/prtition/input.txt";

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

			int x = scanner.nextInt();
			int n = scanner.nextInt();

			long sum = ( (n * (n+1) ) / 2 ) - x ;

			//System.out.println("SUM : "+sum);

			Set<Long> set = new HashSet<>();

			if( (sum & 1) == 0 ){
			//	System.out.println("The sum is even");

				long half = sum / 2;

				long halfSum = 0;

				long i = Math.min(half, n);

				if(i == x){
					i--;
				}

				//System.out.println("Before WHile loop : "+half+" , "+halfSum+", "+i);
				
				while(i > 0){

					if( halfSum + i <= half && i != x ){
						halfSum += i;
						set.add(i);
						i = Math.min(half -halfSum, i);
					}else{
						i--;
					}

				}

				//System.out.println("HALF SUM  :: "+halfSum);
				//System.out.println("SET :: "+set);
				
				if(halfSum != half){
					System.out.println("impossible");
				}else{
					for(long j=1;j<=n;j++){
						System.out.print( j == x ? 2 : set.contains(j) ? 0 : 1 );
					}
					System.out.println();
				}


			}else{
				System.out.println("The sum is odd");
				System.out.println("impossible");
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
