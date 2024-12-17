package java_algo.study.simulation.기적의매매법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기적의매매법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 준현
        int curMon = N;
        int tem = 0;
        for (int i = 0; i < 14; i++) {
            if (arr[i] <= curMon) {
                int temp = N / arr[i];
                tem += temp;
                int minusM = temp * arr[i];
                curMon -= minusM;
            }
        }
        int jun = (arr[13] * tem) + curMon;

        // 성민
        int tem2 = 0;
        int curM = N;
        for (int i = 0; i < 11; i++) {
            if (arr[i+2] > arr[i+1] && arr[i+1] > arr[i]) {
                if (tem2==0) continue;
                curM += arr[i+3] * tem2;
                tem2 = 0;

            } else if (arr[i+2] < arr[i+1] && arr[i+1] < arr[i]) {
                if (curM / arr[i+3] > 0) {
                    int cnt = curM / arr[i + 3];
                    tem2 += cnt;
                    curM -= (cnt * arr[i + 3]);
                }

            }
        }
        int sung = (arr[13] * tem2) + curM;

        if (jun > sung) {
            System.out.println("BNP");
        } else if (sung > jun) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }
}
