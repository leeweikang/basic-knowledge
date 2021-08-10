package com.wakeup.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class B
{
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块B");
    }
    static {
        System.out.println("静态块B");
    }


    public static void main(String[] args)
    {
        C t = new C();
        ArrayDeque a;
    }
}
class C extends B{
    static {
        System.out.println("静态块C");
    }
    {
        System.out.println("构造块C");
    }
}