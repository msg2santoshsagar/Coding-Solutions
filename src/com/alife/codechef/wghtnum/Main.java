package com.alife.codechef.wghtnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/wghtnum/input.txt";

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

		final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

		//final BigInteger INT_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
		
		final BigInteger TEN	 = BigInteger.valueOf(10);

		while(tc-->0){

			String  N 	= 	scanner.nextToken();
			int  	W  = 	scanner.nextInt();

			BigInteger number  = new BigInteger(N);

			int multiplier = 0;


			if(  W < -9 || W > 8  ){
				System.out.println(0);
				continue;
			}

			if(W < 0){
				multiplier =  10 + W;
			}else{
				multiplier = 9 - W;
			}


			BigInteger number2 = number.subtract(BigInteger.valueOf(2));

			BigInteger power   = BigInteger.valueOf(multiplier);
			
			power = power.multiply(pow(TEN,number2)).mod(MOD);

			System.out.println(power);


		}

	}

	BigInteger pow(BigInteger base, BigInteger exponent) {
		BigInteger result = BigInteger.ONE;
		final BigInteger MOD = BigInteger.valueOf(1_000_000_007);
		while (exponent.signum() > 0) {
			if (exponent.testBit(0)) result = result.multiply(base);
			base = base.multiply(base).mod(MOD);
			exponent = exponent.shiftRight(1);
		}
		return result;
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