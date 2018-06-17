package com.alife.codechef.ltime60b.trace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/ltime60b/trace/input.txt";

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

			int n = sc.nextInt();

			int[][] mat = new int[n+1][n+1];

			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					mat[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			
			
	//		System.out.println("Portion 1 : ");
			for(int i=n; i>=1 ; i-- ){
				int temp = 0;
				int k=i;
			//	System.out.println("K = : "+k);
				for(int j=1;j<=n;j++){
					temp += mat[k][j];
			//		System.out.println("k : "+k+", j : "+j+", v : "+mat[k][j]);
					if(k==n){
						break;
					}
					k++;
				}
	//			System.out.println("Temp : "+temp);
				max = Math.max(max, temp);
			}
			
	//		System.out.println(" p 1 : "+max);
			
			
			
	//		System.out.println("\n\nPortion 2 : ");
			for(int i=n; i>1 ; i-- ){
				int temp = 0;
				int k=i;
			//	System.out.println("K = : "+k);
				for(int j=1;j<=n;j++){
					temp += mat[j][k];
			//		System.out.println("k : "+k+", j : "+j+", v : "+mat[k][j]);
					if(k==n){
						break;
					}
					k++;
				}
			//	System.out.println("Temp : "+temp);
				max = Math.max(max, temp);
			}
			
		//	System.out.println(" p 2 : "+max);
			
			
	//		System.out.println("\n\nPortion 3 : ");
			/*for(int i=n; i>=1 ; i-- ){
				int temp = 0;
				int k=i;
			//	System.out.println("K = : "+k);
				for(int j=1;j<=n;j++){
					temp += mat[j][k];
			//		System.out.println("k : "+k+", j : "+j+", v : "+mat[k][j]);
					if(k==1){
						break;
					}
					k--;
				}
			//	System.out.println("Temp : "+temp);
				max = Math.max(max, temp);
			}
			
		//	System.out.println(" p 3 : "+max);
			
			
		//	System.out.println("\n\nPortion 4 : ");
			for(int i=n; i>1 ; i-- ){
				int temp = 0;
				int k=i;
			//	System.out.println("K = : "+k);
				for(int j=n;j>=1;j--){
					temp += mat[k][j];
			//		System.out.println("k : "+k+", j : "+j+", v : "+mat[k][j]);
					if(k==n){
						break;
					}
					k++;
				}
				//System.out.println("Temp : "+temp);
				max = Math.max(max, temp);
			}*/
			
			//System.out.println(" p 4 : "+max);
			
			System.out.println(max);


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