# 💡**문제 분석 요약**

문제 조건 : 수학문제 푸는 것 같았다.

족보는 이미 주어졌으니, 본인이 질 경우를 계산해서

(1-본인이 질 확률)

# 💡**알고리즘 설계**

처음에는 영학이를 제외한 18개부터 고려해서 계산을 시작했다

예시 1 1을 보면, 1땡이므로 10땡~2떙까지의 경우의 수만 더하면 되기 때문에 18C2의 조합으로 구해보면 된다

또한, 총 20개의 족보가 있으므로 하나하나의 경우의 수를 계산해서 배열로 저장해두고
입력값에 따라 필요한 값을 출력하게 설계하였다

하지만 복잡한 것 같아서 2차원 배열로 해서 조건 만족 시키는 것을 count하는 방식으로 진행하였다

# 💡코드

```java
import java.text.DecimalFormat;
import java.util.Scanner;

public class 앉았다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");  // 출력 형식을 소수점 3자리로 설정

        // 입력 값 받기
        int a = sc.nextInt();
        int b = sc.nextInt();

        // a와 b가 같은지 확인
        boolean sameCards = a == b;

        // 전체 가능한 경우의 수 (18C2 = 153 경우)
        int totalCases = 153;
        int validCases = 0;

        // 목표 값은 (a + b) % 10
        int targetValue = (a + b) % 10;

        // a와 b가 같은 경우 확률 계산
        if (sameCards) {
            // 같은 카드일 경우, 남은 카드를 제외하고 유효한 경우를 계산
            validCases = totalCases - (10 - a);
            // 결과를 소수점 3자리까지 출력
            System.out.println(df.format(validCases / (totalCases * 1.0)));
        } else {
            // 다른 카드일 경우, 모든 카드 쌍에 대해 계산
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
                    int sum = i + j;
                    // 카드 합의 10으로 나눈 나머지가 목표값보다 작은지 확인
                    if (sum % 10 < targetValue) {
                        // 카드 i나 j 중 하나라도 a나 b와 같으면 2를 더하고, 그렇지 않으면 4를 더함
                        if (i == a || i == b || j == a || j == b) {
                            validCases += 2;  // 하나라도 a나 b와 같으면 2를 더함
                        } else {
                            validCases += 4;  // a와 b와 관련 없는 경우는 4를 더함
                        }
                    }
                }
            }
            // 결과를 소수점 3자리까지 출력
            System.out.println(df.format(validCases / (totalCases * 1.0)));
        }

        sc.close();  // Scanner 객체 닫기
    }
}

```

# 💡시간복잡도

O(N)

# 💡 틀린 이유

ex) 접근방식이 틀림, 시간초과, 메모리초과

float형식의 숫자 출력하는 방법에 대해서 몰랐고,

카드가 i나 j가 a, b와 같은 경우와 아예 다른 경우를 구분하지 않아서 틀렸다

```java
   // 카드 i나 j 중 하나라도 a나 b와 같으면 2를 더하고, 그렇지 않으면 4를 더함
                        if (i == a || i == b || j == a || j == b) {
                            validCases += 2;  // 하나라도 a나 b와 같으면 2를 더함
                        } else {
                            validCases += 4;  // a와 b와 관련 없는 경우는 4를 더함
                        }
```

상대방이 이미 가지고 간 카드를 중복해서 가져올 수는 없다.

이 부분을 그리고 아예 같은 숫자는 가져갈 수 없다라고 생각해서 다른 값을 더하는 것이 아닌, 그냥 continue를 해주었다.

# 💡 틀린 부분 수정 or 다른 풀이

# 💡 느낀점 or 기억할정보

```java
 DecimalFormat df = new DecimalFormat("0.000");  // 출력 형식을 소수점 3자리로 설정
```

이렇게 선언해서 사용할 수 있다는 것을 처음 알게 되었다