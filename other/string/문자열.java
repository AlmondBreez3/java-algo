package java_algo.other.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {
    static String first;
    static String second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        first = strs[0];
        second = strs[1];
        int result = 50;

        if (first.length()==second.length()) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) !=second.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        } else {
            if (second.contains(first)) {
                System.out.println(0);
            } else {
                // 제일 중요한 구현 부분인 것 같은데 생각이 안나
                for (int i = 0; i < first.length()-(second.length()-first.length())+1; i++) {
                   int tmp = 0;
                   for (int j = 0; j < first.length();j++) {
                       if (first.charAt(j) != second.charAt(i+j)) {
                           tmp++;
                       }
                   }
                   result = Math.min(tmp,result);
                }
                System.out.println(result);
//                int cnt = first.length();
//                int start = 0;
//                int end = 0;
//                int ans = 0;
//                while (cnt < second.length()) {
//                    if (second.charAt(end) != first.charAt(start)) {
//                        end++;
//                        cnt++;
//                        ans++;
//                    }
//                }
//                System.out.println(ans);
            }
        }
    }
}
