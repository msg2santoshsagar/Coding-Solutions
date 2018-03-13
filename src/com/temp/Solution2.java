package com.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		
		while( tc -- > 0){
			
			String[] str = br.readLine().split(" ");
			
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int b = Integer.parseInt(str[2]);
			
			String data[] = br.readLine().split(" ");
			
			List<Integer> dataList = Arrays.asList(data).stream().map(a -> Integer.parseInt(a)).sorted().collect(Collectors.toList());
			
			//dataList.stream().forEach(System.out::println);
			
			int max = 0;
			
			int prev = dataList.get(0);
			for(int i=0; i< dataList.size() - 1; i++){
				
				int x = dataList.get(i);
				
				if( k*prev+b < dataList.get(i+1) ){
					prev = x;
					max++;
				}
				
				
			}
			
			System.out.println(max+1);
			
			
		}
		

	}

}
