package com.alife.google.codejam.save_universe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/google/codejam/save_universe/input.txt";

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

			System.out.print("Case #"+count+": ");

			long damage = scanner.nextInt();

			String program = scanner.nextToken();

			long estimatedDamage = getEstimatedDamage(program,damage);

			if(estimatedDamage<= damage){
				System.out.println(0);
			}else{

				boolean done = false;
				int     step = 0;
				StringBuilder sb = new StringBuilder(program);
				boolean solutionFound = false;

				while(!done){

					boolean swapDone = false;

					int index = sb.indexOf("CS");

					if(index!=-1){
						sb.setCharAt(index, 'S');
						sb.setCharAt(index+1, 'C');
						swapDone = true;
						step++;
					}

					if(swapDone){
						estimatedDamage = getEstimatedDamage(sb.toString(),damage);
						if(estimatedDamage <= damage){
							solutionFound = true;
							done = true;
						}
					}else{
						done = true;
					}

				}

				System.out.println(solutionFound ? step : "IMPOSSIBLE");


			}

		}



	}


	private long getEstimatedDamage(String program, long damage) {

		long ldamage = 0;
		long beamPow = 1;

		for(char c : program.toCharArray()){

			if(c=='S'){
				ldamage += beamPow; 
			}else{
				beamPow = beamPow*2;
			}

			if(ldamage > damage){
				return ldamage;
			}

		}


		return ldamage;
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
