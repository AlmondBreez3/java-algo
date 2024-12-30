package java_algo.other.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 안정적문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int j = 1;
        while(true) {
            String str = br.readLine();
            if (str.contains("-")|| str==null) {
                break;
            }

            char[] ch = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for(int i = 0; i < ch.length; i++) {
                if (ch[i]=='{') {
                    stack.push('{');
                } else {
                    if (!stack.isEmpty() && stack.peek() =='{') {
                        stack.pop();
                    } else {
                        count++;
                        stack.push('{');
                    }
                }
            }

//            if (!stack.isEmpty()) {
//                if (stack.size() % 2==0) {
//
//                    int temp = stack.size()/2;
//                    count += temp;
//                } else {
//                    count += stack.size();
//                }
//            }
            int temp = stack.size()/2;
            count += temp;
            System.out.println((j)+". "+count);
            j++;
        }
    }
}
