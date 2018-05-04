package com.alife.codechef.ltime59b.gcddiv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/ltime59b/gcddiv/input.txt";

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

		while(tc-- > 0){

			int n = scanner.nextInt();
			int k = scanner.nextInt();

			boolean isFt	   =  true;

			int gcd=0;

			for(int i=0; i<n; i++){
				int number = scanner.nextInt();

				if(isFt){
					gcd = number;
					isFt = false;
				}else{

					gcd = gcd(gcd,number);

				}

			}

			System.out.println("GCD : "+gcd);

			if(gcd <= k){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}


	}


	private int gcd(int a, int b){
		while( b % a != 0 ){

			int temp = b % a;
			b = a;
			a = temp;

		}
		return a;
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