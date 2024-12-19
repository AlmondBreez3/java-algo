package java_algo.study.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N;
    static int[] dp;
    static int[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];
        dist = new int[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i+1] = Integer.parseInt(st.nextToken());
            dist[i+1] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i]+i <= N) {
                dp[i+arr[i]] = Math.max(dist[i]+dp[i],dp[i+arr[i]]);
            }
            dp[i+1] = Math.max(dp[i],dp[i+1]);
        }

        System.out.println(dp[N]);

    }
//    public static int recur(int start,int n) {
//        if (dp[start] == null) {
//            if (start+n>=N)
//            dp[start] = Math.max(recur(start+n,dist[start+n]) , recur(start+1, dist[start+1])) + dist[start];
//        }
//        return dp[start];
//    }

}
