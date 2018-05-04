package com.alife.codechef.iemco5.iemco5b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/iemco5/iemco5b/input.txt";

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

		while(tc-->0){

			int n 			= scanner.nextInt();
			int[] weight	= new int[n];

			for( int i=0; i< n; i++ ){
				weight[i] = scanner.nextInt();
			}

			long totalMaxEatable = 0;

			long max = 0;

			for(int i=0; i< n; i++){

				if(  weight[i] <= max ){
					continue;
				}

				boolean isOptimal = true;

				int lmax    = 0;

				for(int j=i+1; j<n;j++){

					if( weight[j] > max && weight[j] < weight[i] ){

						if(j == i+1){
							lmax += weight[j];
						}else if( weight[j] > weight[j-1] ){
							lmax += weight[j];
						}else{
							lmax = 0;
						}
					}else{
						lmax = 0;
					}

					if(lmax > weight[i]){
						isOptimal = false;
						break;
					}

				}

				if(isOptimal){
					//System.out.println("i found max : ");
					totalMaxEatable += weight[i];
					max = weight[i];
				}

			}


			System.out.println(totalMaxEatable);

		}

	}



	/*	private long getMaxEatable(int totalCake, int[] weight, int index, int lastWeight,long alreadyEat) {

		long maxEatable = alreadyEat;

		for( ; index < totalCake; index++ ){
			if(weight[index] > lastWeight){
				//System.out.println("Calling");
				maxEatable = Math.max(maxEatable, getMaxEatable(totalCake, weight, index+1, weight[index], alreadyEat + weight[index] ));
			}
		}

		return maxEatable;
	}*/



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