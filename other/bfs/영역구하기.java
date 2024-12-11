package java_algo.other.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {
    static int[][] arr;
    static int M,N;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static List<Integer> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = b; j < y; j++) {
                for (int k = a; k < x; k++) {
                    visited[j][k] = true;
                    arr[j][k] = 1;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (arr[j][k] == 0 && !visited[j][k]) {
                    bfs(j,k);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(lis);
        for (int i: lis) {
            sb.append(i).append(" ");
        }
        System.out.println(lis.size());
        System.out.println(sb.toString());
    }
    public static void bfs(int x,int y) {
        Queue<int[]> q=  new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y,1});
        int count = 0;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            count += 1;

            for (int i = 0; i < 4; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny,temp[2]+1});
                    }
                }
            }
        }
        lis.add(count);
    }
}
