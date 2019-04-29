//https://www.codechef.com/APRIL19B/problems/STRCH
package com.alife.codechef.april19b.strch;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    public static void main(String[] args) throws java.lang.Exception {

        FastScanner sc = new FastScanner();

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            String str = sc.nextToken();
            String x = sc.nextToken();

            BigInteger count = cal(n);

            //System.out.println("COUNT INIT :: " + count);

            int prevIndex = -1;

            int index = str.indexOf(x);
            while (index >= 0) {

                long tmp = index - prevIndex - 1;

                count = count.subtract(cal(tmp));

                prevIndex = index;
                index = str.indexOf(x, index + 1);
            }

            long tmp = n - prevIndex - 1;

            count = count.subtract(cal(tmp));

            System.out.println(count);


        }


    }

    private static BigInteger cal(long n) {
        BigInteger result = BigInteger.valueOf(n);
        result = result.multiply(result.add(BigInteger.ONE));
        result = result.divide(BigInteger.valueOf(2));
        return result;
    }

    private static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void skipLine() {
            st = null;
        }
    }
}
