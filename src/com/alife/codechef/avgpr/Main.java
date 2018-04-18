package com.alife.codechef.avgpr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/APRIL18B/problems/AVGPR/
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/avgpr/input.txt";

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

		while(tc-->0){

			int N = scanner.nextInt();

			Map<Integer,Integer> map =new HashMap<>();

			long pair =  0;


			for(int i=0;i<N;i++){
				int num = scanner.nextInt();
				map.putIfAbsent(num,0);
				map.put(num,map.get(num)+1);
			}

			Set<Integer> keySet = map.keySet();

			int[] array = keySet.stream().mapToInt(i->i).toArray();


			for(int i=0; i<array.length;i++){

				for(int j=i;j<array.length;j++){

					long localPair = 0;

					if(array[i]==array[j]){
						localPair = map.get(array[i]);
						localPair = localPair * (localPair -1);
						localPair = localPair /2;
					}else{

						if( (array[i] + array[j]) % 2 == 0  ){

							int numby2 = (array[i]+array[j]) / 2;

							if( map.get(numby2) != null &&  map.get(numby2) > 0 ){
								localPair = map.get(array[i]) * map.get(array[j]);
							}

						}

					}

					pair += localPair;

				}

			}


			System.out.println(pair);

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