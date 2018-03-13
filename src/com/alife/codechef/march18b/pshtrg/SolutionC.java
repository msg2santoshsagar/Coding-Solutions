package com.alife.codechef.march18b.pshtrg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SolutionC {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/pshtrg/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner 		= null;
		boolean 	isLogEnabled		= false;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
			isLogEnabled = true;
		}

		SolutionC solution = new SolutionC();
		solution.solve(scanner,isLogEnabled);
	}

	private void solve(FastScanner scanner,boolean isLogEnabled){

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		long[]    	array	  	= new long[n];
		long[][]	matrix		= new long[n][n];

		for(int i=0;i<n;i++){
			array[i] 	= scanner.nextLong();
		}

		for(int i=0; i< n-2; i++){

			for(int j=i+2; j< n; j++){

				int k = j-1;
				while( k>=0 && matrix[i][k] != 0 ){
					k--;
				}

				k = k+1;

				long[] arr = Arrays.copyOfRange(array, k-2, j+1);

				if( arr.length == 3 ){
					if(isValidTriangle(arr[0], arr[1], arr[2])){
						matrix[i][j] = arr[0]+arr[1]+arr[2];
					}
				}else{

					Arrays.sort(arr);
					int len = arr.length;

					for(int v =len-1; v >= 2 ; v-- ){

						if( arr[v-1] + arr[v-2] > arr[v]  ){
							matrix[i][j] = arr[v]+arr[v-1]+arr[v-2];
							break;
						}
					}

				}

			}

		}

		if(isLogEnabled){
			printMat(matrix);
		}


		while( q -- > 0 ){

			int choice = scanner.nextInt();
			int l    = scanner.nextInt();
			int r  = scanner.nextInt();

			if(choice == 1){
				
				array[l-1]  = r;
				
				
				for(int i=0; i< l; i++){

					for(int j=i+2; j< n; j++){

						int k = j-1;
						while( k>=0 && matrix[i][k] != 0 ){
							k--;
						}

						k = k+1;

						long[] arr = Arrays.copyOfRange(array, k-2, j+1);

						if( arr.length == 3 ){
							if(isValidTriangle(arr[0], arr[1], arr[2])){
								matrix[i][j] = arr[0]+arr[1]+arr[2];
							}
						}else{

							Arrays.sort(arr);
							int len = arr.length;

							for(int v =len-1; v >= 2 ; v-- ){

								if( arr[v-1] + arr[v-2] > arr[v]  ){
									matrix[i][j] = arr[v]+arr[v-1]+arr[v-2];
									break;
								}
							}

						}

					}

				}
				
				
				
			}else{
				System.out.println(matrix[l-1][r-1]);
			}


		} // while method


	}// solve method

	private void printMat(long[][] matrix) {
		int n = matrix[0].length;
		System.out.println("============================================================================");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("============================================================================");
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

	private boolean isValidTriangle(long i, long j, long k){

		if( i+j > k && i+k > j && j+k > i ){
			return true;
		}

		return false;
	}


}
