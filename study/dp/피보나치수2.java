package java_algo.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            dp[0] = 0;
            if (N==0) {
                System.out.println(0);
                return;
            }
            dp[1] = 1;

            if (N < 2) {
                System.out.println(dp[N]);
                return;
            }

            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i-1] +dp[i-2];
            }

            System.out.println(dp[N]);
        }

}
