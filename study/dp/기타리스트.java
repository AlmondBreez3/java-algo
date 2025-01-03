package java_algo.study.dp;

import java.util.*;
import java.io.*;

class 기타리스트 {
        static long[] arr;  // long 배열로 변경
        static long[][] dp; // dp 배열도 long[][]로 변경
        static int N, S, M;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());  // 곡 수
            S = Integer.parseInt(st.nextToken());  // 시작 볼륨
            M = Integer.parseInt(st.nextToken());  // 최대 볼륨

            arr = new long[N + 1];  // long 배열로 변경
            arr[0] = S;  // 시작 볼륨 설정
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Long.parseLong(st.nextToken());  // 각 곡의 볼륨 변화량
            }

            dp = new long[N + 1][M + 1];  // dp 배열도 long[][]로 변경
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], -2);  // -1로 초기화 (값을 계산하지 않았다는 의미)
            }

            // 재귀 호출로 최적의 볼륨을 찾기
            System.out.println(recur(S, 0));  // 시작 볼륨과 첫 번째 곡부터 시작
        }

        // 재귀 함수: 현재 볼륨과 곡 번호를 기준으로 최적의 볼륨을 찾아 반환
        public static long recur(long n, int i) {
            // 볼륨이 범위를 벗어나면 -1 리턴
            if (n < 0 || n > M) return -1;

            // 모든 곡을 다 처리한 경우 현재 볼륨 반환
            if (i == N) return n;

            // 이미 계산된 값이 있으면 그 값 리턴
            if (dp[i][(int)n] != -2) return dp[i][(int)n];

            // 볼륨을 증가시키거나 감소시키면서 재귀 호출
            long increase = recur(n + arr[i + 1], i + 1);  // 볼륨 증가
            long decrease = recur(n - arr[i + 1], i + 1);  // 볼륨 감소

            // 두 결과 중 더 큰 값을 저장하고 반환
            dp[i][(int)n] = Math.max(increase, decrease);
            return dp[i][(int)n];
        }
}
