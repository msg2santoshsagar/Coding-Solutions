package com.alife.google.codejam.go_gopher;

import java.io.IOException;
import java.util.Scanner;


public class Solution {


	public static void main(String[] args) throws IOException{

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			int a = input.nextInt();
			solve(input,a);
		}
		input.close();
	}

	private static void solve(Scanner input, int requiredGrid) {

		boolean matrix[][] = new boolean[1001][1001];

		int xlower, xupper, ylower, yupper;
		
		if(requiredGrid == 10){
			
			xlower = 5;
			xupper = 7;
			ylower = 5;
			yupper = 8;
			
		}else if(requiredGrid == 20){
			
			xlower = 5;
			xupper = 8;
			ylower = 5;
			yupper = 9;
			
		}else if(requiredGrid == 200){
			
			xlower = 5;
			xupper = 14;
			ylower = 5;
			yupper = 24;
			
		}else{
			return;
		}
		
		int px=1,py=1;
		
		while(px!=0 && py!= 0){
			
			for(int i = xlower; i<=xupper; i++){
				for(int j=ylower; j<= yupper; j++){
					
					if(!matrix[i][j]){
						
						int tempx = Math.max(i, xlower+1);
						tempx = Math.min(tempx, xupper-1);
						
						int tempy = Math.max(j, ylower+1);
						tempy = Math.min(tempy, yupper-1);
						
						System.out.println(tempx+" "+tempy);
						px = input.nextInt();
						py = input.nextInt();
						
						matrix[px][py] = true;
						
						
					}
					
				}
			}
			
		}

	}




}
