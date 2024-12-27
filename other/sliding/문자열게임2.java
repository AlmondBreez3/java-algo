package java_algo.other.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2 {
    static int N;

    // 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int max = -1;
            int min = Integer.MAX_VALUE;
            int[] alpha = new int[26];

            for (int j = 0; j < str.length();j++){
                alpha[str.charAt(j)-'a']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if (alpha[str.charAt(j)-'a']<k)continue;
                int count = 1;
                for (int t = j+1; t < str.length(); t++ ){

                    if (str.charAt(j) == str.charAt(t)) {
                        count++;
                    }

                    if (count == k) {
                        min = Math.min(t-j+1,min);
                        max = Math.max(t-j+1,max);

                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println(-1);
            } else {
                System.out.println(min+" "+max);
            }

        }
    }
}
