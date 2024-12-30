package java_algo.other.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        int answ  = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else {
                if (i - stack.peek() <= 1) {
                    stack.pop();
                    lis.add(i);
                } else {
                    int temp = check(lis,i,stack.peek()) + 1;

                    int diff = i - stack.pop();
                    answ += temp;
                }
            }
        }

        System.out.println(answ);
    }
    public static int check(List<Integer> list, int end, int start) {
        int count = 0;
        for (int i : list) {
            if (i >= start && i <= end) {
                count += 1;
            }
        }
        return count;
    }
}
