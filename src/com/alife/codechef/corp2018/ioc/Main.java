package com.alife.codechef.corp2018.ioc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/corp2018/ioc/input.txt";

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
	
	public static class Cake implements Comparable<Cake>{
		
		int breadth;
		int length;
		int max;
		
		
		
	
		public Cake(int length, int breadth) {
			super();
			this.breadth =  breadth;
			this.length  =  length;
			this.max     =  2*Math.max(length, breadth);
		}



		@Override
		public String toString() {
			return "Cake [breadth=" + breadth + ", length=" + length + ", max=" + max + "]";
		}



		@Override
		public int compareTo(Cake o) {
			return o.max - this.max;
		}
		
	}

	private void solve(FastScanner scanner) {

		int numberOfCakes = scanner.nextInt();
		int maxCuts       = scanner.nextInt();
		
		List<Cake>  cakes     = new ArrayList<>(numberOfCakes);
		
		for(int i=0; i< numberOfCakes; i++){
			
			int length  = scanner.nextInt();
			int breadth = scanner.nextInt();
			
			cakes.add(new Cake(length,breadth));
			
		}
		
		Collections.sort(cakes);
			
		//System.out.println(cakes);
		
		long icingRequired = 0;
		
		for(int i=0;i<maxCuts;i++){
			icingRequired += cakes.get(i).max;
		}
		
		System.out.println(icingRequired);
		
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