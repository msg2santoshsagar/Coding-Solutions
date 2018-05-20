package com.alife.codechef.may18b.chsign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

	static int[] arr = new int[]{6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6};
	//static int[] arr = new int[]{6, 4, 6, 5, 6, 4, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6, 4, 6, 5, 6};



	static List<Integer> possibleIndexList = new ArrayList<>();

	static int listSize = 0;

	public static void main(String args[]){

		possibleIndexList.addAll( Arrays.asList( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33 ));
		//possibleIndexList.addAll( Arrays.asList( 1, 3, 5));

		listSize = possibleIndexList.size();

		System.out.print("\nINPUT ARRAY         : [");
		for(int i=0;i<listSize;i++){
			System.out.print(arr[possibleIndexList.get(i)]+", ");
			if (possibleIndexList.get(i)>=10) {
				System.out.print(" ");
			}
		}
		System.out.println("]\nPossible Index List : "+possibleIndexList);
		System.out.println("\n\n");

		 findMaxSumList();

		//System.out.println("\nRES : "+result);

		System.out.println("Removed List : "+removedList);

		long sum = 0;

		for(Integer str: removedList){
			sum += arr[str];
		}

		System.out.println("STR SUM : "+sum);




	}


	static class CustomList{

		public static List<Integer> add(List<Integer> prev, int num){
			List<Integer> cur = new ArrayList<>(prev);
			cur.add(num);
			return cur;
		}

	}

	static List<Integer> removedList = new ArrayList<>();

	static void findMaxSumList(){

		List<Integer> inclList = new ArrayList<>();
		List<Integer> exclList = new ArrayList<>();


		List<Integer> exclListNew;

		long incl = arr[possibleIndexList.get(0)];
		inclList.add(possibleIndexList.get(0));

		long excl = 0;
		long excl_new;
		int i;

		for (i = 1; i < listSize; i++){

			/* current max excluding i */
			excl_new    = (incl > excl)? incl: excl;
			exclListNew = (incl > excl)? inclList: new ArrayList<>(exclList);


			/* current max including i */
			incl = excl + arr[possibleIndexList.get(i)];
			exclList.add(possibleIndexList.get(i));
			inclList = exclList;

			excl = excl_new;
			exclList = exclListNew;

			if(!inclList.isEmpty() && !exclList.isEmpty() && inclList.get(0) == exclList.get(0)){
				removedList.add(inclList.get(0));
				inclList.remove(0);
				exclList.remove(0);
			}
			//[1, 5, 9, 13, 17, 21, 25, 29, 33]

			if(i==listSize-1){
				List<Integer> biglist = (incl > excl)? inclList	 : exclList;
				for(int k=0 ;k<biglist.size();k++){
					removedList.add(biglist.get(k));
				}
			}

		}

		/* return max of incl and excl */
		//return ((incl > excl)? inclList	 : exclList);
	}

}
