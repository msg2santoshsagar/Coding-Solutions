package com.alife.tcs.hackerrank.diamonmine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main2 {



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

			System.out.println("A value : "+a);
			
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

		int xpos = 0, ypos = 0;

		int diamondCollected = 0;

		while(xpos < n && ypos < n){
			
			System.out.printf("1. X : %d, Y : %d\n",xpos,ypos);

			if(mat[xpos][ypos] == 1){
				mat[xpos][ypos] = 0;
				diamondCollected++;
			}
			
			if(xpos == n-1){
				ypos++;
				continue;
			}
			
			if(ypos == n-1){
				xpos++;
				continue;
			}

			if( mat[xpos+1][ypos] != -1 && diamondCollected + mat[xpos+1][ypos] >=  diamondCollected + mat[xpos][ypos+1] ){
				xpos++;
			}else if(mat[xpos][ypos] != -1){
				ypos++;
			}else{
				return -1;
			}


		}

		/*while(xpos < n-1){
			System.out.printf("2. X : %d, Y : %d\n",xpos,ypos);
			if(mat[xpos][ypos] == 1){
				mat[xpos][ypos] = 0;
				diamondCollected++;
			}
			xpos++;
		}

		while(ypos < n-1){
			System.out.printf("3. X : %d, Y : %d\n",xpos,ypos);
			if(mat[xpos][ypos] == 1){
				mat[xpos][ypos] = 0;
				diamondCollected++;
			}
			ypos++;
		}
		
		if(mat[n-1][n-1] == 1){
			mat[n-1][n-1] = 0;
			diamondCollected++;
		}*/

		return diamondCollected;
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
