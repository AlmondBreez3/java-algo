package java_algo.other.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로
{  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
        int temp = Integer.parseInt(br.readLine());
        if (temp==0) {
            if(!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(temp);
        }
    }

    if (!stack.isEmpty()) {
        int count = 0;
        for (int i : stack) {
            count += i;
        }
        System.out.println(count);
    } else {
        System.out.println(0);
    }
}
}
