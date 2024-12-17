package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;
        System.out.println(recur(N));
    }
    public static int recur(int a) {
        if (dp[a] == null){
            if (a % 6 ==0) {
                dp[a] = Math.min(recur(a-1), Math.min(recur(a/3), recur(a/2))) + 1;
            } else if (a % 3== 0){
                dp[a] = Math.min(recur(a-1), recur(a/3))+1;
            } else if (a%2==0){
                dp[a] = Math.min(recur(a-1),recur(a/2))+1;
            } else {
                dp[a] = recur(a-1) +1;
            }
        }
        return dp[a];
    }
}
