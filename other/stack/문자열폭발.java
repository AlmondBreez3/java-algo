package java_algo.other.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size()>=target.length()) {
                boolean flag = true;
                for (int j = 0; j < target.length(); j++) {
                    if (stack.get(stack.size()-target.length()+j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < target.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (Character a : stack) {
            sb.append(a);
        }
        System.out.println(sb.length()!=0?sb.toString():"FRULA");
    }
}
