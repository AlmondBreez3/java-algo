package java_algo.other.implementation.배열복원하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열복원하기 {
    static int H,W,X,Y;
    static int[][] newArr;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        arr = new int[H][W];

        newArr = new int[H+X][W+Y];

        for (int i = 0; i < (H+X); i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < (W+Y); j++) {
                newArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 겹치지 않고 A 배열에 존재할 때
        for (int j = 0; j < X; j++) {
            for (int i = 0; i < W; i++) {
                arr[j][i] = newArr[j][i];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = X; j < H; j++) {
            for (int i = 0; i < Y; i++) {
                arr[j][i] = newArr[j][i];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 겹쳐 있는 부분
        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                arr[i][j] = newArr[i][j] - arr[i-X][j-Y];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
