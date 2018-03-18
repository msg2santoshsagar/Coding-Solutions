package com.alife.codechef.cook92b.co92matr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook92b/co92matr/input.txt";

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

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();

		while( tc -- > 0 ){

			int row 		= scanner.nextInt();
			int col			= scanner.nextInt();

			int[][] mat     = new int[row][col];

			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					mat[i][j] = scanner.nextInt();
				}
			}


			boolean isImpossible = false;

			StringBuilder sb = new StringBuilder();

			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){

					if(mat[i][j] == -1){

						int min = 1;
						int max = 2000000000;

						if(i>0 && mat[i-1][j] != -1){
							min = Math.max(min, mat[i-1][j]);
						}

						if(j>0 && mat[i][j-1] != -1 ){
							min = Math.max(min, mat[i][j-1]);
						}

						if( i< row-1  && mat[i+1][j] != -1 ){
							max = Math.min(max, mat[i+1][j]);
						}

						if( j < col-1 && mat[i][j+1] != -1 ){
							max = Math.min(max, mat[i][j+1]);
						}

						if(min <= max){
							mat[i][j] = min;
						}else{
							isImpossible = true;
							break;
						}

							//System.out.printf("i = %d , j = %d , min = %d , max = %d \n",i,j,min,max);

					}
					
					if( i > 0 && mat[i][j] < mat[i-1][j] ){
						isImpossible = true;
					}
					
					if(j > 0 && mat[i][j] < mat[i][j-1]){
						isImpossible = true;
					}

					sb.append(mat[i][j]);
					if(j != col-1){
						sb.append(" ");
					}


				}
				if(isImpossible){
					break;
				}
				if(i != row-1)
					sb.append("\n");
			}

			if(isImpossible){
				System.out.println(-1);
				continue;
			}

			System.out.println(sb);

			/*for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					System.out.print(mat[i][j]);
					if(j != col-1){
						System.out.println(" ");
					}
				}
				System.out.println();
			}*/



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
