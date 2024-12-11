package java_algo.other.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j < N; j++) {
            visited[j] = true;
            dfs(j,j,0,0);
            visited[j] = false;
        }

        System.out.println(min);
    }
    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == (N-1)) {
            if (arr[y][x] == 0) return;
            sum += arr[y][x];
            min = Math.min(sum,min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[y][i] > 0) {
                visited[i] = true;
                dfs(x,i,depth+1,sum+arr[y][i]);
                visited[i] = false;
            }
        }
    }
}
