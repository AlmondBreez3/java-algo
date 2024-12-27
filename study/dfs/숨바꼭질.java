package java_algo.study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs(N,0);

        System.out.println(min);
    }
    public static void bfs(int start, int time) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start,time});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if (temp[0] == M) {
                //System.out.println(temp[0]);
                min = Math.min(min,temp[1]);
                break;
            }

            if (visited[temp[0]]) continue;
            visited[temp[0]] = true;

            if (temp[0]-1>=0 && temp[0]-1 <= 100000) {

                q.offer(new int[]{temp[0]-1,temp[1]+1});
            }
            if (temp[0]+ 1 >= 0 && temp[0]+1 <= 100000 ){

                q.offer(new int[]{temp[0]+1,temp[1]+1});
            }
            if (temp[0]*2>=0 && temp[0]*2 <= 100000) {

                q.offer(new int[]{temp[0]*2,temp[1]+1});
            }
        }
    }
}
