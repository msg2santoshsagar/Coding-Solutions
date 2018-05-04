package com.alife.codechef.locapr2018.pallind;

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



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/locapr2018/pallind/input.txt";

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

		final int mod = 1_000_000_007; 

		while(tc-->0){

			int N = scanner.nextInt();

			long num = 28;
			int den  = 0;

			for(int i=0;i<26;i++){
				for(int j=0;j<26;j++){
					for(int k=0;k<26;k++){
						char[] c = new char[]{ (char) ( i+'a'),(char) (j+'a') ,(char) (k+'a')   };
						if(isPalindrome( String.valueOf(c)  )){
							den++;
						}
					}
				}
			}

			System.out.println("Den : " +den);

			long inverse  = modInverse(den, mod);

			System.out.println("Inverse : "+inverse);

			System.out.println((num*inverse) %mod);

		}


	}

	private boolean isPalindrome(String string) {
		System.out.println("To check "+string);
		return string.equals(new StringBuilder(string).reverse().toString());
	}

	public static int ncr(int n, int r){
		return fact(n) / (fact(n-r)*fact(r));
	}

	public static int fact(int num)
	{
		int fact=1, i;
		for(i=1; i<=num; i++)
		{
			fact = fact*i;
		}
		return fact;
	}

	// Function to find modular inverse of a 
	// under modulo m Assumption: m is prime
	static long modInverse(int a, int m){
		return	power(a, m - 2, m);
	}

	// To compute x^y under modulo m
	static long power(int x, int y, int m) 
	{
		if (y == 0)
			return 1;

		long p = power(x, y / 2, m) % m;
		p = (p * p) % m;

		if (y % 2 == 0)
			return p;
		else
			return (x * p) % m;
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