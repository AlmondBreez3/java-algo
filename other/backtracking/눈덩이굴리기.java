package java_algo.other.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 눈덩이굴리기 {
    static int N, M;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        visited[1] = true;
        dfs(1 +arr[1],1,1);
        visited[1] = false;
        // 위치가 잘못되어있었다.
        if (N==1) {
            System.out.println(max);
            return;
        }
        visited[2] = true;
        dfs((1/2)+arr[2],2,1);
        visited[2] = false;
        System.out.println(max);
    }
    public static void dfs(int size, int idx, int time) {
        if (idx == N) {
            max = Math.max(size,max);
            return;
        }
        if(time==M) {
            max = Math.max(size,max);
            return;
        }

        if (idx+1 <= N) {
            if (!visited[idx+1]) {
                visited[idx+1]=true;
                dfs(size+arr[idx+1], idx+1, time+1);
                visited[idx+1]=false;
            }
        }
        if (idx + 2 <= N) {
            if (!visited[idx+2]) {
                visited[idx+2] = true;
                dfs((size/2)+arr[idx+2],idx+2,time+1);
                visited[idx+2] = false;
            }
        }
    }
}

