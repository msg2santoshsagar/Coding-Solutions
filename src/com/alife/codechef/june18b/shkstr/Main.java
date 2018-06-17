package com.alife.codechef.june18b.shkstr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/june18b/shkstr/input.txt";

	public static void main(String[] args) throws IOException{

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

	
	private void solve(FastScanner sc) throws IOException {

		int n 				= sc.nextInt();
		String[] strings 	= new String[n];
		
		for(int i=0; i<n; i++){
			strings[i] = sc.nextLine();
		}
		
		int q               = sc.nextInt();
		
		while(q-->0){
			
			int index 	= sc.nextInt();
				
			String str	= sc.nextToken();
			
		//	System.out.println("INDEX : "+index+", STR : "+str);
			
			String LCP = "";
			
			String smallestStr  = strings[0];
			
			for(int i=0; i<index; i++){
				String commonPrefix = getCommonPrefix(str,strings[i]);
				//System.out.println("PREFIX : "+commonPrefix);
				
				if(commonPrefix.length() == LCP.length() ){
					
					if(strings[i].compareTo(smallestStr) < 0){
						smallestStr = strings[i];
					}
					
				}else{
					LCP = commonPrefix;
					smallestStr = strings[i];
				}
				
			}
			
			System.out.println(smallestStr);
			
		}
		
	}



	private String getCommonPrefix(String str, String string) {
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<Integer.min(str.length(), string.length()); i++){
			if(str.charAt(i) == string.charAt(i)){
				sb.append(str.charAt(i));
			}
			else{
				break;
			}
		}
		
		
		return sb.toString();
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