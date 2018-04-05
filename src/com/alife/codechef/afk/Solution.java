package com.alife.codechef.afk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/afk/input.txt";

	public static void main(String[] args){

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

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();

		while(tc-- > 0){

			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();


			if( c-b == b-a ){
				//System.out.printf("%4d %4d %4d :: MIN :    ",a,b,c);
				System.out.println(0);
			}else{

				int ma = a;
				int mb = b;
				int mc = c;

				int diff = mc-ma;

				if( diff % 2 == 0 ){
					mb = mc - (diff/2);

					int sum  = Math.abs(ma-a) +  Math.abs(mb-b) +Math.abs(mc-c);

					//System.out.printf("%4d %4d %4d :: MIN :    ",ma,mb,mc);
					System.out.println(sum);

				}else{


					int sum = Integer.MAX_VALUE;

					ma = ma-1;
					diff = mc-ma;
					mb = mc - (diff/2);

					int sumTemp  = Math.abs(ma-a) +  Math.abs(mb-b) +Math.abs(mc-c);

					if( sumTemp < sum ){
						sum = sumTemp;
					}

					ma = a;
					mb = b;
					mc = c;

					ma = ma+1;
					diff = mc-ma;
					mb = mc - (diff/2);

					sumTemp  = Math.abs(ma-a) +  Math.abs(mb-b) +Math.abs(mc-c);

					if( sumTemp < sum ){
						sum = sumTemp;
					}

					ma = a;
					mb = b;
					mc = c;

					mc = mc-1;
					diff = mc-ma;
					mb = mc - (diff/2);

					sumTemp  = Math.abs(ma-a) +  Math.abs(mb-b) +Math.abs(mc-c);

					if( sumTemp < sum ){
						sum = sumTemp;
					}


					ma = a;
					mb = b;
					mc = c;

					mc = mc+1;
					diff = mc-ma;
					mb = mc - (diff/2);

					sumTemp  = Math.abs(ma-a) +  Math.abs(mb-b) +Math.abs(mc-c);

					if( sumTemp < sum ){
						sum = sumTemp;
					}


					System.out.println(sum);
					
				}

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
