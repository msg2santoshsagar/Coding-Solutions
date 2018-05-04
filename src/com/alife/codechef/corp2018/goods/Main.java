package com.alife.codechef.corp2018.goods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/corp2018/goods/input.txt";

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

		int	 numberOfPeople 	= 	 scanner.nextInt();
		long minLaddoToReddem 	=	 scanner.nextLong();
		
		long[] ladoos			=    new long[numberOfPeople];
		
		for(int i=0; i<numberOfPeople; i++){
			ladoos[i] = scanner.nextLong();
		}
		
		Arrays.sort(ladoos);
		
		//System.out.println("SORTED : "+Arrays.toString(ladoos));

		int low 	= 0;
		int high	= numberOfPeople-1;
		
		while(low<high){
			
			if( ladoos[low] + ladoos[high] >= minLaddoToReddem ){
				low++;
				high--;
				numberOfPeople -= 2;
			}else{
				low++;
			}
			
		}
		
		System.out.println(numberOfPeople);
			

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