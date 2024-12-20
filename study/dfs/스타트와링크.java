package java_algo.study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트와링크 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1 ; i <= (N/2); i++) {
            visited[i] = true;
            List<Integer> start = new ArrayList<>();
            start.add(i);
            dfs(i,1,start);
            start.remove(start.size()-1);
            visited[i] = false;
        }

        System.out.println(min);
    }
    public static void dfs(int idx, int n, List<Integer> start) {
        if (n==(N/2)) {

            StringBuilder sb = new StringBuilder();
            Collections.sort(start);
            for (int i : start) {
                sb.append(i);
            }
            if(set.contains(sb.toString())){
                return;
            }
            set.add(sb.toString());
            // 링크 구하기
            List<Integer> link = new ArrayList<>();
            for (int i = 1 ; i <= N; i++) {
                if (!visited[i]) {
                    link.add(i);
                }
            }

           sb = new StringBuilder();

            for (int i : link) {
                sb.append(i);
            }
            set.add(sb.toString());

//
//
//            System.out.println(start);
//            System.out.println(link);
//            System.out.println();

            // 각각의 합 구하기
            int linkC= 0;
            for (int i = 0; i < link.size(); i++) {
                for (int j = 0; j < link.size(); j++) {
                    if (i == j) continue;
                    linkC += arr[link.get(i)][link.get(j)];
                }
            }


            int startC = 0;
            for (int i = 0; i < start.size(); i++) {
                for (int j = 0; j < start.size(); j++) {
                    if (i==j) continue;
                    startC += arr[start.get(i)][start.get(j)];
                }
            }

            // 차이 계산
            int diff = Math.abs(startC - linkC);

            // 차이 갱신
            min = Math.min(diff,min);
            return;
        }

        for (int i = idx+1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                start.add(i);
                dfs(i,n+1,start);
                start.remove(start.size()-1);
                visited[i] = false;
            }
        }
    }
}
