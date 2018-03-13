package com.alife.codechef.march18b.mineeat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SolutionC {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/mineeat/input.txt";

	private static final PrintStream out 			= new PrintStream(System.out);

	public static void main(String[] args){

		String homePc			 = System.getenv("HOME_PC");
		boolean isDebugEnabled 	 = false;

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner			 = new FastScanner(INPUT_FILE_PATH);
			isDebugEnabled   = true;
		}

		SolutionC solution = new SolutionC();
		solution.solve(scanner,isDebugEnabled);

	}

	private void solve(FastScanner scanner , boolean isDebugEnabled){

		int tc  = scanner.nextInt();
		int ctr = 0;

		while(ctr != tc){

			ctr++;

			if(isDebugEnabled){
				out.println("\n\n=================================="+ctr+"==========================================");
			}

			int n     = scanner.nextInt();
			int h     = scanner.nextInt();

			int[] arr 	 = new int[n];

			double sum   = 0;
			int    max   = 0;

			for(int i=0;i<n;i++){
				arr[i] = scanner.nextInt();
				sum += arr[i];
				if(arr[i] > max){
					max = arr[i];
				}
			}

			if( n == h){
				out.println(max);
			}else{

				int min = (int) Math.ceil( sum / h );


				boolean isResultFound = false;

				/*for( ; min <= max ; min++){

					if(isResultFound){
						break;
					}

					int hour 	= 0;
					int index 	= 0;

					int tmpData = arr[0];

					while( index != n && hour <= h ){

						int hoursRequired = (int) Math.ceil( (double) tmpData / min);

						hour += hoursRequired;

						if( index == n-1 ){
							isResultFound = true;
							break;
						}

						index++;
						tmpData = arr[index];
					}

				}*/

				if(isDebugEnabled){
					out.println("MIN : "+min+", MAX : "+max);
				}
				int mid = -1;
				Arrays.sort(arr);

				while(min<=max){

					mid = (min+max+1)/2;

					int hour = 0;
					for(int i=0;i<n;i++){
						hour += Math.ceil( (double) arr[i] / mid );
					}

					if(hour<=h){
						max = mid-1;
					}else{
						min = mid+1;
					}


				}
				
				for(int l = mid-1; l<=mid+1;l++){
					int hour = 0;
					for(int i=0;i<n;i++){
						hour += Math.ceil( (double) arr[i] / l );
					}

					if(hour<=h){
						out.println(l);
						break;
					}
				}

			}

		} // While loop

	}// solve method

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
