package java_algo.other.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;

public class 팰린드롬만들기
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int tem = str.length()-1;
        String temS = str;
        int count= 0;
        int start = 0;

//        for (int i = 0; i < str.length();i++) {
//            if (check(str)) break;
//            count++;
//        }
//        while(start <= tem) {
//
//            if (str.charAt(tem) != str.charAt(start)){
//                str += str.charAt(start);
//            }
//            tem -= 1;
//            start += 1;
//
//            if (check(str)) {
//                break;
//            }
//
//        }
        System.out.println(str);
    }
    public static boolean check(String str) {
        int start = 0;
        int last = str.length()-1;
        while(start<=last){
            if(str.charAt(start) != str.charAt(last)) return false;

            start++;
            last--;
        }

        return true;
    }
}
