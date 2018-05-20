package com.alife.codechef.may18b.dbfb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/may18b/dbfb/input.txt";

	private static final int mod = 1_000_000_007;

	long am = 0, bm = 0;

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

			int[] a = new int[m];
			int[] b = new int[m];

			for(int i=0;i<m;i++){
				a[i] = sc.nextInt();
			}

			long sum = 0;

			for(int i=0;i<m;i++){
				b[i] = sc.nextInt();
				sum += b[i];
				if(sum>mod){
					sum = sum % mod;
				}
			}

			//System.out.println("Solution By Method 1 : "+method1(a,b,m,n));
			
			/*System.out.println("Array a : "+Arrays.toString(a));
			System.out.println("Array b : "+Arrays.toString(b));
			System.out.println("Value of n : "+n);
			System.out.println("SUM  : "+sum);

			System.out.println("Solution By Method 1 : "+method1(a,b,m,n));
			//System.out.println(method1(a,b,m,n));
*/
			

			am = 0;
			bm = 0;

			if(n==1){
				am=1;
				bm=0;
			}else if(n==2){
				am=0;
				bm=1;
			}else{

				am = 0;
				bm = 1;

				for(int i=3; i<=n ;i++){
					long temp = (am+bm) % mod;
					am = bm;
					bm = temp;
				}

			}

			//System.out.print("am : "+am+", bm : "+bm);
			
			//System.out.println("Solution By Method 2 : "+method2(a,sum,am,bm));
			System.out.println(method2(a,sum,am,bm));

		}

	}


	/*private long method1(int []a, int[] b, int m, int n){

		long result = 0;

		long[] fib = new long[Math.max(2,n)];

		for(int i=0; i<m; i++){

			for(int j=0; j<m; j++){

				fib[0] = a[i];
				fib[1] = b[j];

				for(int k=2; k<n; k++){
					fib[k] = ( fib[k-1]+fib[k-2] ) % mod;
				}

				System.out.println("FIb N-1 Value : "+fib[n-1]);

				result = result + fib[n-1];
				result = result % mod;


			}

		}

		return result;

	}*/

	private long method2(int []a,long sum,long am, long bm){

		//System.out.println("Method 2 Sum = "+sum);

		long result = 0;
		
		int m = a.length;

		for(int i=0; i<a.length;i++){
			result = ( result + ( ( ( (am * m) % mod ) * a[i]) % mod ) + ( (bm * sum) % mod) ) % mod ;
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