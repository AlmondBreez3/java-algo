package java_algo.other.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브론즈, 구현
// 백준 스페셜 져지 의미가 답이 다양할 수 있다는 뜻인걸 처음 알았다.
// 예제 입력이 같은 입력에 대해 다른 출력이 있어서 너무 어렵게 생각했다.
public class 디지털티비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int k = 0;
        int s = 0;

        for (int i = 0 ; i < N; i++) {
            String temp = br.readLine();
            arr[i] = temp;
            if (temp.equals("KBS1")) {
                k = i;
            }
            if (temp.equals("KBS2")) {
                s = i;
            }
        }

        // 예제 입력2에 적절한 답변
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while(k != 0) {
            if (cur < k) {
                cur += 1;
                sb.append(1);
            } else if (cur == k) {

                    String temp = arr[k];
                    arr[k] = arr[cur-1];
                    arr[cur-1] = temp;
                    sb.append(4);
                    k -= 1;
                    cur = k;
            } else if (k == 0) {
                String temp = arr[k];
                arr[k] = arr[cur-1];
                arr[cur-1] = temp;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i].equals("KBS2")){
                s = i;
            }
        }

        // KBS2에 대해 순회
        while(s!=1){
            if (cur < s) {
                cur += 1;
                sb.append(1);
            } else if (cur == s) {
                    String temp = arr[s];
                    arr[s] = arr[cur-1];
                    arr[cur-1] = temp;
                    sb.append(4);
                    s-=1;
                    cur = s;
            } else if (s == 1) {
                String temp = arr[s];
                arr[s] = arr[cur-1];
                arr[cur-1] = temp;
                break;
            }
        }

        System.out.println(sb.toString());

    }
}
