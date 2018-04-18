package com.alife.google.codejam.trouble_sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/google/codejam/trouble_sort/input.txt";

	public static void main(String[] args){

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


		int tc = scanner.nextInt();

		for(int count=1; count <= tc ; count++){

			int n = scanner.nextInt();

			int[] earr = new int[n/2];
			int[] oarr = new int[n-(n/2)];

			int e = 0, o = 0;

			for(int i=1;i<=n;i++){
				if( (i & 1 ) == 0 ){
					earr[e++] = scanner.nextInt();
				}else{
					oarr[o++] = scanner.nextInt();
				}
			}

			if(n < 4000){
				Arrays.sort(earr);
				Arrays.sort(oarr);
			}else{
				Arrays.parallelSort(earr);
				Arrays.parallelSort(oarr);
			}

			//System.out.println("Sorted Array : "+Arrays.toString(earr));
			//System.out.println(Arrays.toString(oarr));

			int notSortedIndex = getNotSortedIndex(earr,oarr,n);

			System.out.println("Case #"+(count)+": "+(notSortedIndex == -1 ? "OK" : notSortedIndex));

		}

	}

	private int getNotSortedIndex(int[] earr, int[] oarr, int n) {

		int prev = oarr[0] ;

		
		for(int i=0;i<n-1;i++){

			int next = ( (i+1) & 1)  == 0 ? oarr[(i+1)/2] : earr[(i+1)/2];

			//System.out.println("PREV NEXT : "+prev+" "+next);

			if(prev > next){
				return i;
			}
			
			prev = next;

		}
		return -1;
	}


	void troubleSort(int [] arr, int n ){

		boolean done = false;

		while(!done){
			done = true;
			for(int i = 0; i < n-2; i++){
				if(arr[i] >arr[i+2]){
					done = false;
					int temp = arr[i];
					arr[i] = arr[i+2];
					arr[i+2] = temp;
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
