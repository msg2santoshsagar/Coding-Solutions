package com.alife.codechef.zubreach;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/zubreach/input.txt";

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
		
		int cnt = 1;

		while(tc-- > 0){
			
			int M = scanner.nextInt();
			int N = scanner.nextInt();
			
			int RX = scanner.nextInt();
			int RY = scanner.nextInt();
			
			int moveSeq = scanner.nextInt();
			
			String str = scanner.nextLine();
			
			int px = 0;
			int py = 0;
			
			for(int i=0;i<moveSeq;i++){
				char c = str.charAt(i);
				
				if(c == 'U'){
					py++;
				}else if(c == 'D'){
					py--;
				}else if(c == 'L'){
					px--;
				}else{
					px++;
				}
				
			}
		
			System.out.print("Case "+(cnt++)+": ");
			
			if(px == RX && py == RY){
				System.out.println("REACHED");
			}else if(px < 0 || px > M || py < 0 || py > N){
				System.out.println("DANGER");
			}else{
				System.out.println("SOMEWHERE");
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
