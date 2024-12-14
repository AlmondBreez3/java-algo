package java_algo.study.bruteforce.숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자정사각형 {
    static int[][] arr;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] =  Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max,count(i,j));
            }
        }

        System.out.println(max);
    }
    public static int count(int x, int y) {
        int count = 0;
        for (int i = 1; i <= 50;i++){
            if ((x + (i*1)) < N && (y + (i*1)) < M ) {
                if ((arr[x + (i * 1)][y] == arr[x][y]) &&
                        (arr[x][y + (i * 1)] == arr[x][y]) && (arr[x + (i * 1)][y + (i * 1)] == arr[x][y])
                ) {
                    count = i;
                }
            }
        }

        if(count == 0) {
            return 1;
        }
        return (count+1) * (count+1);
    }
}
