
# 💡**문제 분석 요약**

문제 조건 : 왼쪽 위가 W일때, 왼쪽 위가 B인 경우를 나눠서 count를 2번 구하고, 가장 작은 값을 계속해서 갱신

# 💡**알고리즘 설계**

for문을 돌면서 0부터 N-8, M-8까지 돌면서 완전탐색. 왼쪽 위가 W일때, 왼쪽 위가 B인 경우를 나눠서 count를 2번 구하고, 가장 작은 값을 계속해서 갱신.

여기서 키포인트는 미리 정답 값을 구현해 놓는 것인 것 같다.

# 💡코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[][] correct1 = {
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0}
    };

    static int[][] correct2 = {
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i =0 ; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j]=='B'){

                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i <= N-8; i++) {
            for (int j =0; j <= M-8;j++) {
                search(i,j,i+8,j+8);
            }
        }

        System.out.println(min);
    }
    static void search(int x,int y, int endX, int endY) {
        int count = 0;
        int count2= 0;
            for (int i = x; i < endX; i++){
                for (int j = y; j < endY;j++) {
                    if (correct1[i%8][j%8] != arr[i][j]) {
                        count += 1;
                    }
                }
            }
            for (int i = x; i < endX; i++){
                for (int j = y; j < endY;j++) {
                    if (correct2[i%8][j%8] != arr[i][j]) {
                        count2 += 1;
                    }
                }
            }

            min = Math.min(min,Math.min(count,count2));
        //System.out.println(count + " "+count2);
//
//        System.out.println(x+" "+y+" "+count+" "+count2+" "+min);
    }
}

```

# 💡시간복잡도

O(N^2)

# 💡틀린 이유

ex) 접근방식이 틀림, 시간초과, 메모리초과

# 💡틀린 부분 수정 or 다른 풀이

# 💡느낀점 or 기억할정보

풀기 전 다짐 : 이거 풀어본 적 있으니까 틀리지 말자..!!

얼추 기억나는 걸로는 이제 처음 시작 뿐만 아니라 마지막 N,N칸 부터도 탐색해야 하는걸로 기억한다.

여기서 키포인트는 미리 정답 값을 구현해 놓는 것밖에 떠올리지 못했는데, 다른 분들은 어떻게 했는지 궁금합니다.