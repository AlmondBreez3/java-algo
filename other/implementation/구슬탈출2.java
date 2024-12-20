package java_algo.other.implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 내가 지금까지 봤던 것들 중에서 가장 직관적인 힌트 참고해서 품
 * 같은 위치에 있을 때를 고려하지 못했는데.. 이런 아이디어는 도대체 어떻게..?
 */
public class 구슬탈출2 {
    static int N,M;
    static char[][] arr;
    static int rx,ry,bx,by,ox,oy;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0;j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j]=='R'){
                    arr[i][j] = '.';
                    rx = i;
                    ry = j;
                } else if (arr[i][j]=='B'){
                    arr[i][j] = '.';
                    bx = i;
                    by = j;
                } else if(arr[i][j]=='O'){
                    ox = i;
                    oy = j;
                }
            }
        }

        System.out.println(bfs(rx,ry,bx,by));
    }
    public static boolean canMove(int x,int y,int xx,int yy, int dir) {
        int tempX = x;
        int tempY = y;
        int tempXX = xx;
        int tempYY = yy;
        if (dir == 0) {
            // 열 - 왼
            for (int i = y ; i > 0; i--) {

                tempY = i;
                if (arr[x][i]=='0') {
                    break;
                }
            }
        } else if (dir == 1) {
            // 열 - 오
            for (int i = y ; i < M-1; i++) {

                tempY = i;
                if (arr[x][i]=='0') {
                    break;
                }
            }

        } else if (dir == 2) {
            // 행 - 위
            for (int i = xx; i > 0; i--) {
                if (arr[i][yy] == 'O') {
                    return false;
                }
                tempXX = i;
            }
        } else if (dir == 3) {
            // 행 - 아래

            for (int i = xx; i < N-1; i++) {
                if (arr[i][yy] == 'O') {
                    return false;
                }
                tempXX = i;
            }
        }

        if (tempX == tempXX && tempY == tempYY) {
            return false;
        }

        return true;
    }
    public static int bfs(int x,int y,int xx,int yy) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,xx,yy,0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[4] == 10) return -1;

            // 동서남북 기울여서 구슬 움직이기
            for (int i = 0; i < 4; i++) {
                int rx = temp[0];
                int ry = temp[1];
                int bx = temp[2];
                int by = temp[3];

                boolean red_hole = false;
                boolean blue_hole = false;

                // 빨간 공이 벽 또는 구멍에 도달할 때까지 이동
                while(true) {
                    if (arr[rx+dx[i]][ry+dy[i]]=='#') {
                        break;
                    }
                    else if (arr[rx+dx[i]][ry+dy[i]]=='O') {
                        red_hole = true;
                        break;
                    }

                    rx += dx[i];
                    ry += dy[i];
                }
                // 파란 공이 벽 또는 구멍에 도달할 때까지 이동
                while(true) {
                    if (arr[bx+dx[i]][by+dy[i]]=='#'){
                        break;
                    } else if (arr[bx+dx[i]][by+dy[i]]=='O') {
                        blue_hole = true;
                        break;
                    }


                    bx += dx[i];
                    by += dy[i];
                }

                // 파란 공이 hole에 빠졌으면 실패
                if (blue_hole) {
                    continue;
                }

                // 파란공이 나가지 않았고 빨강공이 나갔을 때 return 결과 값
                if (red_hole) {
                    return temp[4]+1;
                }else {
                    // 겹친 경우 -> 이것을 어캐 떠올리지?
                    if (rx==bx && ry == by) {
                        if (temp[0]*dx[i] > temp[2]*dx[i]){
                            bx -= dx[i];
                        } else if (temp[0]*dx[i] < temp[2]*dx[i]){
                            rx -= dx[i];
                        }else if (temp[1]*dy[i] > temp[3]*dy[i]){
                            by -= dy[i];
                        }else if (temp[1]*dy[i] < temp[3]*dy[i]){
                            ry -= dy[i];
                        }
                    }
                }

                // 두 공이 모두 움직이지 않은 경우 continue;
                if (rx == temp[0] && ry == temp[1] && bx== temp[2] && by==temp[3]){
                    continue;
                }

                q.offer(new int[]{rx,ry,bx,by,temp[4]+1});
            }

        }
        return -1;

    }
}
