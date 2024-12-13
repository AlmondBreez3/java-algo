package java_algo.study.bruteforce.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 체스판다시칠하기 {
    static int N,M;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[][] correct1 = {
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0}
    };

    static int[][] correct2 = {
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        for (int i =0 ; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j]=='B'){

                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i <= N-8; i++) {
            for (int j =0; j <= M-8;j++) {
                search(i,j,i+8,j+8);
            }
        }

        System.out.println(min);
    }
    static void search(int x,int y, int endX, int endY) {
        int count = 0;
        int count2= 0;
            for (int i = x; i < endX; i++){
                for (int j = y; j < endY;j++) {
                    if (correct1[i%8][j%8] != arr[i][j]) {
                        count += 1;
                    }
                }
            }
            for (int i = x; i < endX; i++){
                for (int j = y; j < endY;j++) {
                    if (correct2[i%8][j%8] != arr[i][j]) {
                        count2 += 1;
                    }
                }
            }

            min = Math.min(min,Math.min(count,count2));
        //System.out.println(count + " "+count2);
//
//        System.out.println(x+" "+y+" "+count+" "+count2+" "+min);
    }
}
