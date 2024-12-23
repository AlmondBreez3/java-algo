package java_algo.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondWeek {
    public static void main(String[] args) {
        상호평가 s = new 상호평가();
        int[][] arr1 ={{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(s.main(arr1));
        int[][] arr2 = {{50,90},{50,87}};
        System.out.println(s.main(arr2));
        int[][] arr3 = {{70,49,90},{68,50,38},{73,31,100}};
        System.out.println(s.main(arr3));
    }
}

