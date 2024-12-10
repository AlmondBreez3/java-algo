package java_algo.study.bruteforce.일곱난쟁이;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class 일곱난쟁이 {
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);

        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum-arr[i]-arr[j]==100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i==a || i== b) continue;
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 0; i < 9; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        // 오름차순으로 정렬
//        Arrays.sort(arr);
//
//        for (int i = 0; i < 9; i++) {
//            visited[i] = true;
//            List<Integer> tempLis = new ArrayList<>();
//            tempLis.add(arr[i]);
//            boolean flag = dfs(i,1,arr[i],tempLis);
//            if (flag) break;
//            visited[i] = false;
//        }
//        System.out.println(answer.get(0));
//    }
    public static boolean dfs(int idx, int depth, int sum, List<Integer> lis) {
        if (depth == 7) {
            if (sum==100) {
                Collections.sort(lis);

                StringBuilder sb = new StringBuilder();
                for (int i : lis) {
                    sb.append(i).append("\n");
                }
                answer.add(sb.toString());
                return true;
            }
            return false;
        }
        boolean bool=false;
        for (int i = idx ; i < 9; i++) {
            if (visited[i]) continue;
            if (sum + arr[i] <= 100) {
                visited[i] = true;
                lis.add(arr[i]);
                bool = dfs(i,depth+1,sum+arr[i], lis);
                lis.remove(lis.size()-1);
                visited[i] = false;
            }
        }

        if (bool) {
            return true;
        }
        return false;
    }
}
