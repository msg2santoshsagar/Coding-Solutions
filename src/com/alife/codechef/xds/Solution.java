package com.alife.codechef.xds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/xds/input.txt";

	public static void main(String[] args) throws IOException{

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Solution solution = new Solution();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) throws IOException {

		int tc = scanner.nextInt();

		while(tc-- > 0){

			int N = scanner.nextInt();

			int a = 0;
			int b = 0;
			int max = Integer.MAX_VALUE;


			for (int i= (int)Math.ceil( Math.sqrt((double)N)); i>=1; i--)
			{
				if (N%i==0)
				{
					int divisor = N/i;

					// If divisors are equal, print only one
					if (divisor == i){
						if(max > i){
							a = i;
							b = i;
							break;
						}

					}else{ // Otherwise print both
						if(max > i){
							a = i;
							b = divisor;
							break;
						}
					}
				}
			}

			BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

			for(int i=0;i<a;i++){
				if(i%1000 == 0){
					log.flush();
				}
				log.write("X");
			}
			log.flush();
			for(int i=0;i<b;i++){
				log.write("D");
				if(i%1000 == 0){
					log.flush();
				}
			}
			log.write("\n");
			log.flush();

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
