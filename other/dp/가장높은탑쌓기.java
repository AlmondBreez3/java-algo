package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.*;

//class Blick implements Comparable<Blick>{
//
//    public int s;
//    public int h;
//    public int w;
//
//    Blick(int s, int h, int w){
//        this.s = s;
//        this.h = h;
//        this.w = w;
//
//    }
//
//    @Override
//    public int compareTo(Blick o){
//        if(this.w==o.w) {
//            return o.w - this.w;
//        }else{
//            return o.s - this.s;
//        }
//    }
//
//}
//
//public class 가장높은탑쌓기 {
//
//
//    public int solution(int n, ArrayList<Blick>  blick){
//
//        int result = 0;
//
//        int[] dy = new int[n];
//
//        for(int i=0; i<blick.size(); i++){
//
//            dy[i] = blick.get(i).h;
//
//            for(int j=0; j<i; j++){
//
//                if(blick.get(i).w < blick.get(j).w){
//                    dy[i] = Math.max(dy[i],   dy[j] + blick.get(i).h );
//                }
//
//            }
//
//            result = Math.max(result, dy[i]);
//        }
//
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//
//        가장높은탑쌓기 main = new 가장높은탑쌓기();
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//
//        ArrayList<Blick> blick = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            Blick tmp = new Blick(in.nextInt(), in.nextInt(), in.nextInt());
//            blick.add(tmp);
//        }
//
//        Collections.sort(blick);
//
//        System.out.println(main.solution(n, blick));
//    }
//}






public class 가장높은탑쌓기 {
    static class Node implements Comparable<Node> {
        int w;
        int h;
        int p;

        public Node(int w,int h,int p){
            this.w = w;
            this.h = h;
            this.p = p;
        }

        @Override
        public int compareTo(Node o1) {
            if (this.p==o1.p) {
                return o1.p - this.p;
            } else {

                return o1.w-this.w;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            lis.add(new Node(w,h,p));
        }

        Collections.sort(lis);

//        Collections.sort(lis, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if (o1.w == o2.w) {
//                    return o2.p - o1.p;
//                }
//                return o2.w - o1.w;
//            }
//        });
        int[] dp = new int[N];
        for (Node n : lis) {
            System.out.println(n.w);
        }

        // 1. 넓이로 정렬
        // 2. 비교는 무게로
        int max = 0;
        for (int i = 0 ; i < lis.size(); i++) {
            dp[i] = lis.get(i).h;
            for (int j = 0; j < i; j++) {
                if (lis.get(j).p > lis.get(i).p) {
                    dp[i] = Math.max(dp[j]+lis.get(i).h,dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}
