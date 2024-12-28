package java_algo.study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질2
{
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        bfs(N,0);


    }
    public static void bfs(int start, int time) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start,time});
        int minC = 0;
        Arrays.fill(visited,-1);


        while(!q.isEmpty()){
            int[] temp = q.poll();

            if (temp[0] == M) {
                //System.out.println(temp[0]);
                if (visited[M] == temp[1]) {
                    minC++;
                } else if (visited[M] > temp[1] || visited[M] == -1 ) {
                    // 새로운 최소시간 도달
                    visited[M] = temp[1];
                    minC = 1;
                }
                continue;
            }

            if (temp[0]-1>=0 && temp[0]-1 <= 100000) {
                if (visited[temp[0]-1] == -1 || visited[temp[0]-1] >= temp[1]+1) {
                    visited[temp[0]-1] = temp[1]+1;
                    q.offer(new int[]{temp[0]-1,temp[1]+1});
                }
            }
            if (temp[0]+ 1 >= 0 && temp[0]+1 <= 100000 ){
                if (visited[temp[0]+1] == -1 || visited[temp[0]+1] >= temp[1]+1) {
                    visited[temp[0]+1] = temp[1]+1;

                    q.offer(new int[]{temp[0]+1,temp[1]+1});
                }
            }
            if (temp[0]*2>=0 && temp[0]*2 <= 100000) {
                if (visited[temp[0]*2] == -1 || visited[temp[0]*2] >= temp[1]+1) {
                    visited[temp[0]*2] = temp[1]+1;
                    q.offer(new int[]{temp[0]*2,temp[1]+1});
                }
            }
        }

        System.out.println(visited[M]);
        System.out.println(minC);
    }
}
