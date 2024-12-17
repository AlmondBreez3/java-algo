package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 일이삼더하기 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        arr = new int[N];
        dp = new int[12];
        for (int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

       for (int a : arr) {
           System.out.println(dp[a]);
       }
        System.out.println();
    }
}
