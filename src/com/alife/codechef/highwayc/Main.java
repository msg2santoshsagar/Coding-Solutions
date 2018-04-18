package com.alife.codechef.highwayc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/APRIL18B/problems/HIGHWAYC
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/highwayc/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner 	= null;

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
		
		final double diff = Math.pow(10, -6);

		while(tc-->0){

			int 	numberOfLanes 		= scanner.nextInt();
			int 	chefWalkingSpeed	= scanner.nextInt();
			int 	laneWidth			= scanner.nextInt();

			int[]   	carVelocity			= new int[numberOfLanes];
			int[]   	direction			= new int[numberOfLanes];
			double[]    position			= new double[numberOfLanes];
			double[]   	carLength			= new double[numberOfLanes];

			double  laneCrossTime		= laneWidth / (double) chefWalkingSpeed;


			double  time				= 0;

			//Car Velocity input
			for(int laneNo = 0; laneNo < numberOfLanes ; laneNo++ ){
				carVelocity[laneNo] = scanner.nextInt();
			}

			//Car direction input
			for(int laneNo = 0; laneNo < numberOfLanes ; laneNo++ ){
				direction[laneNo] = scanner.nextInt();
			}

			//Car position input
			for(int laneNo = 0; laneNo < numberOfLanes ; laneNo++ ){
				position[laneNo] = scanner.nextInt();
			}

			//Car length input
			for(int laneNo = 0; laneNo < numberOfLanes ; laneNo++ ){
				carLength[laneNo] = scanner.nextInt();
				position[laneNo] -= carLength[laneNo] * ( direction[laneNo] == 0 ? -1 : 1  );
			}

			//Processing each cars
			for(int laneNo = 0; laneNo < numberOfLanes ; laneNo++ ){
				
				int multiplier = ( direction[laneNo] == 0 ? 1 : -1  );


				double carStartingPosition  = position[laneNo] - ( time * carVelocity[laneNo] *  multiplier); 
				
				double carEndPosition       = position[laneNo] - ( (time+laneCrossTime) * carVelocity[laneNo] * multiplier ) - (carLength[laneNo] * multiplier); 
				
				if( (0>= carStartingPosition && 0<= carEndPosition) || (0>= carEndPosition && 0<= carStartingPosition) ){
					
					time +=  ( Math.abs(carStartingPosition) / carVelocity[laneNo] ) + laneCrossTime + (diff/carVelocity[laneNo]);

				}else{
					time = time + laneCrossTime;
				}

			}

			System.out.printf("%.6f\n",time);

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