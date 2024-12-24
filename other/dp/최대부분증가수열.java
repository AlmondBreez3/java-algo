package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[i]는 arr의 i번째 숫자를 마지막항으로 하는 최대 부분 증가 수열
// ex dp[3]은 8을 마지막으로 하면서 최대부분 증가수열의 길이 값.
public class 최대부분증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            max =Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
