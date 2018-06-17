package com.alife.codechef.ltime60b.plus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/ltime60b/plus/input.txt";

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

	private void solve(FastScanner sc) {

		int tc = sc.nextInt();

		while(tc-- > 0){

			int row = sc.nextInt();
			int col = sc.nextInt();

			//System.out.println("Row : "+row+", COL : "+col);

			int[][] mat = new int[row+1][col+1];

			for(int i=1;i<=row;i++){
				for(int j=1;j<=col;j++){
					mat[i][j] = sc.nextInt();
				}
			}

			int maxSum = 0;
			
			
			for(int i=2;i<row;i++){

				for(int j=2;j<col;j++){
					
					int tmpSum = mat[i][j] /*+ mat[i-1][j] + mat[i+1][j] + mat[i][j-1] + mat[i][j+1]*/;
					
					boolean done = false;
					
					int armsLengthRow = Math.min(row-i, i);
					int armsLengthCol = Math.min(col-j, j);
					

					System.out.println("Arms len row : "+armsLengthRow);
					System.out.println("Arms len col : "+armsLengthCol);
					
					//System.out.println("TMP SUM : "+tmpSum);
					maxSum = Integer.max(maxSum, tmpSum);

				}


			}

			System.out.println(maxSum);


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