package java_algo.study.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 올바른괄호 {
    public void solution(String str) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (Character ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        // 여는 괄호가 많은 상황
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
//    public void solution(String str) {
//        Stack<Character> stack = new Stack<>();
//
//        int count = 0;
//        for (Character ch : str.toCharArray()) {
//            if (ch == '(') {
//                stack.push(ch);
//            } else if (ch == ')') {
//                if (stack.isEmpty()) {
//                    count++;
//                    continue;
//                }
//                Character temp = stack.peek();
//                if (temp=='(') {
//                    stack.pop();
//                }
//            }
//        }
//
//        if (stack.isEmpty()) {
//            if (count > 0) {
//                System.out.println("NO");
//                return;
//            }
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//    }
    public static void main(String[] args) throws IOException {
        올바른괄호 T = new 올바른괄호();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        T.solution(str);
    }
}