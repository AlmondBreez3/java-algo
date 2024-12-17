package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for (int i = 0; i <= 14; i++) {
            dp[0][i] = i;
        }

        for (int j = 1; j <= 14; j++) {  // 1층부터 14층까지
            for (int t = 1; t <= 14; t++) {  // 1호부터 14호까지
                dp[j][t] = 0;  // 초기화
                for (int k = 0; k <= t; k++) {  // k번째까지 누적합을 구한다
                    dp[j][t] += dp[j-1][k];
                }
            }
        }
//
//        for (int j = 0; j <= 3; j++) {
//            for (int k = 0; k <= 3; k++) {
//                System.out.print(dp[j][k]+" ");
//            }
//            System.out.println();
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            if (a==0) {
                sb.append(dp[0][b]).append("\n");
                continue;
            }
            int sum = 0;
            for (int j = 0; j <= b; j++) {
                sum+=dp[a-1][j];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());

    }
}
