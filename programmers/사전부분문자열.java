package java_algo.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 사전부분문자열 {

    static List<String> string = new ArrayList<>();
    static String str;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length()];

        for (int i = 1; i <= str.length();i++) {
            for (int j = 0; j <= str.length()-i; j++) {
                dfs(j,0,i,new StringBuilder());
            }
        }
        Collections.sort(string);
        System.out.println(string);
        System.out.println(string.get(string.size()-1));
    }
    public static void dfs(int idx,int depth,int x,StringBuilder sb) {
        if(x==depth) {
            string.add(sb.toString());
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                sb.append(str.charAt(i));
                dfs(i,depth+1,x,sb);
                sb.deleteCharAt(sb.length()-1);
                visited[i]=false;
            }
        }
    }
}
