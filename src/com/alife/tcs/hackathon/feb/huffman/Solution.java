package com.alife.tcs.hackathon.feb.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws FileNotFoundException{

		Scanner scanner = new Scanner(new File("src/com/alife/tcs/hackathon/feb/huffman/input.txt"));

		int n = Integer.parseInt(scanner.nextLine());

		String str [] = new String[n];
		for(int i =0; i< str.length ; i++ ){
			str[i] = scanner.nextLine();
		}

		String encodedString = scanner.nextLine();

		System.out.println(decode(str, encodedString));

		scanner.close();


	}


	static class Node{
		String  value;
		boolean leafNode; 
		Node left;
		Node right;
	
		@Override
		public String toString() {
			return "Node [value=" + value + ", leafNode=" + leafNode + ", left=" + left + ", right=" + right + "]";
		}
		
	
	}

	public static String decode(String[] codes, String encoded) {

		StringBuilder sb = new StringBuilder();

		Node rootNode = new Node();

		for(int i= 0; i < codes.length; i++ ){

			String data [] = codes[i].split("	");

			String key 		= data[0].equals("[newline]") ? "\n" : data[0];
			String value  	= data[1];

			//System.out.println("===========================================================================");
			//System.out.println(rootNode.hashCode());
			Node node = rootNode;

			for(char c : value.toCharArray()){
				if(c == '0' ){
					if(node.left == null){
						node.left = new Node();
					}
					node = node.left;
				}else{
					if(node.right == null){
						node.right = new Node();
					}
					node =node.right;
				}
			}

			node.value = key;
			node.leafNode = true;
			//System.out.println("Node hash code -- "+node.hashCode());
			//System.out.println("===========================================================================");

		}
		
		//System.out.println("\n\n==================================== PRINTING NODES");
		//printNode(rootNode);
		//System.out.println("Printing node done");
		
		
		Node node = rootNode;
		
		for(char c : encoded.toCharArray()){
			if(c == '0' ){
				node = node.left;
			}else{
				node =node.right;
			}
			if(node.leafNode){
				sb.append(node.value);
				node = rootNode;
			}
		}

		return sb.toString();

	}

	

}
