# 자바 알고리즘 스터디 기록

# 💡Github URL

# 💡**문제 분석 요약**
주어진 숫자들이 삼각수인지 확인하는 문제이다.

# 💡**알고리즘 설계**
하나하나 3차원 for문으로 돌려서 3개 더했을 때 
특정 값을 만족하는지 보는 알고리즘

# 💡코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[46];

        arr[0] = 0;
        for (int i = 1; i <=45; i++ ){
            arr[i] = (i*(i+1)) / 2;
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            recur(temp);
        }
    }
    public static void recur(int n) {
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {
                    if (arr[i] +arr[j] + arr[k]==n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        return;
    } 
}
```

# 💡시간복잡도
45 * 45 * 45라서
O(N)이라고 생각한다.

# 💡틀린 이유
너무 복잡하게 dp로 푸려고 하려다가 
틀린 케이스이다. 너무 안풀려서 답을 보고 너무 간단해서 놀랐다

# 💡틀린 부분 수정 or 다른 풀이
처음에 힌트를 보고 푼건 이 풀이이다
```java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[46];

        arr[0] = 0;
        for (int i = 1; i <=45; i++ ){
            arr[i] = (i*(i+1)) / 2;
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            recur(temp);
        }
    }
    public static void recur(int n) {
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {
                    if (arr[i] +arr[j] + arr[k]==n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        return;
    } 
}
```

그러다가, 3이란 조건이 주어졌으니, 백트래킹으로 풀어볼 수 있지 않을까 싶어서 
dfs를 활용한 풀이도 해보았다
```java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[46];

        arr[0] = 0;
        for (int i = 1; i <=45; i++ ){
            arr[i] = (i*(i+1)) / 2;
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(!recur(temp,0,0)){
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean recur(int n,int sum,int depth) {
        if (depth == 3) {
            if (sum == n) {
                sb.append(1).append("\n");
                return true;
            } 
            return false;
        }

        for (int i = 1; i <= 45; i++) {
            if(recur(n,sum+arr[i],depth+1)) {
                return true;
            }
        }

        return false;
    } 
}
```

# 💡느낀점 or 기억할정보
이 문제는 브론즈인만큼 3차원으로 풀어도
된다고 생각한다. 하지만 난이도가 올라갈 수록
시간 효율성을 고려해야 되는 점을 잊지 말자.
그리고.. 너무 복잡하게 생각한것 같아서 아쉽다.
역시 문제 이해하는게 8할을 차지하는 듯 하다
문제 이해하는 능력기르는게 이번주 목표로 설정하였다
