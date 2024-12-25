package java_algo.study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int[][] arr;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int count;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr = new int[a][b];
            visited = new boolean[a][b];
            count = 0;

            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (arr[i][j]==1 && !visited[i][j]){
                        bfs(i,j,a,b);
                        count+=1;
                    }
                }
            }

            System.out.println(count);
        }
    }
    public static void bfs(int x,int y,int a,int b){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0]+dx[i];
                int ny = temp[1] +dy[i];
                if (nx< 0 || ny < 0|| nx >= a || ny >= b) continue;
                if (!visited[nx][ny] && arr[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
