package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 테이블 정의하기
 * 2. 점화식 찾기
 * 3. 초기값 정하기
 *
 * 점화식 구하는게 어려우면 테이블만 정의해놓고 직접 테이블을 채워보자
 */

public class 이동하기 {
    static int[] dy = {0,1,1};
    static int[] dx = {1,0,1};
    static int N,M;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++ ){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }


        // 1. 테이블 정의하기 : dp[i][j] = i,j에서 가져올 수 있는 사탕의 최댓값
        // 2. 점화식 세우기 : math.max(arr[r+1][c] , arr[r][c+1]) , arr[r+1][c+1])
        // 범위 땜에 안될 것 같으면 그냥! 다른 발상의 전환 생각하기
        for (int i = 1; i <= N; i++ ){
            for (int j = 1; j <= M; j++) {
                arr[i][j] += Math.max(arr[i][j-1], Math.max(arr[i-1][j],arr[i-1][j-1]));
            }
        }
//        for (int i = 1; i <= N; i++ ){
//            for (int j = 1; j <= M; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//        }
        System.out.println(arr[N][M]);
    }
}
