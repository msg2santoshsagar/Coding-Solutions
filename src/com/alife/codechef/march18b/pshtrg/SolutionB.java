package com.alife.codechef.march18b.pshtrg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SolutionB {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/pshtrg/input.txt";

	public static void main(String[] args) throws IOException{

		String homePc = System.getenv("HOME_PC");

		Reader reader = null;

		if(homePc == null){
			reader = new Reader();
		}else{
			reader = new Reader(INPUT_FILE_PATH);
		}

		SolutionB solution = new SolutionB();
		solution.solve(reader);
	}

	private void solve(Reader scanner) throws IOException{

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		long[]    	array	  	= new long[n];

		for(int i=0;i<n;i++){
			array[i]	= scanner.nextLong();
		}

		while( q -- > 0 ){

			int choice = scanner.nextInt();
			int pos    = scanner.nextInt();
			int value  = scanner.nextInt();

			if(choice == 1){
				array[pos-1]  = value;
			}else{

				int l 		= 	pos;
				int r 		=	value;

				int len     = r-l+1;

				long maxPerimeter = 0;

				long[]  cArr = new long[len];
				cArr[0]      = array[l-1];

				for (int i=1; i<len; ++i)
				{
					long key = array[l+i-1];
					int j = i-1;

					/* Move elements of arr[0..i-1], that are
		               greater than key, to one position ahead
		               of their current position */
					while (j>=0 && cArr[j] > key)
					{
						cArr[j+1] = cArr[j];
						j = j-1;
					}
					cArr[j+1] = key;

				}
			
				for(int i =len-1; i >= 2 ; i-- ){

					if( cArr[i-1] + cArr[i-2] > cArr[i]  ){
						maxPerimeter = cArr[i]+cArr[i-1]+cArr[i-2];
						break;
					}
				}

				System.out.println(maxPerimeter);

			}


		} // while method


	}// solve method

	public static class FastScanner {

		BufferedReader 		br;
		StringTokenizer 	st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException	 e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		String nextLine(){
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}


	static class Reader
    {
        private final  int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
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
