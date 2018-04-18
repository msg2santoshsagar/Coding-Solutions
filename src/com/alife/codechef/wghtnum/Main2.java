package com.alife.codechef.wghtnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main2 {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/wghtnum/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Main2 solution = new Main2();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();

		//final int MOD = 1_000_000_007;

		while(tc-->0){

			int  N 	= 	scanner.nextInt();
			int  W  = 	scanner.nextInt();
			
			int count = 0;
			
			StringBuilder sb = new StringBuilder("1");
			IntStream.range(1, N).forEach( (a) ->  sb.append("0") );
			int min  = Integer.parseInt(sb.toString());
			
			sb.delete(0, sb.length());
			IntStream.rangeClosed(1, N).forEach( (a) ->  sb.append("9") );
			int max  = Integer.parseInt(sb.toString());
			
			//System.out.println("MIN : "+min+", MAX : "+max);
			
			for(; min<=max; min++ ){
				
				int number = min;
				
				int prev = number % 10;
				number   = number / 10;
				
				int sum = 0;
				
				while( number  != 0){
					
					int temp = number % 10;
					number /= 10;
					sum += prev - temp;
					
					prev = temp;
				}
				
				if( sum  == W ){
					System.out.println(min);
					count++;
				}
				
			}
			
			System.out.println("\nTOTAL COUNT : "+count);
			

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