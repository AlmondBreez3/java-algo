package java_algo.study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int[] oper;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for (int i = 0; i < 4;i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int idx,int depth,int sum) {
        if (depth == N-1) {
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            return;
        }

        for (int i = 0; i < 4 ;i++) {
            if (oper[i] > 0) {
                oper[i]--;
                if (i==0) {
                    dfs(idx+1,depth+1,sum+arr[idx+1]);
                } else if (i==1) {
                    dfs(idx+1,depth+1,sum-arr[idx+1]);
                } else if (i==2) {
                    dfs(idx+1,depth+1,sum*arr[idx+1]);
                } else if (i==3) {
                    dfs(idx+1,depth+1,sum/arr[idx+1]);
                }
                oper[i]++;
            }
        }
    }
}
