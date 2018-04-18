package com.alife.codechef.cutplant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Santosh Sagar
 * working but tle
 *
 */
public class Main2 {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/cutplant/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Main2 solution = new Main2();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) {

		int tc = scanner.nextInt();

		while(tc-->0){

			int N 					= scanner.nextInt();

			int[] existingHeight 	= new int[N];
			int[] requiredHeight 	= new int[N];

			for(int i=0;i<N;i++){
				existingHeight[i] = scanner.nextInt();
			}

			boolean isImpossible = false;
			boolean alreadyEqual = true;

			for(int i=0;i<N;i++){

				requiredHeight[i] = scanner.nextInt();

				if(existingHeight[i] < requiredHeight[i]){
					isImpossible = true;
				}

				if(existingHeight[i] != requiredHeight[i]){
					alreadyEqual = false;
				}
			}

			if(alreadyEqual){
				System.out.println(0);
			}else if(isImpossible){
				System.out.println(-1);
			}else{

				long     minOperation = 0;


				int  index = 0;
				int  minHeight = 0;

				int currentIndex = 0;

				while(currentIndex < N){

					while(currentIndex < N && existingHeight[currentIndex] == requiredHeight[currentIndex]){
						currentIndex++;
					}

					//System.out.println("Array : "+Arrays.toString(existingHeight));
					//System.out.println("Array : "+Arrays.toString(requiredHeight));

					minHeight = requiredHeight[currentIndex];

					index = currentIndex;
					while( index < N &&  minHeight <= existingHeight[index] && minHeight >= requiredHeight[index] ){
						minHeight = Math.max(minHeight, requiredHeight[index]);
						index++;
					}

					//System.out.println("Min height decided : "+minHeight);

					//System.out.println("INDEX : "+currentIndex+" , "+index);

					boolean cutdone   = false;
					boolean diffFound = false;

					for(int j=currentIndex;j<index;j++){
						existingHeight[j] = minHeight;
						cutdone = true;

						if(existingHeight[j] == requiredHeight[j] && !diffFound ) {
							currentIndex++;
						}else{
							diffFound = true;
						}


					}

					if(cutdone){
						minOperation++;
					}

				}

				//System.out.println("BOTH MATCHED : "+Arrays.toString(existingHeight).equals(Arrays.toString(requiredHeight)));

				System.out.println(minOperation);


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
