package com.alife.codechef.cook94b.cheftrvl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook94b/cheftrvl/input.txt";

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

	int globalSum 		= 0;
	String globalStr	= "";
	List<String> list = new ArrayList<>();
	int  K;

	private void solve(FastScanner scanner) {

		int t = scanner.nextInt();

		while(t-->0){

			int n = scanner.nextInt();

			int[][] mat = new int[n][n];

			for(int i=1; i<n ; i++){
				int row = scanner.nextInt()-1;
				int col = scanner.nextInt()-1;
				mat[row][col] = 1;
				mat[col][row] = 1;
			}

			int[]  ages = new int[n];

			for(int i=0; i<n; i++){
				ages[i] = scanner.nextInt();
			}

			/*System.out.println("===========INPUT MATRIX==================\n");
			printMatrix(mat, n);*/
			
			for(int i=0; i<n; i++){
				for(int j=i+1; j<n; j++){

					if(mat[i][j]>0){
						continue;
					}
					
					int minDistance = 0;
					
					for(int k=0;k<n;k++){
						
						if(i==k || j==k ){
							continue;
						}
						
						if( mat[i][k] > 0 && mat[k][j] > 0 ){
							int tmpPath = mat[i][k] + mat[k][j];
							if(minDistance == 0){
								minDistance = tmpPath;
							}else{
								minDistance = Integer.min(minDistance,tmpPath);
							}
						}
						
					}
					
					mat[i][j] = minDistance;
					mat[j][i] = minDistance;
					

				}
			}

			
			/*System.out.println("\n===========OUTPUT MATRIX==================\n");
			printMatrix(mat, n);*/
			
			int possibleCount = 0;
			
			for(int i=0 ; i<n ; i++){
				for(int j=i+1; j<n; j++){
					//System.out.println("i : "+i+", j :"+j+" , "+mat[i][j]+" , "+bitDiff(ages[i], ages[j]));
					if(mat[i][j] != bitDiff(ages[i],ages[j]) ){
						possibleCount++;
					}
				}
			}
			
			System.out.println(possibleCount);
			

		}


	}
	
	private int bitDiff(int a, int b) {
	
		String astr = Integer.toBinaryString(a);
		String bstr = Integer.toBinaryString(b);
		
		astr = new StringBuilder(astr).reverse().toString();
		bstr = new StringBuilder(bstr).reverse().toString();
		
		
		int min = Math.min(astr.length(), bstr.length());
		int max = Math.max(astr.length(), bstr.length());
		
		int diff = 0;
		
		for(int i=0; i<min;i++){
			if(astr.charAt(i) != bstr.charAt(i)){
				diff++;
			}
		}
		
		return diff+(max-min);
	}

	void printMatrix(int[][] mat, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}


	/**
	 * 
	 * I have borrowed this code from GFG. 
	 * This is to take input.
	 * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	 */
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