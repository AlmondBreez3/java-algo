package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 테이블 정의하기
 * 2. 점화식 찾기
 * 3. 초기값 정하기
 *
 * 점화식 구하는게 어려우면 테이블만 정의해놓고 직접 테이블을 채워보자
 */
public class 카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //1차 풀이
//        int min = Integer.MAX_VALUE;
//        for (int i = N; i > 0 ;i--) {
//            if (N%i==0) {
//                int temp = N/i;
//                int count = temp * arr[i];
//                dp[i] = Math.min(count,dp[i]);
//            } else {
//                int next = N - i;
//                int count = arr[i] + arr[next];
//                dp[i] = Math.min(count,dp[i]);
//
//            }
//            min = Math.min(dp[i],min);
//        }

        for (int i =1 ; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j]+arr[j]);
            }
        }

//        for (int i : dp) {
//            System.out.print(i+" ");
//        }
        System.out.println();
    }
}
