package java_algo.other.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 숫자놀이 {
    static int N,M;
    static HashMap<Integer,String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = N; i <= M; i++) {
            StringBuilder sb = new StringBuilder();
            if (i < 10) {
                if (i == 0) {
                    sb.append("zero");
                } else if ( i== 1) {
                    sb.append("one");
                }else if ( i== 2) {
                    sb.append("two");
                }else if ( i== 3) {
                    sb.append("three");
                }else if ( i== 4) {
                    sb.append("four");
                }else if ( i== 5) {
                    sb.append("five");
                }else if ( i== 6) {
                    sb.append("six");
                }else if ( i== 7) {
                    sb.append("seven");
                }else if ( i== 8) {
                    sb.append("eight");
                }else if ( i== 9) {
                    sb.append("nine");
                }
            } else {
                sb = new StringBuilder();
                String temp = String.valueOf(i);
                String[] tem = temp.split("");
                if (tem[0].equals("0")) {
                    System.out.println(tem[0]+" " +tem[1]);
                    sb.append("zero");
                } else if (tem[0].equals("1")) {

                    sb.append("one");
                } else if (tem[0].equals("2")) {

                    sb.append("two");
                }else if (tem[0].equals("3")) {
                    sb.append("three");
                } else if (tem[0].equals("4")) {
                    sb.append("four");
                }else if (tem[0].equals("5")) {

                    sb.append("five");
                } else if (tem[0].equals("6")) {

                    sb.append("six");
                }else if (tem[0].equals("7")) {
                    sb.append("seven");
                } else if (tem[0].equals("8")) {
                    sb.append("eight");
                } else if (tem[0].equals("9")) {
                    sb.append("nine");
                }

                sb.append(" ");
                if (tem[1].equals("0")) {

                    sb.append("zero");
                } else if (tem[1].equals("1")) {

                    sb.append("one");
                } else if (tem[1].equals("2")) {

                    sb.append("two");
                }else if (tem[1].equals("3")) {
                    sb.append("three");
                } else if (tem[1].equals("4")) {
                    sb.append("four");
                }else if (tem[1].equals("5")) {

                    sb.append("five");
                } else if (tem[1].equals("6")) {

                    sb.append("six");
                }else if (tem[1].equals("7")) {
                    sb.append("seven");
                } else if (tem[1].equals("8")) {
                    sb.append("eight");
                } else if (tem[1].equals("9")) {
                    sb.append("nine");
                }

            }
            map.put(i,sb.toString());
        }


        List<Map.Entry<Integer, String>> answer = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList()); // Java 11에서도 사용 가능

        int count = 0; // 한 줄에 출력한 숫자 개수 세기
        for (Map.Entry<Integer, String> entry : answer) {
            System.out.print(entry.getKey() + " ");
            count++;

            if (count % 10 == 0) { // 10개 출력하면 줄 바꿈
                System.out.println();
            }
        }
        // 마지막 줄에 남은 숫자가 있으면 줄 바꿈
        if (count % 10 != 0) {
            System.out.println();
        }
    }
}
