package java_algo.study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS
{
    static int N,M,V;
    static boolean[] visited;
    static List<Integer> activeNode = new ArrayList<>();
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            activeNode.add(a);
            activeNode.add(b);

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // 조건 중, 같은 깊이나 너비에 있는 정점이 많다면,
        // 가장 작은 것부터 탐색한다고 나와있어서 오름차순으로 정렬이 필요
        for (int a : map.keySet()) {
            if (map.getOrDefault(a,new ArrayList<>()).size() != 0) {
                List<Integer> temp = map.get(a);
                Collections.sort(temp);
                map.put(a,temp);
            }
        }

        if (!activeNode.contains(V)){
            System.out.println(V);
        }

        visited[V] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" ");
        dfs(V,1, sb);
        //visited[V] = false;
        bfs(V);
    }
    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        q.offer(new int[]{start,1});

        StringBuilder sb = new StringBuilder();
        sb.append(start).append(" ");
        visit[start] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tempX = temp[0];
            int cur = temp[1];

            if (map.getOrDefault(tempX, new ArrayList<>()).size()>0) {
                for (int i : map.get(tempX)) {
                    if (!visit[i]) {
                        visit[i] = true;

                        sb.append(i).append(" ");
                        q.offer(new int[]{i,cur+1});
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int start, int depth, StringBuilder s) {
        if (allVisit()){
            System.out.println(s.toString());
            return;
        }
        if (depth == N) {
            System.out.println(s.toString());
            return;
        }

            if (map.getOrDefault(start,new ArrayList<>()).size()>0){
                for (int t : map.get(start)) {
                    if (!visited[t]) {
                        visited[t] = true;
                        s.append(t).append(" ");
                        dfs(t,depth+1,s);
                        //s.deleteCharAt(s.length()-1);
                        //visited[t] = false;
                    }
                }
            }
    }
    public static boolean allVisit() {
        for (int i : activeNode) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
