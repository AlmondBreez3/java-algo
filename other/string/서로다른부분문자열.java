package java_algo.other.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 서로다른부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set= new HashSet<>();

        char[] ch = str.toCharArray();

        int count  = 0;

        // substring의 존재를 잊고 있어서 계속 시간 초과 남 substring잊지 말자!
            for (int i = 1; i <= str.length(); i++) {

                for (int k = 0; k < str.length() - i + 1; k++) {
                    String temp = str.substring(k,k+i);

                    if (!set.contains(temp)) {
                        set.add(temp);
                        count++;
                    }
                }
            }



//        for (String c : set) {
//            System.out.println(c);
//        }
        System.out.println(set.size());

    }
}
