package com.alife.tcs.hackerrank.diamonmine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/tcs/hackerrank/diamonmine/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		solve(scanner);

	}

	private static void solve(FastScanner scanner) {

		int tc 		= scanner.nextInt();


		while( tc -- > 0 ){

			int N = scanner.nextInt();
			int R = scanner.nextInt();

			int[][] mat = new int[N][R];

			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					mat[i][j] = scanner.nextInt();
				}
			}

			System.out.println("********************INPUT************************************");
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.printf("%5d",mat[i][j]);
				}
				System.out.println();
			}
			System.out.println("************************/INPUT********************************");

			int a  = collect_max(mat);

			int n = mat.length;
			System.out.println("********************MATRIX************************************");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.printf("%5d",mat[i][j]);
				}
				System.out.println();
			}
			System.out.println("************************/MATRIX********************************");


			int b  = collect_max(mat);

			if(a == -1 || b ==-1)
				System.out.println(0);
			else
				System.out.println(a+b);


		}


	}

	final static int MIN_VALUE = -9;

	/*
	 * Complete the function below.
	 */
	static int collect_max(int[][] mat) {

		int n = mat[0].length;

		if( mat[0][0] == -1 || mat[n-1][n-1] == -1 ){
			return 0;
		}

		int sum[][] = new int[n][n];

		for(int i=0;i<n;i++)
			Arrays.fill(sum[i], MIN_VALUE);

		sum[0][0] = mat[0][0];

		for(int i=1;i<n;i++){
			if(mat[0][i]!=-1 && sum[0][i-1]!= MIN_VALUE)
				sum[0][i] = mat[0][i]==1 ? sum[0][i-1]+1 : sum[0][i-1];			
		}

		for(int i=1;i<n;i++){
			if(mat[i][0]!=-1 && sum[i-1][0]!=MIN_VALUE)
				sum[i][0] = mat[i][0]==1 ? sum[i-1][0]+1 : sum[i-1][0];			
		}

		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				if(mat[i][j]!=-1 && (sum[i-1][j]!=MIN_VALUE || sum[i][j-1]!=MIN_VALUE)){				
					sum[i][j] = mat[i][j]==1 ? 1+Math.max(sum[i][j-1],sum[i-1][j]) : Math.max(sum[i][j-1],sum[i-1][j]);
				}
			}
		}

		System.out.println("********************************************************");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("%5d",sum[i][j]);
			}
			System.out.println();
		}
		System.out.println("********************************************************");

		if(sum[n-1][n-1] == MIN_VALUE){
			return -1;
		}

		int col = n-1, row = n-1;

		while( col > 0  && row > 0){
			System.out.println("Row : "+row+", COL : "+col);
			if(mat[row][col]==1){
				mat[row][col] = 0;
			}

			if(sum[row-1][col] == sum[row][col-1]){
				col--;
			}else if(sum[row-1][col]>sum[row][col-1]){
				row--;
			}else if(sum[row-1][col]<sum[row][col-1]){
				col--;
			}

		}

		while(col!=0){
			if(mat[row][col]==1){
				mat[row][col] = 0;
			}
			col--;
		}
		while(row!=0){
			if(mat[row][col]==1)
				mat[row][col] = 0;
			row--;
		}

		if(mat[0][0]==1){
			mat[0][0]=0;
		}


		return sum[n-1][n-1];


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
