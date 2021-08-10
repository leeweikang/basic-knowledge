package com.wakeup.算法;

import java.util.Deque;
import java.util.Stack;

public class 比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("#123", "1234#"));
    }
    public static boolean  backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }
    public static String getString(String str) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                stack1.push(str.charAt(i));
            }
            else {
                if(stack1.empty() == false){
                    stack1.pop();
                }
            }
        }
        return stack1.toString();
    }
}
