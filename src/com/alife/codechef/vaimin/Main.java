package com.alife.codechef.vaimin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * Working but TLE
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/vaimin/input.txt";

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

	private static class Minister{

		int goodDeeds;
		int badDeeds;

		public Minister(int goodDeeds, int badDeeds) {
			super();
			this.goodDeeds = goodDeeds;
			this.badDeeds = badDeeds;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + badDeeds;
			result = prime * result + goodDeeds;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Minister other = (Minister) obj;
			if (badDeeds != other.badDeeds)
				return false;
			if (goodDeeds != other.goodDeeds)
				return false;
			return true;
		}



	}

	final int mod = 1_000_000_007;

	Map<Minister, Long> map = new HashMap<>();

	private void solve(FastScanner scanner) {

		int goodDeeds 				= scanner.nextInt();
		int badDeeds  				= scanner.nextInt();

		int repetuationThreshold 	= scanner.nextInt();
		int ministerArrested		= scanner.nextInt();

		for(int i=0; i < ministerArrested; i++){
			map.put(new Minister(scanner.nextInt(),scanner.nextInt()),0L);
		}

		long noOfWays = getNoOfWays(goodDeeds,badDeeds,0,0,repetuationThreshold,"");

		System.out.println(noOfWays);


	}

	private long getNoOfWays(int availableGoodDeeds, int availableBadDeeds,int currentGoodDids, int currentBadDids,
			int repetuationThreshold, String str) {

		Minister minister = new Minister(currentGoodDids, currentBadDids);
		if(map.containsKey(minister)){
			return map.get(minister);
		}
		//System.out.println("ENTRY GET NO OF WAYS : "+availableGoodDeeds+", "+availableBadDeeds+", "+currentGoodDids+", "+currentBadDids+", "+repetuationThreshold);

		if(availableGoodDeeds == 0 && availableBadDeeds == 0){
			//map.put(minister, 1L);
			System.out.println("RETURN 1 : "+str.substring(0,3)+" "+str.substring(3));
			return 1;
		}

		long sum = 0;

		if( (currentGoodDids-currentBadDids) > repetuationThreshold ){
			if(availableGoodDeeds > 0){
				sum += getNoOfWays(availableGoodDeeds-1, availableBadDeeds, currentGoodDids+1, currentBadDids, repetuationThreshold,str+'G');
				sum %= mod;
			}
			if(availableBadDeeds > 0){
				sum += getNoOfWays(availableGoodDeeds, availableBadDeeds-1, currentGoodDids, currentBadDids+1, repetuationThreshold,str+'B');
				sum %= mod;
			}

		}else if(availableGoodDeeds > 0){
			if(availableGoodDeeds > 0){
				sum += getNoOfWays(availableGoodDeeds-1, availableBadDeeds, currentGoodDids+1, currentBadDids, repetuationThreshold,str+'G');
				sum %= mod;
			}
		}

		//map.put(minister, sum);
		//System.out.println("RETURNING SUM AS "+sum);
		return sum;
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