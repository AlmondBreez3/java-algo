package java_algo.study.dp;

import java.util.*;
import java.lang.*;
import java.io.*;

    // The main method must be in a class named "Main".
    class 이xn타일만들기  {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            dp[0] = 0;
            dp[1] = 1;
            if (N >= 2) {
                dp[2] = 2;
            }

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
            System.out.println(dp[N]% 10007);
        }
    }