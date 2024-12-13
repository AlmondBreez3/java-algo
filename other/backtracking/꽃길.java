package java_algo.other.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백트래킹
// 어려운 문제는 아닌 것 같은데, 갈피를 못잡으면 계속 해맬 수 있는 문제인듯
public class 꽃길 {
    static int N;
    static int[][] arr;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[] ddy = {-3,3,0,0};
    static int[] ddx = {0,0,-3,3};
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (!visited[i][j]) {
                    List<int[]> lis = new ArrayList<>();
                    lis.add(new int[]{i,j});
                    visited[i][j] = true;
                    dfs(1,0, i,j);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(min);
    }
    public static void dfs(int depth,int sum,int x,int y) {
        if (depth == 4) {
            min = Math.min(min,sum);
            return;
        }

        List<int[]> tem = new ArrayList<>();
        int s = arr[x][y];
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= N || ny >= N || ny < 0 || nx < 0) {
                flag = false;
                break;
            }
            if (visited[nx][ny]) {
                flag = false;
                break;
            }
            tem.add(new int[]{nx,ny});
            s += arr[nx][ny];
        }

        if (!flag) {
            return;
        }

        for (int[] t : tem) {
            visited[t[0]][t[1]] = true;
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1;j++){
                if (!visited[i][j]) {
                    visited[i][j]=true;
                    dfs(depth+1,sum+s,i,j);
                    visited[i][j] = false;
                }
            }
        }
        for (int[] t : tem) {
            visited[t[0]][t[1]] = false;
        }


    }
}
