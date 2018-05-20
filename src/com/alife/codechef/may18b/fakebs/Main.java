package com.alife.codechef.may18b.fakebs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/may18b/fakebs/input.txt";

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

		while(tc-->0){

			int numberOfElements  	 = 	sc.nextInt();
			int numberOfStudents	 = 	sc.nextInt();


			int[]  studentCode		         =  new int[numberOfElements+1];
			int[]  studentCodeSorted		 =  new int[numberOfElements+1];

			Map<Integer, Integer> map = new HashMap<>();

			for( int i=1; i <= numberOfElements ; i++ ){
				studentCode[i]  = sc.nextInt();
				studentCodeSorted[i] = studentCode[i];
				map.put(studentCode[i], i);
			}

			Arrays.sort(studentCodeSorted);

			//System.out.println("Input Array : "+Arrays.toString(Arrays.	copyOfRange(studentCode,1,numberOfElements+1)));

			for(int i=0; i<numberOfStudents; i++){

				int marks = sc.nextInt();

				//System.out.println("\n========================= Calculating for "+marks+", Actual Index : "+map.get(marks));

				System.out.println(fakeBinarySearch(studentCode,numberOfElements,marks,map.get(marks),studentCodeSorted));

			}


		}

	}

	private int fakeBinarySearch(int[] array, int n, int x,int actualIndex, int[] studentCodeSorted){


		List<Integer> path  = new ArrayList<>();
		List<Integer> left  = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		int low=1;
		int high=n;
		int leftSideBig    = 0;
		int rightSideSmall = 0;


		while(low<=high){

			int mid = (low+high)/2;

			if(mid == actualIndex){
				path.add(x);
				break;
			}else if( mid < actualIndex ){

				low  = mid+1;

				if(array[mid] > x){
					leftSideBig++;
					left.add(array[mid]);
				}else{
					path.add(array[mid]);
				}

			}else{
				
				high = mid-1;
				
				if(array[mid] < x){
					right.add(array[mid]);
					rightSideSmall++;
				}else{
					path.add(array[mid]);
				}
				
			}

		}
		
		//System.out.println("Before Path : "+path);

		/*// Change this step
		left.retainAll(right);*/
		
		//System.out.println("Left  : "+left);
		//System.out.println("Right : "+right);
		
		for(int i=0; i<Math.min(leftSideBig, rightSideSmall);i++){
			path.add(left.get(i));
			path.add(right.get(i));
		}
		
		//path.addAll(left);

		//System.out.println("Path : "+path);

		int swaps = 0;

		//System.out.println("Left  Side Big 	 : "+leftSideBig);
		//System.out.println("Right Side Small : "+rightSideSmall);

		swaps = Math.min(leftSideBig,rightSideSmall);

		leftSideBig    -= swaps;
		rightSideSmall -= swaps;

		boolean ip = true;

		if(leftSideBig > 0){
			int found = 0;
			for(int i=1; i<=n ; i++){
				if(studentCodeSorted[i] >= x){
					break;
				}
				if(!path.contains(studentCodeSorted[i])){
					found++;
				}
				if(found == leftSideBig){
					swaps += leftSideBig;
					break;
				}
			}

			ip = ip & (leftSideBig == found);
		}

		if( ip && rightSideSmall > 0){
			int found = 0;
			for(int i=n; i>=1 ; i--){
				if(studentCodeSorted[i] <= x){
					break;
				}
				if(!path.contains(studentCodeSorted[i])){
					found++;
				}
				if(found == rightSideSmall){
					swaps += rightSideSmall;
					break;
				}
			}

			ip = ip & (rightSideSmall == found);
		}

		return ip ? swaps : -1;
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