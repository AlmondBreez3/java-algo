package java_algo.study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {
    static int N;
    static int[][] arr;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static List<Integer> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]==1 && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }

        System.out.println(lis.size());
        Collections.sort(lis);
        for (int a : lis) {
            System.out.println(a);
        }
    }
    public static void bfs(int x,int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int count = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx  = temp[0] +dx[i];
                int ny = temp[1] +dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] =true;
                    q.offer(new int[]{nx,ny});
                    count += 1;
                }
            }

        }

        lis.add(count);
    }
}
