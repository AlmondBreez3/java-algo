package java_algo.other.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 예산 {
    static int N,K;
    static int[] arr;
    // 처음에 start값을 arr[0]으로 해서 틀림
    // 왜 arr[0]이 아니라 0으로 해야하나?
    // 0부터 arr[0] 사이의 값이 될 가능성이 있는데 arr[0]으로 해버리면 이 가능성을 없앤다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr[N-1];
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;

            for (int a : arr) {
                if (a > mid) {
                    count += mid;
                } else {
                    count += a;
                }
            }
            if (count > K) {
                end = mid-1;
            } else {
                ans = mid;
                start = mid+1;
            }
        }
        System.out.println(ans);
    }
}
