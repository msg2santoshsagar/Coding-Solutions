package com.alife.google.codejam.round1c.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Santosh Sagar
 *
 */
public class Solution {


	public static void main(String [] args){


		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t-->0){


			int numberOfLollipos = sc.nextInt();

			int[] freq           = new int[numberOfLollipos];

			List<Integer>  list = new ArrayList<>();

			for(int i=0 ; i < numberOfLollipos; i++ ){

				int d = sc.nextInt();

				//				int[] arr = new int[d];

				int lid  = -1;
				int cnt  = numberOfLollipos+1; 

				for(int j=0; j<d; j++){
					int temp = sc.nextInt();
					freq[temp]++;
					if(! list.contains(temp)  && freq[temp] <= cnt ){
						lid = temp;
						cnt = freq[temp];
					}
				}

				if(lid!=-1){
					list.add(lid);
				}
				
				System.out.println(lid);

			}




		}

		sc.close();

	}


}