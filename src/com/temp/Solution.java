package com.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());


		while( tc -- > 0){

			String str [] = br.readLine().split(" ");

			long n = Long.parseLong(str[0]);
			long a = Long.parseLong(str[1]);
			long b = Long.parseLong(str[2]);
			long c = Long.parseLong(str[3]);

			long count = 0;

			List<Long> aList = new ArrayList<>();
			List<Long> bList = new ArrayList<>();
			List<Long> cList = new ArrayList<>();

			aList.add(1L);
			bList.add(1L);
			cList.add(1L);

			if( n <= a  ){
				aList.add(n);
			}
			if( n <= b  ){
				bList.add(n);
			}
			if( n <= c  ){
				cList.add(n);
			}

			for(long i=2; i<n/2; i++ ){

				if( n % i == 0 ){
					if( i <= a  ){
						aList.add(i);
					}
					if( i <= b  ){
						bList.add(i);
					}
					if( i <= c  ){
						cList.add(i);
					}
				}
			}
		
			for(Long x : aList){

				for( Long y : bList ){

					long xy = x* y;

					if( n % xy == 0 && cList.contains(n/xy) ){
						count++;
					}

				}


			}

			System.out.println(count);
		}


	}

}
