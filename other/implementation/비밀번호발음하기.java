package java_algo.other.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            boolean flag = true;
            if(str.equals("end")) {
                break;
            }

            if (str.contains("a") || str.contains("e") || str.contains("i") ||
                    str.contains("o") ||str.contains("u") ) {
                int count = 0;
                int c2 = 1;
                char init = str.charAt(0);
                if (init == 'a' || str.charAt(0) == 'e' ||str.charAt(0) == 'i'
                        ||str.charAt(0) == 'o'||str.charAt(0) == 'u') {
                    count = 1;
                    c2 = 0;
                }
                for (int i = 1; i < str.length(); i++) {

                    if (str.charAt(i) == 'a' || str.charAt(i) == 'e' ||str.charAt(i) == 'i'
                        ||str.charAt(i) == 'o'||str.charAt(i) == 'u'
                    ) {
                        c2 = 0;
                        count++;
                        if (count == 2) {
                            if (init == str.charAt(i)) {
                                if (str.charAt(i) != 'e' && str.charAt(i) != 'o') {
                                    flag = false;
                                    break;
                                }
                            }

                        } else if (count >= 3) {
                            flag = false;
                            break;
                        }
                    } else {
                        count = 0;
                        c2 += 1;
                        if(c2>=3) {
                            flag = false;
                            break;
                        } else if (c2 == 2 && init == str.charAt(i)) {
                            flag = false;
                            break;
                        }
                    }

                    init = str.charAt(i);
                }

            } else {
                flag = false;
            }

            if (flag) {
                sb.append("<").append(str).append(">");
                sb.append(" is acceptable.").append("\n");
            } else {
                sb.append("<").append(str).append(">");
                sb.append(" is not acceptable.").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
