package com.alife.gfg.chefptnt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * https://www.codechef.com/FEB18/problems/CHEFPTNT
 * @author Santosh Sagar
 *
 */

public class Solution {

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for(; tc > 0; tc -- ) {

			String data[]  = br.readLine().split(" ");

			int patientToBeFiled	= Integer.parseInt(data[0]);
			int monthCount	 		= Integer.parseInt(data[1]);
			int maxWorkerToWork		= Integer.parseInt(data[2]);
			int availableWorker     = Integer.parseInt(data[3]);

			int workerCountEvenMonth = 0;
			int workerCountOddMonth = 0;
			String workerDayStr = br.readLine();

			//System.out.println("WORKER DAY STR :: "+workerDayStr);

			if(workerDayStr != null ) {
				for(Character c : workerDayStr.toCharArray()) {
					if( c == 'E'  ) {
						workerCountEvenMonth++;
					}else {
						workerCountOddMonth++;
					}
				}
			}

			
			for(int m = 1; m <= monthCount; m++) {

				if(m % 2 == 0 && workerCountEvenMonth > 0) {
					// Even month
					int workerCount  = Math.min(workerCountEvenMonth, maxWorkerToWork);
					patientToBeFiled = patientToBeFiled - workerCount;
					workerCountEvenMonth = workerCountEvenMonth - workerCount;
				} 
				if(m % 2 == 1 && workerCountOddMonth > 0) {
					// Odd Month
					int workerCount = Math.min(workerCountOddMonth, maxWorkerToWork);
					patientToBeFiled = patientToBeFiled - workerCount;
					workerCountOddMonth = workerCountOddMonth - workerCount;
				}

				if(patientToBeFiled <= 0) {
					break;
				}
			}


			System.out.println(patientToBeFiled <= 0 ? "yes" : "no");


		}


	}

}

