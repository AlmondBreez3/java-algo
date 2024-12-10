# 자바 알고리즘 스터디 기록

# 💡Github URL

# 💡**문제 분석 요약**
9개의 난쟁이 중 7명이고 합이 100인 조건을 만족하는 경우를 찾아 오름차순으로
출력해야 한다.

# 💡**알고리즘 설계**
백트래킹으로 구현.
depth==7이고 sum==100이면 바로 출력 후 return

# 💡코드

```java
public class 일곱난쟁이 {
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);

        for (int i = 0; i < 9; i++) {
            visited[i] = true;
            List<Integer> tempLis = new ArrayList<>();
            tempLis.add(arr[i]);
            boolean flag = dfs(i,1,arr[i],tempLis);
            if (flag) break;
            visited[i] = false;
        }
        System.out.println(answer.get(0));
    }
    public static boolean dfs(int idx, int depth, int sum, List<Integer> lis) {
        if (depth == 7) {
            if (sum==100) {
                Collections.sort(lis);

                StringBuilder sb = new StringBuilder();
                for (int i : lis) {
                    sb.append(i).append("\n");
                }
                answer.add(sb.toString());
                return true;
            }
            return false;
        }
        boolean bool=false;
        for (int i = idx ; i < 9; i++) {
            if (visited[i]) continue;
            if (sum + arr[i] <= 100) {
                visited[i] = true;
                lis.add(arr[i]);
                bool = dfs(i,depth+1,sum+arr[i], lis);
                lis.remove(lis.size()-1);
                visited[i] = false;
            }
        }

        if (bool) {
            return true;
        }
        return false;
    }
}
```

# 💡시간복잡도
O(N)인 것 같다. 정해진 숫자를 가지고 있어 효울적으로 동작한다고 본다.
n이 커질수록 시간 복잡도가 빠르게 증가하지만,
k=7로 고정된 탐색 깊이 덕분에 비교적 효율적으로 처리할 수 있었다.
# 💡틀린 이유

# 💡틀린 부분 수정 or 다른 풀이
너무 어렵게 푼것 같아서 더 쉬운 방법이 있는지 다른 풀이들을 찾아보았다.
총 합을 구해서, 9개 중에서 7개를 찾는 것이므로, 2개의 가짜 난쟁이를 
찾아야 하니 fake1, fake2이렇게 변수를 선언해서 2차원 배열로 선언해서 
찾아가는 과정을 거치면 된다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
       static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);

        int a = 0;
        int b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum-arr[i]-arr[j]==100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i==a || i== b) continue;
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}

```

# 💡느낀점 or 기억할정보