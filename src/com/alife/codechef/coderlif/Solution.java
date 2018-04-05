package com.alife.codechef.coderlif;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/coderlif/input.txt";

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

			boolean bored = false;

			int num = 30;
			int cw  = 0;
			while(num-->0){

				int worked = scanner.nextInt();

				if(worked==1){
					cw++;
					if(cw>5){
						bored = true;
					}
				}else{
					cw = 0;
				}


			}
			
			System.out.println(bored ? "#coderlifematters" : "#allcodersarefun");

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
