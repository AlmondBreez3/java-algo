package java_algo.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면
 * 그 점수는 제외하고 평균을 구합니다.
 */
public class 상호평가 {
    public static String main(int[][] scores) {
        String answer = "";

        for (int i = 0; i < scores.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int cur = scores[i][i];
            int max = scores[i][i];
            int min = scores[i][i];

            for (int j = 0; j < scores[0].length; j++) {
                max = Math.max(scores[j][i], max);
                min = Math.min(scores[j][i], min);
                map.put(scores[j][i], map.getOrDefault(scores[j][i], 0) + 1);
            }

            if (cur == max && map.getOrDefault(cur, 0) < 2) {
                map.remove(max);
            }
            if (cur == min && map.getOrDefault(cur, 0) < 2) {
                map.remove(min);
            }

            int total = 0;

            List<Integer> lis = map.keySet().stream().toList();
            int cnt = lis.size();
            for (int t : lis) {
                total += t;
            }

            double average = (double) total / cnt;
            char grade;

            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 50) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            answer += grade;
        }

        return answer;

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        HashMap<Integer,Integer> maxMap = new HashMap<>();
//        HashMap<Integer,Integer> minMap = new HashMap<>();
//
//        int[][] arr = new int[5][5];
//
//        for (int i = 0; i < 5; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < 5;j++ ){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < 5; i++) {
//            int minT = arr[i][0];
//            int maxT = arr[i][0];
//            for (int j = 1; j < 5;j++ ){
//                minT = Math.min(minT,arr[i][j]);
//                maxT = Math.max(maxT,arr[i][j]);
//            }
//            // 행
//            maxMap.put(i,maxT);
//            minMap.put(i,minT);
//        }
//
//        List<String> lis = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            int sum = 0;
//            int count = 0;
//            int count2 = 0;
//            int min = Integer.MAX_VALUE;
//            int max = 0;
//            int countMax = 0;
//            int countMin = 0;
//            boolean flag = true;
//            int total = 5;
//            for (int j = 0; j < 5;j++) {
//
//                sum += arr[j][i];
//                if (maxMap.get(j)==arr[j][i]) {
//                    flag = false;
//                    countMax += 1;
//                    max = arr[j][i];
//                } else if (minMap.get(j)==arr[j][i]){
//                    flag = false;
//                    countMin += 1;
//                    min = arr[j][i];
//                }
//            }
//
//            double res = 0;
//            if(!flag){
//                if (countMax < 2) {
//                    total--;
//                    sum -= max;
//                }
//                if (countMin <2) {
//                    total--;
//                    sum -= min;
//                }
//
//                System.out.println(sum+"sum");
//                res = (double) sum / total;
//            } else {
//                res = (double) sum / 5;
//            }
//
//
//            System.out.println(res+" "+i);
//
//            if (res>=90) {
//                lis.add("A");
//            } else if (res >= 80 && res < 90) {
//                lis.add("B");
//            } else if (res >= 70 && res < 80) {
//                lis.add("C");
//            }else if (res >= 50 && res < 70) {
//                lis.add("D");
//            } else if (res < 50) {
//                lis.add("F");
//            }
//        }
//        System.out.println(lis);
    }
}
