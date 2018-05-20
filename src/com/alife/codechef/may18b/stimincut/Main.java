package com.alife.codechef.may18b.stimincut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/may18b/stimincut/input.txt";

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

		while(tc-->0){

			int n = sc.nextInt();

			int [][] mat = new int[n][n];

			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					mat[i][j] = sc.nextInt();
				}
			}

			int minCost = 0;

			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){

					if(mat[i][j] > mat[j][i]){
						minCost += mat[i][j] - mat[j][i];
						mat[j][i] = mat[i][j];
					}else if(mat[i][j] < mat[j][i]){
						minCost += mat[j][i] - mat[i][j];
						mat[i][j] = mat[j][i];
					}

				}
			}

			System.out.println("\n=============================Printing Matrix=============================\n");

			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.printf("%5d",mat[i][j]);
				}
				System.out.println();
			}

			System.out.println("\nCURRENT MIN COST : "+minCost);

			possibleGraphs(mat,n,0,0,0);

		}

	}


	List<String>  list = new ArrayList<>();

	private void possibleGraphs(int [][] matrix, int size, int fromIndex, int toIndex , int edges ){

		System.out.println("POSSIBLE GRAPHS INDEX : "+fromIndex+"-"+toIndex+", EDGES COUNT :"+edges+", LIST : "+list);


		if(edges == size-1){
			System.out.println("LIST : "+list);
			return;
		}


		for(int i=fromIndex; i<size; i++){
			for(int j=0;j<size;j++){

				if(i==j){
					continue;
				}

				int big 	= Integer.max(i, j);
				int small 	= Integer.min(i, j);

				if(list.contains(small+"-"+big)){
					continue;
				}

				if(matrix[small][big] > 0){
					list.add(small+"-"+big);
					possibleGraphs(matrix,size,i,j,edges+1);
					list.remove(small+"-"+big);
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