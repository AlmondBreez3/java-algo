package java_algo.other.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 핸드폰번호궁합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        String temp = sb.toString();

        int[] arr = new int[temp.length()];
        int len = temp.length();
        while(true) {
            if (temp.length()==2) {
                break;
            }

            sb = new StringBuilder();
            for (int i = 0; i < temp.length()-1; i++) {
                String tem1 = temp.substring(i,i+1);
                String tem2 = temp.substring(i+1,i+2);
                int nT = Integer.parseInt(tem1);
                int nT2 = Integer.parseInt(tem2);
               // System.out.println(nT + nT2+" "+ tem1+" "+tem2);
                int tem = nT + nT2;
                int length = String.valueOf(tem).length();
                if (length >= 2) {
                    String val =String.valueOf(nT+nT2).substring(length -1);
                    sb.append(val);
                } else {
                    sb.append(tem);
                }
            }
            temp = sb.toString();

        }

        System.out.println(temp);
//        for (int i = 0; i < temp.length(); i++) {
//            System.out.print(temp.charAt(i)+" ");
//        }
        // System.out.println(temp.toString());

    }
}
