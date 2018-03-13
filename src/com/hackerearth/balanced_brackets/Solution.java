package com.hackerearth.balanced_brackets;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/hackerearth/balanced_brackets/input.txt";

	public static void main(String[] args) throws Exception{

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}


		int n = scanner.nextInt();

		Stack<Character>  stack 		= 	null;

		while( n-- > 0 ){

			String str = scanner.nextLine();
			
			if( str.length() % 2 != 0 ){
				System.out.println("NO");
				continue;
			}

			char[] charArray = str.toCharArray();
			stack 		= 	new Stack<>();
			int ctr  = 1;
			boolean isFound = true;

			for(char c: charArray){

				if( c == '{' || c == '[' || c == '(' ){
					stack.push(c);
				}else{

					char top = '1';
					if(!stack.isEmpty()){
						top = stack.peek();
					}

					if( ( c == ')' && top == '(' ) ||  ( c == '}' && top == '{' ) || ( c == ']' && top == '[' )  ){
						stack.pop();
					}else{
						System.out.println("BREAK :: "+stack.toString());
						isFound = false;
						break;
					}


				}
				
				System.out.println("OPERATON : "+ctr+" : "+stack.toString());
				ctr++;

			}

			System.out.println(isFound && stack.isEmpty() ? "YES" : "NO");

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