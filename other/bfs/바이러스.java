package java_algo.other.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스 {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            map.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }

        bfs(1);
    }
    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start});
        int count = 0;
        boolean[] visit = new boolean[N+1];
        visit[start] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            if (map.getOrDefault(temp[0],new ArrayList<>()).size()>0){
                List<Integer> lis = map.get(temp[0]);
                for (int i : lis) {
                    if (!visit[i]) {
                        visit[i] = true;
                        count += 1;
                        q.offer(new int[]{i});
                    }
                }
            }
        }
        System.out.println(count);
    }
}
