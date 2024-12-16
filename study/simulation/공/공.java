package java_algo.study.simulation.공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 공 {
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            map.put(i,i);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int newA = map.get(b);
            int newB = map.get(a);
            map.put(a,newA);
            map.put(b,newB);
        }

        int count = 0;
        for (int i = 1; i <= 3; i++) {
            if (1 == map.get(i)){
                count += 1;
                break;
            } else {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
