# 💡Github URL

: 

# 💡**문제 분석 요약**

주어진 직사각형 안에 꼭지점 4개의 값이 동일한 정사각형 중에,

가장 큰 크기를 출력

# 💡**알고리즘 설계**

N과 M은 50이 한계이므로 for문을 여러개 돌려도 문제가 되지 않을 거라고 생각하여,

for문으로 돌리고 여기서 포인트는 N,M 경계가 50이니까 정사각형 하나의 변 길이도 50이 MAX임을 알수가 있다.

이를 토대로 for문을 돌려서 각 자릿수를 시작하여 변의 길이가 1에서 50까지 for문을 돌리면서 이를 만족하는 최대 i의 값을 구하는 방식으로 구했다.

# 💡코드

```java
package java_algo.study.bruteforce.숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자정사각형 {
    static int[][] arr;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] =  Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max,count(i,j));
            }
        }

        System.out.println(max);
    }
    public static int count(int x, int y) {
        int count = 0;
        for (int i = 1; i <= 50;i++){
            if ((x + (i*1)) < N && (y + (i*1)) < M ) {
                if ((arr[x + (i * 1)][y] == arr[x][y]) &&
                        (arr[x][y + (i * 1)] == arr[x][y]) && (arr[x + (i * 1)][y + (i * 1)] == arr[x][y])
                ) {
                    count = i;
                }
            }
        }

        if(count == 0) {
            return 1;
        }
        return (count+1) * (count+1);
    }
}

```

# 💡시간복잡도

O(N*M)

# 💡틀린 이유

ex) 접근방식이 틀림, 시간초과, 메모리초과

# 💡틀린 부분 수정 or 다른 풀이

# 💡느낀점 or 기억할정보