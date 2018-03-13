package com.hackerearth.maximum_element;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/hackerearth/maximum_element/input.txt";

	public static void main(String[] args) throws Exception{

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}


		int queryCount = scanner.nextInt();

		Stack<Integer>  stack 		= 	new Stack<>();
		Stack<Integer>  maxStack 	= 	new Stack<>();


		while( queryCount -- > 0 ){

			int type = scanner.nextInt();

			if(type == 1){
				int num = scanner.nextInt();
				stack.push(num);
				if(maxStack.isEmpty()){
					maxStack.push(num);
				}else{
					int top = maxStack.peek();
					if(num >= top){
						maxStack.push(num);
					}
				}
			}else if(type == 2){
				int top = stack.pop();
				if(!maxStack.isEmpty() && maxStack.peek() ==top){
					maxStack.pop();
				}
			}else{
				System.out.println(maxStack.peek());
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