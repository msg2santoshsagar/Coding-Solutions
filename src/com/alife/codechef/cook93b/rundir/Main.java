package com.alife.codechef.cook93b.rundir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cook93b/rundir/input.txt";

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
	
	static class Data{
		double x;
		double v;
		public Data(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Data [x=" + x + ", v=" + v + "]";
		}
		
		
	}

	private void solve(FastScanner scanner) {

		int t = scanner.nextInt();

		while(t-->0){

			int N = scanner.nextInt();
			
			Data[] datas = new Data[N];
			
			for(int i=0; i<N;i++){
				datas[i] = new Data(scanner.nextInt(),scanner.nextInt());
			}
			
			double time = Double.MAX_VALUE;

			for(int i=0; i<N; i++){
				
				for(int j=i+1; j < N; j++){
					
					Data first 	= datas[i];
					Data second = datas[j];
					
					double timelocal = Double.MIN_VALUE;
					
					// Both is moving in +x direction
					if(second.v - first.v != 0){
						
						double temp = (first.x  - second.x) / (second.v - first.v);
						
						if(temp>0){
							timelocal = Double.max(temp, timelocal);
							System.out.println("i = "+i+", j = "+j+", 1 : "+time);
						}
						
					}
					
					// Both is moving in -x direction
					if(-1*second.v - -1*first.v != 0){
						
						double temp = (first.x  - second.x) / (-1*second.v - -1*first.v);
						
						if(temp>0){
							timelocal = Double.max(temp, timelocal);
							System.out.println("i = "+i+", j = "+j+", 2 : "+time);
						}
						
					}
					
					// First in +ve and second in -x direction
					if(-1*second.v - first.v != 0){
						
						double temp = (first.x  - second.x) / (-1*second.v - first.v);
						
						if(temp>0){
							timelocal = Double.max(temp, timelocal);
							System.out.println("i = "+i+", j = "+j+", 3 : "+time);
						}
						
					}
					
					// First in -ve and second in +x direction
					if(second.v - -1*first.v != 0){
						
						double temp = (first.x  - second.x) / (second.v - -1*first.v);
						
						if(temp>0){
							timelocal = Double.max(temp, timelocal);
							System.out.println("i = "+i+", j = "+j+", 4 : "+time);
						}
						
					}
					
					
					Double.min(timelocal, time);
					
					
				}
				
			}
			
			System.out.println(time);

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