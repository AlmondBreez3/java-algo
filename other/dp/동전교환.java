package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        int[] dp = new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            // j는 동전 개수
            for (int j = coins[i]; j <= target; j++) {
                dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
            }
        }
        System.out.println(dp[target]);
    }
}
