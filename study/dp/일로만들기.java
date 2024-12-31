package java_algo.study.dp;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class 일로만들기 {
    static int N;
    static int[]  dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        recur(N);
        System.out.println(dp[N]);
    }
    public static int recur(int n) {
        if(n==1) {
            return 1;
        }
        if (dp[n] == 0) {
            if (n%3 == 0 && n % 2 == 0 ) {
                dp[n] += Math.min(recur(n/3), Math.min(recur(n/2),recur(n/3)));
            } else if (n % 3 == 0) {
                dp[n] += Math.min(recur(n/3),recur(n-1));
            } else if (n % 2 == 0) {
                dp[n] += Math.min(recur(n/2),recur(n-1));
            } else {
                dp[n] += recur(n-1);
            }
        }
        return dp[n]+1;
    }
}