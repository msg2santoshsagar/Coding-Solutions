package com.alife.google.codejam.round1c.problem3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/google/codejam/round1c/problem3/input.txt";

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

	private void solve(FastScanner sc) {

		int tc = sc.nextInt();

		int ques = 0;

		while(ques<tc){

			ques++;


			int n = sc.nextInt();

			long weights[] = new long[n];

			for(int i=0; i<n; i++){
				weights[i] = sc.nextLong();
			}


			map = new HashMap<>();
			System.out.println("Case #"+ques+": "+dp(weights,0,0,0));
		}


	}

	Map<String, Long> map = new HashMap<>();

	private long dp(long[] weights, int index, int stackSize, long sum) {

		
		String str = index+"-"+stackSize+"-"+sum;
		
		if(map.containsKey(str)){
			//System.out.println("Returning from map");
			return map.get(str);
		}

		if(index==weights.length){
			//System.out.println("Returning stack size : "+sum);
			return stackSize;
		}

		long tmp1 = 0;

		if(sum <= weights[index]*6){
			//System.out.println("Calculating");
			tmp1 = dp(weights, index+1, stackSize+1, sum+weights[index]);
			//System.out.println("Tmp1 calculated as "+tmp1);
		}


		long tmp2 = dp(weights, index+1, stackSize, sum);

		map.put(str, Math.max(tmp1, tmp2));
		
		return map.get(str);
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