# 💡**문제 분석 요약**
브루트포스

분해합이 어떤 것인지 이해하기는 쉽지만, 이를 알고리즘으로 설계할 때
다양한 방법이 있겠지만 가장 효율적인 방법을 찾는 것이 관건인 것 같다.
분해합 = 생성자 + (생성자 % (10의 생성자 길이승-1)) + (생성자 % (10의 생성자 길이승-2)) + ...

# 💡**알고리즘 설계**
N이라는 분해합을 1부터 돌면서 가장 작은 생성자를 찾아 내는 것이다
1부터 돌때 그 1을 이제 생성자로 생각해서
분해합 = 생성자 + (생성자 % (10의 생성자 길이승-1)) + (생성자 % (10의 생성자 길이승-2)) + ...
이 식에 대입하면서 N(=분해합)을 만족하는 가장 작은 생성자를 찾을 것이다.

# 💡코드

```java
public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값의 길이를 구하기 위해 우선 String 형식으로 입력 받는다
        String number = br.readLine();
        int N = Integer.parseInt(number);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int startN = i;
            int count = 0;
            while (startN>0) {

                count += startN % 10;

                startN /= 10;
            }

            if (count + i == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}

```

# 💡시간복잡도
- N개의 숫자를 탐색 -> O(N)
- while문은 각 M에 대한 분해합 계산하므로 O(logN)
- 최종 : O(N * logN)

# 💡틀린 이유
처음에 반대로 생각했다
분해합 = N + (N / (N의 길이) ) + ( N / (N의 길이 - 1)) + (N / (N/(N의 길이 - 2))) ...
이 형식으로 분해합을 찾는 줄 알았는데 
오히려 생성자를 찾는 것이 문제의 핵심이었다.
이를 이해하지 못하고 반대로 구현해서 틀린거였다

# 💡틀린 부분 수정 or 다른 풀이
```java
package java_algo.study.bruteforce.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값의 길이를 구하기 위해 우선 String 형식으로 입력 받는다
        String number = br.readLine();
        int N = Integer.parseInt(number);

        int answer = 0;
        for (int i = 1; i <= N; i++) {

            int tem = String.valueOf(i).length()-1;
            int startN = i;
            int count = 0;
            while (startN>0) {
                int calc = (int) Math.pow(10,tem);
                int temp = startN / (int) calc;
                count += temp;

                startN -= (calc * temp);
                tem--;
            }

            if (count + i == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}

```

# 💡느낀점 or 기억할정보
- Math.pow는 지수승을 구현할 수 있는 자바의 문법 중 하나이다.
- 공식은 생각을 했지만, 시작 숫자 기준을 잡지 못하여 결국 힌트를 보았다
이런 것은 어떻게 생각해 낼 수 있는지 다른 분들의 풀이나 풀이과정이 궁금해졌다.
- 자릿수의 숫자를 알고 싶으면 % 10을 떠올리자