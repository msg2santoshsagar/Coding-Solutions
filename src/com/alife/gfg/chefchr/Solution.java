package com.alife.gfg.chefchr;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santosh Sagar
 * https://www.codechef.com/FEB18/problems/CHEFCHR/
 *
 */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		List<String> chefWordLists = new ArrayList<>();
		chefWordLists.add("chef");
		chefWordLists.add("cfeh");
		chefWordLists.add("ehcf");
		chefWordLists.add("efch");
		chefWordLists.add("chfe");
		chefWordLists.add("cefh");
		chefWordLists.add("hcfe");
		chefWordLists.add("hefc");
		chefWordLists.add("fhce");
		chefWordLists.add("fech");
		chefWordLists.add("hcef");
		chefWordLists.add("hfec");
		chefWordLists.add("cehf");
		chefWordLists.add("cfhe");
		chefWordLists.add("ecfh");
		chefWordLists.add("ehfc");
		chefWordLists.add("fceh");
		chefWordLists.add("fhec");
		chefWordLists.add("hecf");
		chefWordLists.add("hfce");
		chefWordLists.add("echf");
		chefWordLists.add("efhc");
		chefWordLists.add("fche");
		chefWordLists.add("fehc");

		for(;tc > 0; tc--) {

			String str = br.readLine();

			int matchCount = 0;

			for(int i=0 ; i<=str.length() -4; i++){
				if(chefWordLists.contains(str.substring(i, i+4))){
					matchCount++;
				}
			}

			System.out.println(matchCount == 0 ? "normal" : "lovely "+matchCount);

		}

		
	}


}