package com.alife.google.codejam;

import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		solve();
	}


	private static void solve() {

		Scanner scanner = new Scanner(System.in);

		int tc = Integer.parseInt(scanner.nextLine());

		while(tc -- > 0){

			String[] data =  scanner.nextLine().split(" "); 

			int a = 0;
			try{
				a=Integer.parseInt(data[0])+1;
			}catch (NumberFormatException e) {
				break;
			}
			int b = Integer.parseInt(data[1]);

			int n = Integer.parseInt(scanner.nextLine());

			boolean wa = false;

			while( n > 0 ){

				int mid = a + ( (b-a) / 2 );

				System.out.println(mid);
				System.out.flush();

				String result = scanner.nextLine();

				if(result.equals("WRONG_ANSWER")){
					wa = true;
					break;
				}else if(result.equals("CORRECT")){
					break;
				}else if(result.equals("TOO_SMALL")){
					a = mid+1;
				}else if(result.equals("TOO_BIG")){
					b = mid-1;
				}

				n--;

			}

			if(wa){
				break;
			}

		}


		scanner.close();

	}


}
