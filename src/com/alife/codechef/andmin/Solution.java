package com.alife.codechef.andmin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/problems/ANDMIN
 * @notSolvedYet
 *
 */
public class Solution {

	class SegmentTree{

		int[]  st;

		public SegmentTree(int[] array, int n) {
			st = new int[2*n-1];
			constructTree(array,0,1,n);
		}

		private int constructTree(int[] array, int position, int start, int end) {
			
			if(start == end){
				st[position] = array[start];
				return st[position];
			}
			
			int mid = getMid(start,end);
			
			int subResult1 = constructTree(array, position*2+1, start, mid);
			int subResult2 = constructTree(array, position*2+2, mid+1, end);
			
			int min = Math.min(subResult1, subResult2);
			
			st[position] = min;
			
			return min;
			
		}
		
		
		public int findMin(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int index ){
			
			
			if( queryStart <= segmentStart && queryEnd >= segmentEnd){
				return st[index];
			}
			
			if(  segmentEnd < queryStart || segmentStart > queryEnd  ){
				return Integer.MAX_VALUE;
			}
			
			int mid = getMid(segmentStart, segmentEnd);
			
			return Math.min( findMin(segmentStart, mid, queryStart, queryEnd, 2*index+1) , 
					findMin(mid+1, segmentEnd, queryStart, queryEnd, 2*index+2) );
			
		}

		private int getMid(int start, int end) {
			return start + ( (end-start) / 2 ) ;
		}
		
		public void printTree(){
			for(int i=0;i<st.length;i++){
				System.out.println("Index : "+(i+1)+", Value : "+st[i]);
			}
		}

	}

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/andmin/input.txt";

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

	private void solve(FastScanner scanner) {

		int N = scanner.nextInt();
		int Q = scanner.nextInt();

		int[] array = new int[N+1];

		for(int i=1;i<=N;i++){
			array[i] = scanner.nextInt();
		}

		SegmentTree segmentTree = new SegmentTree(array,N);

		/*System.out.println("Segment Tree created");
		segmentTree.printTree();
		System.out.println("\n\n");
		System.out.println("Input Array :: "+Arrays.toString(array));
		System.out.println("\n\n\n");*/
		
		for(int i=0;i<Q;i++){
			
			int operation = scanner.nextInt();
			int left      = scanner.nextInt()-1;
			int right     = scanner.nextInt()-1;
			
			//System.out.print("Left : "+left+", Right : "+right+", RESULT :  ");
			
			if(operation == 0){
				
				System.out.println(segmentTree.findMin(0, N-1, left, right, 0));
				
			}else{
				int x = scanner.nextInt();
				//System.out.println("Update tree");
				while(left<=right){
					array[left] = array[left] & x;
					left++;
				}
				//System.out.println("UPDATED Input Array :: "+Arrays.toString(array));
				segmentTree = new SegmentTree(array, N);
				//segmentTree.printTree();
				
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
