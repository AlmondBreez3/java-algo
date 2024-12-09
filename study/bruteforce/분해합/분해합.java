package java_algo.study.bruteforce.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값의 길이를 구하기 위해 우선 String 형식으로 입력 받는다
        String number = br.readLine();
        int N = Integer.parseInt(number);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int startN = i;
            int count = 0;
            while (startN>0) {

                count += startN % 10;

                startN /= 10;
            }

            if (count + i == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}

