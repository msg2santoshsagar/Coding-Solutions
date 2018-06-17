package com.alife.codechef.ltime60b.sbstr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/ltime60b/sbstr/input.txt";

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

		while(tc-- > 0){

			String str = sc.nextToken();

			int    k   = sc.nextInt();

			int len	   = str.length();

			/*System.out.println("============================");
			System.out.println("Input : "+str+":, K : "+k+"\n");*/



			int interesting = 0;

			if(k>len){
				System.out.println(interesting);
				continue;
			}

			/*for(int i=k; i<=len;i++){
				for(int j=0;j<=len-i;j++){
					//System.out.println(str.substring(j, j+i));
					if(isInteresting(str.substring(j, j+i), k)){
						//System.out.println("Valid : "+str.substring(j, j+i));
						interesting++;
					}
				}

			}

			System.out.println(interesting);

			interesting = 0;
*/

		//	System.out.println("\n\n SECOND : \n ");

			for(int i=0;i<=len-k;i++){
				interesting += getInterestingStringCount(str,len,i,k);
			}

			System.out.println(interesting);


		}


	}


	private int getInterestingStringCount(String str,int len, int i, int k) {

		//System.out.println("GET I for : "+i);
		
		//int temp = i;

		int[] arr = new int[26];

		int interestingCount = 0;

		int uniqueCount = 0;

		for(; i< len; i++){

			if( arr[str.charAt(i)-'a'] == 0 ){
				uniqueCount++;
			}

			arr[str.charAt(i)-'a']++;
			
			if(uniqueCount>=k){

				int prev = -1;

				boolean ip =true;
				
				

				for(int j=0; j<26; j++){
					if(arr[j]>0){
						if(prev==-1){
							prev = arr[j];
						}else{
							if(prev!= arr[j]){
								ip = false;
								break;
							}
						}

					}
				}

				if(ip){
					//System.out.println("Valid : "+str.substring(temp,i+1));
					interestingCount++;
				}

			}

		}




		return interestingCount;
	}

	boolean isInteresting(String str,int k){

		int[] arr = new int[26];

		for(char c: str.toCharArray()){
			arr[c-'a']++;
		}

		int cnt = 0;

		int prev = -1;

		for(int i=0; i<26; i++){
			if(arr[i]>0){

				cnt++;

				if(prev==-1){
					prev = arr[i];
				}else{
					if(prev!= arr[i]){
						return false;
					}
				}

			}
		}

		return cnt>=k;
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