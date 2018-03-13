package com.hackerearth.ninjakart;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution2 {

	private static final String 	INPUT_FILE_PATH = "src/com/hackerearth/ninjakart/input2.txt";

	public static void main(String[] args) throws Exception{

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}


		int tc = scanner.nextInt();

		while( tc --> 0){

			int n = scanner.nextInt();

			int[] employeesWaiting = new int[n];

			int maxAllowedPersion = scanner.nextInt();
			int maxAllowedWeight  = scanner.nextInt();

			for(int i=1; i< n ; i++){
				employeesWaiting[i] = scanner.nextInt();
			}

			int weightM[] 	= new int[n+1];
			int personM[]	= new int[n+1];

			int floor=1;
			int currentWeight 	=	0;
			int currentPerson 	= 	0;

			for( ; floor < n; floor++){

				currentWeight = currentWeight - weightM[floor];
				currentPerson = currentPerson - personM[floor];

				int exitFloor[] = new int[employeesWaiting[floor]+1];
				int weight 	 [] = new int[employeesWaiting[floor]+1];

				for(int i=0;i<employeesWaiting[floor];i++){
					exitFloor[i] = scanner.nextInt();
				}

				for(int i=0;i<employeesWaiting[floor];i++){
					weight[i] = scanner.nextInt();
				}

				for(int i=0; i<employeesWaiting[floor]; i++){

					currentPerson ++;

					currentWeight = currentWeight + weight[i];
					weightM[exitFloor[i]] += weight[i];
					personM[exitFloor[i]]++;


				}

				if( currentPerson > maxAllowedPersion || currentWeight > maxAllowedWeight ){
					break;
				}

			}

			System.out.println(floor);

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