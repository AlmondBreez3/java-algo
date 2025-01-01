package java_algo.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
    static int N;
    static Integer[]  dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        arr = new int[N+1];

        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        dp[0] = 0;
        dp[1] = arr[1];
        if(N>1){
            dp[2]=arr[1]+arr[2];
        }

        System.out.println(recur(N));
    }

    public static int recur(int i) {
        int result = arr[i];
        if (dp[i]==null) {
                dp[i] = Math.max(arr[i-1]+recur(i-3),recur(i-2)) + result;
        }
        return dp[i];
    }
}
