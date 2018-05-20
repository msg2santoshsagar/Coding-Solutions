package com.alife.codechef.may18b.chsign;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Main {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/may18b/chsign/input.txt";

	public static void main(String[] args) throws IOException{

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Main solution = new Main();
		solution.solve(scanner);

	}

	int[] arr;
	List<Integer> possibleIndexList;
	int listSize;


	private void solve(FastScanner sc) throws IOException {

		int tc = sc.nextInt();

		while(tc-->0){


			int N 		 = 	sc.nextInt();
			arr	 		 = 	new int[N];

			for(int i=0; i<N;i++){
				arr[i] = sc.nextInt();
			}

			List<Integer> localPossibleIndexList = new ArrayList<>();

			for(int i=0; i<N;i++){
				if(i==0){
					if(arr[i]<arr[i+1]){
						localPossibleIndexList.add(i);
						i++;
					}
				}else if(i<N-1){
					if(arr[i]<arr[i+1] && arr[i]<arr[i-1] ){
						localPossibleIndexList.add(i);
						i++;
					}
				}else{
					if( arr[i]<arr[i-1] ){
						localPossibleIndexList.add(i);
						i++;
					}
				}
			}


			if(localPossibleIndexList.isEmpty()){
				for(int i=0; i<N; i++){
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				continue;
			}

			List<List<Integer>> list = new ArrayList<>();

			int k =0;

			for(int i=0; i<localPossibleIndexList.size();i++){

				if(list.size()<=k){
					list.add(new ArrayList<>());
				}

				if(list.get(k).isEmpty()){
					list.get(k).add(localPossibleIndexList.get(i));
				}else{

					int current = localPossibleIndexList.get(i);
					int prev    = list.get(k).get(list.get(k).size()-1);

					if(current-prev != 2 || ( -1*arr[prev] + arr[prev+1] + -1*arr[prev+2] ) > 0   ){
						k++;
						if(list.size()<=k){
							list.add(new ArrayList<>());
						}
					}

					list.get(k).add(current);

				}

			}

			for(int i=0; i<list.size();i++){

				possibleIndexList = list.get(i);

				if(possibleIndexList.size() == 1){
					arr[possibleIndexList.get(0)] *= -1;
					continue;
				}

				listSize  = possibleIndexList.size();

				findMaxSumList();

			}



			for(int i=0; i<N; i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();


		}

	}

	static class CustomList{

		public static List<Integer> add(List<Integer> prev, int num){
			List<Integer> cur = new ArrayList<>(prev);
			cur.add(num);
			return cur;
		}

	}

	void findMaxSumList(){

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
				arr[inclList.get(0)] *= -1;
				inclList.remove(0);
				exclList.remove(0);
			}
			//[1, 5, 9, 13, 17, 21, 25, 29, 33]

			if(i==listSize-1){
				List<Integer> biglist = (incl > excl)? inclList	 : exclList;
				for(int k=0 ;k<biglist.size();k++){
					if(arr[biglist.get(k)]>0){
						arr[biglist.get(k)] *= -1;
					}
				}
			}

		}

		/* return max of incl and excl */
		//return ((incl > excl)? inclList	 : exclList);
	}


	public static class FastScanner{

		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastScanner(){
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastScanner(String file_name) throws IOException{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}


}   