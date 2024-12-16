# 💡Github URL

: 

# 💡**문제 분석 요약**

1이 존재하는 인덱스 값을 찾아야 한다.

N개의 변경 내역을 거치고 1이 존재하는 인덱스를 찾는다.

# 💡**알고리즘 설계**

hashMap을 사용해서 index 바꾸는 것을 계속해서 진행했다.

N개의 변경 내역을 다 거친 후, for문을 돌려서 1이 몇번째 인덱스에 있는지 count를 가지고 세서 구한다.

# 💡코드

```java
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

```

# 💡시간복잡도

O(N)

# 💡 틀린 이유

초반에 해맸던 부분은 N이 공의 개수인 줄 알았다. 그래서 로직은 맞는데 왜 계속 틀리지?하면서 조금 해맸다

ex) 접근방식이 틀림, 시간초과, 메모리초과

# 💡 틀린 부분 수정 or 다른 풀이

# 💡 느낀점 or 기억할정보