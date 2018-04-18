package com.alife.codechef.cole2018.cluscl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author Santosh Sagar
 * @notSolvedYet
 *
 */
public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cole2018/cluscl/input.txt";

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

		final int BUFFER = 12 * 60 * 60;
		
		while(tc-->0){

			//System.out.println("************************************************** "+tc);

			int p = scanner.nextInt();
			int q = scanner.nextInt();
			int n = scanner.nextInt();

			if(p == 0){
				System.out.println( (n+1)/2 );
				continue;
			}

			long timeTaken = 0;
			
			long realClock  		= 0;
			long defectiveClock 	= 0;
			
			
			
			if(p < 0){
				defectiveClock = BUFFER;
			}
			
			//int op = 10;
			
			while(true){
				
				realClock += q;
				
				defectiveClock += p;
				
				timeTaken += q;
				
				if(p < 0 && defectiveClock <= 0){
					defectiveClock += BUFFER;
				}
				
				if(p>0){
					defectiveClock %= BUFFER;
				}
				
				realClock %= BUFFER;
				
			//	System.out.println("CLOCK "+realClock+", "+defectiveClock);
				
			//	if(op--==0) break;
				
				if(realClock == defectiveClock){
					break;
				}
				
			}
			
		//	System.out.println("met :"+timeTaken);
			
			BigDecimal bd = BigDecimal.valueOf(timeTaken).multiply(BigDecimal.valueOf(n-1));
			
			//System.out.println("After multiplication : "+bd);
			
			bd = bd.add(BigDecimal.valueOf(24*60*60));
			
			bd = bd.divide(BigDecimal.valueOf(24*60*60),RoundingMode.FLOOR);
			
			
			
			System.out.println(bd);




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