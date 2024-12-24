package java_algo.study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {
    static int N,M;
    static boolean[] visited;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            map.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }

        int count = 0;
        for (int i = 1;i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i);
                count += 1;
            }
        }

        System.out.println(count);
    }
    public static void bfs(int sum) {
        Queue<int[]> q = new LinkedList<>();
        visited[sum] = true;
        q.offer(new int[]{sum,0});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if (map.getOrDefault(temp[0],new ArrayList<>()).size()>0){
                List<Integer> tem = map.get(temp[0]);
                for (int a : tem) {
                    if (!visited[a]) {
                        visited[a] = true;
                        q.offer(new int[]{a,0});
                    }
                }
            }
        }
    }
}
