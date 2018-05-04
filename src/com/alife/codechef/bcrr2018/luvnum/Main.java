package com.alife.codechef.bcrr2018.luvnum;

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



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/bcrr2018/luvnum/input.txt";

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

		int N = scanner.nextInt();
		
		while(N-->0){
			
			long num = scanner.nextLong();
			
			long small = -1;
			long big   = -1;
			
			
			String binStr 			= Long.toBinaryString(num);
			StringBuilder sb 		= new StringBuilder();
			for(char c : binStr.toCharArray()){
				sb.append(c == '1' ? '0' : '1');
			}
			small = Integer.parseInt(sb.toString(),2);
						
			sb.delete(0, sb.length());
			sb.append("1");
			for(int i=0;i<binStr.length();i++){
				sb.append("0");
			}
			
			big = Long.parseLong(sb.toString(),2);
			
			
			if(num==0){
				System.out.println("0 1");
			}else{
				System.out.println(small+" "+big);
			}
			
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