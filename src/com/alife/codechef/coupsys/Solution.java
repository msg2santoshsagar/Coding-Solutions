package com.alife.codechef.coupsys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/coupsys/input.txt";

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

			int n = scanner.nextInt();


			int c1=0,c2=0,c3=0;
			int d1=0,d2=0,d3=0;

			while(n-->0){

				int city 	= scanner.nextInt();
				int level   = scanner.nextInt();
				int dis		= scanner.nextInt();
				
				if(level == 1){
					
					if(dis > d1){
						d1 = dis;
						c1  = city;
					}else if(dis == d1 && c1 > city){
						c1 = city;
					}
					
				}else if(level == 2){
					
					if(dis > d2){
						d2 = dis;
						c2  = city;
					}else if(dis == d2 && c2 > city){
						c2 = city;
					}
					
				}else{
					
					if(dis > d3){
						d3 = dis;
						c3  = city;
					}else if(dis == d3 && c3 > city){
						c3 = city;
					}
					
				}
				
				
			}
			
			System.out.println(d1+" "+c1);
			System.out.println(d2+" "+c2);
			System.out.println(d3+" "+c3);
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
