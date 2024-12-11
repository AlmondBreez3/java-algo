package java_algo.study.bruteforce.유레카이론;

import java.lang.*;
import java.io.*;

class 유레카이론 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[46];

        arr[0] = 0;
        for (int i = 1; i <=45; i++ ){
            arr[i] = (i*(i+1)) / 2;
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            recur(temp);
        }
    }
    public static void recur(int n) {
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {
                    if (arr[i] +arr[j] + arr[k]==n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        return;
    }
}
