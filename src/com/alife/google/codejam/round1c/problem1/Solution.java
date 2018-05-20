package com.alife.google.codejam.round1c.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/google/codejam/round1c/problem1/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Solution solution = new Solution();
		solution.solve(scanner);

	}

	private void solve(FastScanner sc) {

		int tc = sc.nextInt();

		int ques = 0;

		while(ques<tc){

			ques++;


			int N = sc.nextInt();
			int L = sc.nextInt();

			List<String> strings = new ArrayList<>(N);

			List<Set<Character>> list = new ArrayList<>();

			for(int i=0; i<N; i++){
				String str = sc.nextLine();
				//System.out.println("Str : "+str);
				strings.add(str);
				for(int j=0; j<L; j++){
					//System.out.println("List size : "+list.size());
					if(list.size() <= j){
						list.add(new HashSet<>());
					}

					list.get(j).add(str.charAt(j));
				}
			}

			//System.out.println(list);

			String word = getNewWord(L,strings,list,0,"");

			System.out.println("Case #"+ques+": "+word);


		}



	}

	private String getNewWord(int l, List<String> strings, List<Set<Character>> list,int wordLength,String word) {

		if(l==wordLength){
			//System.out.println(" l became to wordlength so returning : "+word);
			if(strings.contains(word)){
				return "-";
			}
			return word;
		}


		Character[] arr	              = list.get(wordLength).toArray(new Character[0]);


		String tmp = "-";

		for(int i=0; i < arr.length; i++ ){
			tmp = getNewWord(l, strings, list, wordLength+1, word+arr[i]);
			if(!tmp.equals("-")){
				break;
			}
		}

		return tmp;

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