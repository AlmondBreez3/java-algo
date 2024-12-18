package java_algo.study.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고 {
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        visit = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int temp = Integer.parseInt(st.nextToken());
                count+=1;

                // 해당 숫자가 존재하는지 확인
                if(find(temp)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if(!flag) {
            System.out.println(count);
        }
    }
    public static boolean find(int n) {
        boolean found = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (n == arr[i][j]) {
                    visit[i][j] = true;
                    if(check()) {
                        return true;
                    }
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return false;
    }
    public static boolean check() {
        // 열
        int col = 0;
        for (int i = 0; i < 5; i++) {
            if (visit[i][0] && visit[i][1] && visit[i][2] && visit[i][3] && visit[i][4]) {
                col++;
            }
        }


        // 행
        int row = 0;
        for (int i = 0; i < 5; i++) {
            if (visit[0][i] && visit[1][i] && visit[2][i] && visit[3][i] && visit[4][i]) {
                row++;
            }
        }


        // 대각선
        int diag = 0;
        if (visit[0][0] && visit[1][1] && visit[2][2] && visit[3][3] && visit[4][4]) {
            diag += 1;
        }
        if (visit[4][0] && visit[3][1] && visit[2][2] && visit[1][3] && visit[0][4]) {
            diag += 1;
        }

        if (row + col + diag >= 3) {
            return true;
        }
        return false;
    }
}
