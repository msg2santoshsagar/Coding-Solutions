package com.alife.tcs.hackathon.feb.zombie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws FileNotFoundException{

		Scanner scanner = new Scanner(new File("src/com/alife/tcs/hackathon/feb/zombie/input.txt"));

		int size 		=	 Integer.parseInt(scanner.nextLine());

		String zombies [] = new String[size];

		for(int i=0; i< size ; i++ ){
			zombies [i] = scanner.nextLine();
		}

		System.out.println(zombieCluster(zombies));
		scanner.close();

	}


	static int zombieCluster(String []  zombies){

		int size = zombies[0].length();

		int mat [][] = new int[size][size];

		for(int i = 0; i< size; i++){
			for(int j=0; j< size ; j++ ){
				mat[i][j] = Integer.parseInt(String.valueOf(zombies[i].charAt(j)));
			}
		}

		for(int i = 0; i< size; i++){
			for(int j=0; j< size ; j++ ){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

		boolean visited   []  = new boolean [size];
		boolean visiting  []  = new boolean [size];

		int clusterCount 	= 0;

		for (int i = 0; i < size ; ++i) {

			if(!visited[i]){
				visiting[i] = true;

				visit(mat	, size, visited,visiting, i);

				visited[i] = true;

				System.out.println("Visited value -- ");

				for(int k =0; k< size ; k++){
					System.out.print(visited[k]+"  ");
					
				}
				clusterCount++;
			}
		}


		return clusterCount;
	}


	static void visit(int mat[][], int size, boolean visited[], boolean[] visiting, int index)
	{
		System.out.println("\nVisiting "+(index));
		if( !visited[index] ) {
			visiting[index] = true;
			for(int j = 0; j < size; j++) {
				if( index == j ){
					continue;
				}
				if(mat[index][j] == 1 && !visiting[j]) {
					visiting[j] = true;
					visit(mat, size, visited, visiting, j);
					visited[j] = true;
				}
			}
		}
	}



}
