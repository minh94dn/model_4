package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    boolean solution(int[] arg1) {
        for (int i = 1; i < arg1.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += i;
            }
            for (int j = i; j < arg1.length; j++) {
                sum2 += i;
            }
            if(sum1 == sum2){
                return true;
            }
        }
        return false;
    }
}
