package com.alife.codechef.qoc2018.vegeta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/qoc2018/vegeta/input.txt";

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

	private void solve(FastScanner sc) {

		int tc = sc.nextInt();

		while(tc-->0){

			int m = sc.nextInt();
			int n = sc.nextInt();
			
			long count = 0;
			
			for(;m<n;m++){
				count += countOfUniquePrimeFactor(m);
			}
			
			System.out.println(count);

		}

	}
	
	public long countOfUniquePrimeFactor(int n){

		long count = 0;
		
		boolean ip = true;
		
		// Print the number of 2s that divide n
		while (n%2==0)
		{
			n /= 2;
			if(ip){
				count++;
				ip = false;
			}
		}

		// n must be odd at this point.  So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i+= 2)
		{
			ip = true;
			// While i divides n, print i and divide n
			while (n%i == 0)
			{
				n /= i;
				if(ip){
					count++;
					ip = false;
				}
			}
		}

		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
			count++;
		
		return count;
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