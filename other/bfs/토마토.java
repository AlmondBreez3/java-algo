package java_algo.other.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {
    static int N,M;
    static int[][] arr;
    static int firstX,firstY;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static List<int[]> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==1) {
                    lis.add(new int[]{i,j});
                }
            }
        }


        bfs(firstX,firstY);
    }
    public static void bfs(int x, int y) {
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        for (int[] temp : lis) {
            visited[temp[0]][temp[1]] = true;
            q.offer(new int[]{temp[0],temp[1],0});
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            cnt = Math.max(cnt,temp[2]);

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx < 0 || ny< 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = 1;
                    q.offer(new int[]{nx,ny, temp[2]+1});
                }
            }
        }

        if (!check()) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(cnt);
        }
    }
    public static boolean check() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]==0) {
                    return false;
                }
            }
        }


        return true;
    }
}
