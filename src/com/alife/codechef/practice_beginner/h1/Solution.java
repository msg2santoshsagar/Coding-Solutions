package com.alife.codechef.practice_beginner.h1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/xxor/input.txt";

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

	private void solve(FastScanner scanner) {

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		int[]    	array	  	= 	new int[n];
		int[][]		matrix      =   new int[n][31];
		int[][]		countMat	=   new int[n][31];	

		for(int i=0;i<n;i++){
			array[i] 	= scanner.nextInt();

			String binary		= Integer.toBinaryString(array[i]);
			int	   binLen 		= binary.length();

			int col =0;
			for(int j = binLen-1 ; j >= 0 ; j--){
				matrix[i][col++] = binary.charAt(j) - 48;
			}

		}

		for(int i = 0 ; i< n ; i++ ){
			for(int j = 0; j< 31 ; j++){

				if( i == 0){
					countMat[i][j] = matrix[i][j];
				}else{
					if(matrix[i][j] == 1){
						countMat[i][j] = countMat[i-1][j]+1; 
					}else{
						countMat[i][j] = countMat[i-1][j];
					}
				}
			}
		}

		while( q -- > 0 ){

			int l = scanner.nextInt();
			int r = scanner.nextInt();

			int range = r-l+1;

			int binNum 	= 0;
			int pctr 	= 0;


			for(int i = 0; i < 31 ; i++ ){

				int oneCount 	= countMat[r-1][i] - countMat[l-1][i] ;
				if( matrix[l-1][i] == 1 ){
					oneCount ++;
				}

				int zeroCount	= range - oneCount;

				if(oneCount < zeroCount){
					binNum += Math.pow(2, pctr);
				}
				pctr++;

			}

			System.out.println(binNum);

		}




	}// solve method

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
