package java_algo.other.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + arr[i];
            //System.out.println(dp[i]);
        }



        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            int sum = dp[end] - dp[start-1];
            System.out.println(sum);
        }
    }
}
