package java_algo.other.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr = new int[a+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= a-b+1; i++) {
            int sum = 0;
            for (int j = i; j < i + b; j++) {
                sum += arr[j];
            }
            result = Math.max(result,sum);
        }
        System.out.println(result);
    }
}
