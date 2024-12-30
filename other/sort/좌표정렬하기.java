package java_algo.other.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬하기 {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x,int y) {
            this.x = x;
            this.y=y;
        }

        @Override
        public int compareTo(Node o1) {
            if (x==o1.x) return y-o1.y;
            return x-o1.x;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lis.add(new Node(a,b));
        }
        Collections.sort(lis);

        for (Node a : lis) {
            System.out.println(a.x+" "+a.y);
        }
    }
}
