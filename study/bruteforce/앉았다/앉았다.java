package java_algo.study.bruteforce.앉았다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.text.DecimalFormat;
import java.util.Scanner;

import java.text.DecimalFormat;
import java.util.Scanner;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 앉았다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");  // 출력 형식을 소수점 3자리로 설정

        // 입력 값 받기
        int a = sc.nextInt();
        int b = sc.nextInt();

        // a와 b가 같은지 확인
        boolean sameCards = a == b;

        // 전체 가능한 경우의 수 (18C2 = 153 경우)
        int totalCases = 153;
        int validCases = 0;

        // 목표 값은 (a + b) % 10
        int targetValue = (a + b) % 10;

        // a와 b가 같은 경우 확률 계산
        if (sameCards) {
            // 같은 카드일 경우, 남은 카드를 제외하고 유효한 경우를 계산
            validCases = totalCases - (10 - a);
            // 결과를 소수점 3자리까지 출력
            System.out.println(df.format(validCases / (totalCases * 1.0)));
        } else {
            // 다른 카드일 경우, 모든 카드 쌍에 대해 계산
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
                    int sum = i + j;
                    // 카드 합의 10으로 나눈 나머지가 목표값보다 작은지 확인
                    if (sum % 10 < targetValue) {
                        // 카드 i나 j 중 하나라도 a나 b와 같으면 2를 더하고, 그렇지 않으면 4를 더함
                        if (i == a || i == b || j == a || j == b) {
                            validCases += 2;  // 하나라도 a나 b와 같으면 2를 더함
                        } else {
                            validCases += 4;  // a와 b와 관련 없는 경우는 4를 더함
                        }
                    }
                }
            }
            // 결과를 소수점 3자리까지 출력
            System.out.println(df.format(validCases / (totalCases * 1.0)));
        }

        sc.close();  // Scanner 객체 닫기
    }
}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        // 땡인 경우
//        if (N==M) {
//            int remain = 10 - N;  // 남은 카드 수
//            double cost = (double) remain / 153.0;  // 확률 계산
//            double answer = 1 - cost;
//            System.out.printf("%.3f\n", answer);  // 소수점 셋째 자리까지 출력
//            return;
//        } else {
//            int count = 0;
//            for (int i = 1; i<=10; i++) {
//                for (int j = i+1; j <= 10; j++) {
//                    if (i == N || i == M || j == N || j == M ) continue;
//                    if (((i+j)%10) < ((N+M)%10)) {
//                        count++;
//                    }
//                }
//            }
//            // 확률 계산
//            double probability = (double) count / 153;
//            System.out.printf("%.3f\n", probability);  // 소수점 셋째 자리까지 출력
//            return;
//        }
//    }

